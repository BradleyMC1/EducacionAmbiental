package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import control.ControlAprendizajeActivo;

/**
 *  Acceso a BD para los 8 módulos de Aprendizaje Activo.
 *  ▸ Inserta / lista / elimina en la tabla DIM_ACTIVIDAD.
 *  ▸ El Nº de módulo (1-8) lo indica el usuario en la interfaz.
 */
public final class ModeloAprendizajeActivo {

    /* Ajusta datos de conexión a tu SQL Server */
    private static final String URL  =
            "jdbc:sqlserver://localhost:1433;"
          + "databaseName=EducacionAmbiental;"
          + "encrypt=true;trustServerCertificate=true";
    private static final String USER = "sa";
    private static final String PASS = "123456789a";

    /* ───────────────────────────────────────────────
       INSERTAR NUEVO MÓDULO (número 1-8 elegido en la vista)
       ─────────────────────────────────────────────── */
    public static boolean guardarModulo(int numero,
                                        String descripcion,
                                        int progresoIni,
                                        int progresoMeta) {

        /* Validaciones básicas */
        if (numero < 1 || numero > 8)              return false;
        if (descripcion == null || descripcion.isBlank())
                                                   return false;
        if (progresoIni  < 0 || progresoIni  > 100) return false;
        if (progresoMeta < 0 || progresoMeta > 100) return false;
        if (progresoMeta < progresoIni)             return false;

        String existe = "SELECT COUNT(*) FROM DIM_ACTIVIDAD WHERE Numero = ?";
        String insert = """
            INSERT INTO DIM_ACTIVIDAD
                   (Numero, Descripcion, ProgresoInicial, ProgresoMeta)
            VALUES (?,?,?,?)
            """;

        try (Connection cn = DriverManager.getConnection(URL, USER, PASS)) {

            /* ¿Ya existe ese número? */
            try (PreparedStatement chk = cn.prepareStatement(existe)) {
                chk.setInt(1, numero);
                try (ResultSet rs = chk.executeQuery()) {
                    if (rs.next() && rs.getInt(1) > 0) return false; // duplicado
                }
            }

            /* Insertar */
            try (PreparedStatement ps = cn.prepareStatement(insert)) {
                ps.setInt   (1, numero);
                ps.setString(2, descripcion.trim());
                ps.setInt   (3, progresoIni);
                ps.setInt   (4, progresoMeta);
                ps.executeUpdate();
            }
            return true;

        } catch (SQLException ex) {
            System.err.println("❌ Error al guardar en DIM_ACTIVIDAD: " + ex.getMessage());
            return false;
        }
    }

    /* ───────────────────────────────────────────────
       LISTAR HASTA 8 MÓDULOS PARA LA INTERFAZ
       ─────────────────────────────────────────────── */
    public static List<ControlAprendizajeActivo.Modulo> obtenerModulos() {

        List<ControlAprendizajeActivo.Modulo> lista = new ArrayList<>();

        String sql = """
            SELECT Numero, Descripcion, ProgresoInicial, ProgresoMeta
            FROM   DIM_ACTIVIDAD
            WHERE  Numero BETWEEN 1 AND 8
            ORDER  BY Numero
            """;

        try (Connection cn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(new ControlAprendizajeActivo.Modulo(
                        rs.getInt ("Numero"),
                        rs.getString("Descripcion"),
                        rs.getInt ("ProgresoInicial"),
                        rs.getInt ("ProgresoMeta")));
            }

        } catch (SQLException ex) {
            System.err.println("❌ Error al leer DIM_ACTIVIDAD: " + ex.getMessage());
        }
        return lista;
    }

    /* ───────────────────────────────────────────────
       ELIMINAR MÓDULO POR NÚMERO (1-8)
       ─────────────────────────────────────────────── */
    public static boolean eliminarModulo(int numero) {
        if (numero < 1 || numero > 8) return false;

        String sql = "DELETE FROM DIM_ACTIVIDAD WHERE Numero = ?";
        try (Connection cn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, numero);
            return ps.executeUpdate() > 0;

        } catch (SQLException ex) {
            System.err.println("❌ Error al eliminar: " + ex.getMessage());
            return false;
        }
    }

    /* Evita instanciación */
    private ModeloAprendizajeActivo() {}
}
