package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import control.ControlRendimientoAcademico;

public final class ModeloRendimientoAcademico {

    /* Conexión a SQL Server */
    private static final String URL  =
        "jdbc:sqlserver://localhost:1433;"
      + "databaseName=EducacionAmbiental;"
      + "encrypt=true;trustServerCertificate=true";
    private static final String USER = "sa";
    private static final String PASS = "123456789a";

    /* ------------------------------------------------------------
       GUARDAR Estudiante
       ------------------------------------------------------------ */
    public static boolean guardarEstudiante(String nombre, int porcentaje,
                                            boolean pasa, boolean mantiene) {

        try (Connection cn = DriverManager.getConnection(URL, USER, PASS)) {
            cn.setAutoCommit(false);

            /* 1. Insertar USUARIO (nombre completo) */
            int idUsuario;
            String insUser = """
                INSERT INTO DIMENSION_USUARIO (Nombre, Apellidos, Correo, Contraseña)
                VALUES (?,?,?,?)
                """;
            try (PreparedStatement ps = cn.prepareStatement(
                    insUser, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, nombre.trim());
                ps.setString(2, "");                         // apellidos vacíos
                ps.setString(3, nombre.toLowerCase().replace(" ","")
                               + "@estudiante.com");
                ps.setString(4, "123");                      // contraseña simple
                ps.executeUpdate();
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    idUsuario = rs.next() ? rs.getInt(1) : -1;
                }
            }

            /* 2. Insertar PROGRESO (porcentaje) */
            int idProgreso;
            String insProg = """
                INSERT INTO DIMENSION_PROGRESO
                       (Porcentaje, FechaInicio, FechaActualizada)
                VALUES (?, GETDATE(), GETDATE())
                """;
            try (PreparedStatement ps = cn.prepareStatement(
                    insProg, Statement.RETURN_GENERATED_KEYS)) {
                ps.setBigDecimal(1, new java.math.BigDecimal(porcentaje));
                ps.executeUpdate();
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    idProgreso = rs.next() ? rs.getInt(1) : -1;
                }
            }

            /* 3. Insertar registro en HECHOS_RENDIMIENTO */
            String insHecho = """
                INSERT INTO HECHOS_RENDIMIENTO
                       (NivelAcademico,
                        Porcentaje_de_Pasar,
                        Porcentaje_de_Quedarse,
                        FechaEvaluada,
                        ProgresoGlobal,
                        ID_Usuario,
                        ID_Progreso,
                        ID_Modulo)
                VALUES (?,?,?,?,?,?,?, NULL)     -- ID_Modulo nulo (no aplica)
                """;
            try (PreparedStatement ps = cn.prepareStatement(insHecho)) {
                ps.setString(1, "Nivel 1");
                ps.setBigDecimal(2, pasa     ? new java.math.BigDecimal(porcentaje) : java.math.BigDecimal.ZERO);
                ps.setBigDecimal(3, mantiene ? new java.math.BigDecimal(porcentaje) : java.math.BigDecimal.ZERO);
                ps.setDate(4, new java.sql.Date(System.currentTimeMillis()));
                ps.setBigDecimal(5, new java.math.BigDecimal(porcentaje));
                ps.setInt(6, idUsuario);
                ps.setInt(7, idProgreso);
                ps.executeUpdate();
            }

            cn.commit();
            return true;

        } catch (SQLException ex) {
            System.err.println("❌ Error al guardar Rendimiento: " + ex.getMessage());
            return false;
        }
    }

    /* ------------------------------------------------------------
       OBTENER lista para la interfaz
       ------------------------------------------------------------ */
    public static List<ControlRendimientoAcademico.Estudiante> obtenerEstudiantes() {

        List<ControlRendimientoAcademico.Estudiante> lista = new ArrayList<>();

        String sql = """
            SELECT u.Nombre,
                   p.Porcentaje,
                   CASE WHEN h.Porcentaje_de_Pasar    > 0 THEN 1 ELSE 0 END AS Pasa,
                   CASE WHEN h.Porcentaje_de_Quedarse > 0 THEN 1 ELSE 0 END AS Mantiene
            FROM   HECHOS_RENDIMIENTO h
            JOIN   DIMENSION_USUARIO  u ON u.ID_Usuario  = h.ID_Usuario
            JOIN   DIMENSION_PROGRESO p ON p.ID_Progreso = h.ID_Progreso
            ORDER  BY h.ID_Rendimiento DESC
            """;

        try (Connection cn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(new ControlRendimientoAcademico.Estudiante(
                        rs.getString("Nombre"),
                        rs.getInt   ("Porcentaje"),
                        rs.getInt   ("Pasa")     == 1,
                        rs.getInt   ("Mantiene") == 1
                ));
            }

        } catch (SQLException ex) {
            System.err.println("❌ Error al obtener Rendimiento: " + ex.getMessage());
        }
        return lista;
    }

    /* ------------------------------------------------------------
       ELIMINAR por nombre (opcional)
       ------------------------------------------------------------ */
    public static boolean eliminarPorNombre(String nombre) {
        String sql = """
            DELETE h
            FROM   HECHOS_RENDIMIENTO h
            JOIN   DIMENSION_USUARIO  u ON u.ID_Usuario = h.ID_Usuario
            WHERE  u.Nombre = ?
            """;
        try (Connection cn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setString(1, nombre);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.err.println("❌ Error al eliminar: " + ex.getMessage());
            return false;
        }
    }

    private ModeloRendimientoAcademico() {} // no instanciable
}
