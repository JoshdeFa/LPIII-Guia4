package Ejercicio_4;
import java.util.NoSuchElementException;

public class RegistroEstudiantes {
    
    private String[] estudiantes;
    private int cantidad;

    public RegistroEstudiantes(int capacidad) {
        estudiantes = new String[capacidad];
        cantidad = 0;
    }
    public void agregarEstudiante(String nombre) {

        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del estudiante no puede ser nulo o vacío.");
        }
        
        if (cantidad >= estudiantes.length) {
            throw new IllegalStateException("El registro de estudiantes está lleno.");
        }
        
        estudiantes[cantidad] = nombre;
        cantidad++;
    }
    public String buscarEstudiante(String nombre) {
        for (int i = 0; i < cantidad; i++) {
            // Comparamos ignorando mayúsculas y minúsculas
            if (estudiantes[i].equalsIgnoreCase(nombre)) {
                return estudiantes[i];
            }
        }
        
        throw new NoSuchElementException("El estudiante '" + nombre + "' no se encuentra en el registro.");
    }
}
