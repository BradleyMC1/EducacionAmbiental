package control;

import java.util.List;
import modelo.ModeloAulaVirtual;

/**
 * Control central del Aula Virtual.
 *
 * ▸ Valida campos requeridos.
 * ▸ Delega almacenamiento y lectura a ModeloAulaVirtual (BD).
 * ▸ Mantiene el límite de 20 módulos().
 */
public final class ControlAulaVirtual {

    /*  POJO que la Vista utilizará */
    public static class Modulo {
        public final int    id;          // ID_Progreso
        public final String profesor;
        public final String curso;
        public final String titulo;
        public final String subtitulo;
        public final String descripcion;

        public Modulo(int id, String prof, String cur,
                      String tit, String sub, String des) {
            this.id          = id;
            this.profesor    = prof;
            this.curso       = cur;
            this.titulo      = tit;
            this.subtitulo   = sub;
            this.descripcion = des;
        }
    }

    /* -------------------------------------------------
       Insertar módulo (formulario “Ingreso Datos Aula”)
       ------------------------------------------------- */
    public static boolean registrarModulo(String profesor,
                                          String curso,
                                          String titulo,
                                          String subtitulo,
                                          String descripcion) {

        /* Validación de campos (CC nodos #1-#5) */
        if (profesor    == null || profesor.isBlank())    return false;
        if (curso       == null || curso.isBlank())       return false;
        if (titulo      == null || titulo.isBlank())      return false;
        if (subtitulo   == null || subtitulo.isBlank())   return false;
        if (descripcion == null || descripcion.isBlank()) return false;

        /* Límite de 20 registros en total */
        if (obtenerModulos().size() >= 20) return false;

        /* Delegamos la inserción a ModeloAulaVirtual  */
        return ModeloAulaVirtual.guardar(
                profesor.trim(),
                curso.trim(),
                titulo.trim(),
                subtitulo.trim(),
                descripcion.trim());
    }

    /* -------------------------------------------------
       Listar módulos para la interfaz
       ------------------------------------------------- */
    public static List<ModeloAulaVirtual.FichaModulo> obtenerModulos() {
        return ModeloAulaVirtual.obtenerModulos();
    }

    /* -------------------------------------------------
       Eliminar módulo por ID_Progreso (botón “Eliminar”)
       ------------------------------------------------- */
    public static boolean eliminarModulo(int idProgreso) {
        return ModeloAulaVirtual.eliminar(idProgreso);
    }

    private ControlAulaVirtual() {}  // no instanciable
}
