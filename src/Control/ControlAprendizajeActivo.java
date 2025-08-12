package control;

import java.util.List;
import modelo.ModeloAprendizajeActivo;

public final class ControlAprendizajeActivo {

    public static class Modulo {
        public final int numero;
        public final String descripcion;
        public final int progresoInicial;
        public final int progresoMeta;

        public Modulo(int numero, String descripcion, int progresoInicial, int progresoMeta) {
            this.numero = numero;
            this.descripcion = descripcion;
            this.progresoInicial = progresoInicial;
            this.progresoMeta = progresoMeta;
        }
    }

    public static boolean agregarModulo(int numero, String descripcion, int progresoIni, int progresoMeta) {
        if (numero < 1 || numero > 8) return false;
        if (descripcion == null || descripcion.isBlank()) return false;
        if (progresoIni < 0 || progresoIni > 100) return false;
        if (progresoMeta <= progresoIni || progresoMeta > 100) return false;

        return ModeloAprendizajeActivo.guardarModulo(numero, descripcion, progresoIni, progresoMeta);
    }

    public static List<Modulo> obtenerModulos() {
        return ModeloAprendizajeActivo.obtenerModulos();
    }

    public static boolean eliminarModulo(int numero) {
        return ModeloAprendizajeActivo.eliminarModulo(numero);
    }

    private ControlAprendizajeActivo() {}
}
