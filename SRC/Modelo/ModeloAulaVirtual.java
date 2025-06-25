package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/** Acceso a BD para “Ingreso de Datos Aula Virtual”. */
public final class ModeloAulaVirtual {

    /*  Ajusta tu conexión */
    private static final String URL =
        "jdbc:sqlserver://localhost:1433;"
      + "databaseName=EducacionAmbiental;"
      + "encrypt=true;trustServerCertificate=true";
    private static final String USER = "sa";
    private static final String PASS = "123456789a";

    /* ───────────── POJO que la interfaz usará ───────────── */
    public static class FichaModulo {
        public final int    idProgreso;
        public final String profesor;
        public final String curso;
        public final String titulo;
        public final String subtitulo;
        public final String descripcion;

        public FichaModulo(int id, String prof, String cur,
                           String tit, String sub, String des) {
            idProgreso   = id;
            profesor     = prof;
            curso        = cur;
            titulo       = tit;
            subtitulo    = sub;
            descripcion  = des;
        }
    }

    /* ───────────────────────────────────────────────────────
       INSERTAR (formulario «Ingreso de Datos Aula Virtual»)
       ─────────────────────────────────────────────────────── */
    public static boolean guardar(
        String profesor, String curso,
        String titulo,   String subtitulo, String descripcion) {

        /* 1. Validaciones básicas */
        if (profesor == null || profesor.isBlank())    return false;
        if (curso    == null || curso.isBlank())       return false;
        if (titulo   == null || titulo.isBlank())      return false;
        if (subtitulo== null || subtitulo.isBlank())   return false;
        if (descripcion == null || descripcion.isBlank()) return false;

        try (Connection cn = DriverManager.getConnection(URL, USER, PASS)) {
            cn.setAutoCommit(false);

            /* 2. DOCENTE → buscar o crear */
            int idDocente = obtenerIdDocente(cn, profesor.trim(), curso.trim());

            /* 3. PROGRESO → insertar registro */
            String insPro = """
                INSERT INTO DIMENSION_PROGRESO
                       (Porcentaje, FechaInicio, FechaActualizada,
                        Titulo, Subtitulo, Descripcion, ID_Docente)
                VALUES (0, GETDATE(), GETDATE(), ?, ?, ?, ?)
                """;
            try (PreparedStatement ps = cn.prepareStatement(insPro)) {
                ps.setString(1, titulo.trim());
                ps.setString(2, subtitulo.trim());
                ps.setString(3, descripcion.trim());
                ps.setInt   (4, idDocente);
                ps.executeUpdate();
            }

            cn.commit();
            return true;

        } catch (SQLException ex) {
            System.err.println("❌ Error al guardar AulaVirtual: " + ex.getMessage());
            return false;
        }
    }

    /* ───────────────────────────────────────────────────────
       LISTAR módulos para mostrarlos en la interfaz
       ─────────────────────────────────────────────────────── */
    public static List<FichaModulo> obtenerModulos() {
        List<FichaModulo> lista = new ArrayList<>();

        String sql = """
            SELECT p.ID_Progreso,
                   d.Nombre      AS Profesor,
                   d.Curso,
                   p.Titulo,
                   p.Subtitulo,
                   p.Descripcion
            FROM   DIMENSION_PROGRESO  p
            JOIN   DIMENSION_DOCENTE   d ON d.ID_Docente = p.ID_Docente
            ORDER  BY p.ID_Progreso DESC
            """;

        try (Connection cn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(new FichaModulo(
                    rs.getInt("ID_Progreso"),
                    rs.getString("Profesor"),
                    rs.getString("Curso"),
                    rs.getString("Titulo"),
                    rs.getString("Subtitulo"),
                    rs.getString("Descripcion")));
            }

        } catch (SQLException ex) {
            System.err.println("❌ Error al obtener módulos: " + ex.getMessage());
        }
        return lista;
    }

    /* ───────────────────────────────────────────────────────
       ELIMINAR un módulo por ID_Progreso
       ─────────────────────────────────────────────────────── */
    public static boolean eliminar(int idProgreso) {
        try (Connection cn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = cn.prepareStatement(
                 "DELETE FROM DIMENSION_PROGRESO WHERE ID_Progreso = ?")) {
            ps.setInt(1, idProgreso);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.err.println("❌ Error al eliminar: " + ex.getMessage());
            return false;
        }
    }

    /* ═════════════ utilidades internas ═════════════ */

    /** Devuelve ID_Docente: crea uno nuevo si no existe ya con mismo nombre/curso. */
    private static int obtenerIdDocente(Connection cn,
                                        String profesor, String curso) throws SQLException {

        String sel = """
            SELECT ID_Docente
            FROM   DIMENSION_DOCENTE
            WHERE  Nombre = ? AND Curso = ?
            """;
        try (PreparedStatement ps = cn.prepareStatement(sel)) {
            ps.setString(1, profesor);
            ps.setString(2, curso);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return rs.getInt(1);
            }
        }

        /* Si no existe: insertarlo */
        String ins = """
            INSERT INTO DIMENSION_DOCENTE (Nombre, Apellidos, Correo, Contraseña, Curso)
            VALUES (?,?,?,? ,?)
            """;
        try (PreparedStatement ps = cn.prepareStatement(ins, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, profesor);
            ps.setString(2, "");                 // Apellidos (vacío)
            ps.setString(3, profesor.toLowerCase().replace(" ", "") + "@correo.com");
            ps.setString(4, "123");              // contraseña simple
            ps.setString(5, curso);
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                return rs.next() ? rs.getInt(1) : -1;
            }
        }
    }

    private ModeloAulaVirtual() {}     // no instanciable
}
