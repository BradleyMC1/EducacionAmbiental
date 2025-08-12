package control;

import java.util.List;
import modelo.ModeloRendimientoAcademico;

public final class ControlRendimientoAcademico {

    public static class Estudiante {
        public final String nombre;
        public final int porcentaje;
        public final boolean pasaNivel;
        public final boolean mantieneNivel;

        public Estudiante(String nombre, int porcentaje,
                          boolean pasa, boolean mantiene) {
            this.nombre = nombre;
            this.porcentaje = porcentaje;
            this.pasaNivel = pasa;
            this.mantieneNivel = mantiene;
        }
    }

    public static boolean agregarEstudiante(String nombre, int porcentaje,
                                            boolean pasa, boolean mantiene) {

        if (nombre == null || nombre.isBlank()) return false;
        if (porcentaje < 0 || porcentaje > 100) return false;
        if (!pasa && !mantiene) return false;
        if (pasa && mantiene) return false;

        return ModeloRendimientoAcademico.guardarEstudiante(
            nombre.trim(), porcentaje, pasa, mantiene);
    }

    public static List<Estudiante> obtenerEstudiantes() {
        return ModeloRendimientoAcademico.obtenerEstudiantes();
    }

    public static void limpiar() {
        // opcional: no necesario si trabajas con BD
    }

    private ControlRendimientoAcademico() {}
}
