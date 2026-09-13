package Ejercicio_4;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RegistroEstudiantes registro = new RegistroEstudiantes(10);
        Scanner scanner = new Scanner(System.in);
        boolean ejecutando = true;

        System.out.println("--- SISTEMA DE REGISTRO DE ESTUDIANTES ---");

        while (ejecutando) {
            System.out.println("\n1. Agregar estudiante");
            System.out.println("2. Buscar estudiante");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("Ingresa el nombre del estudiante: ");
                    String nombreAgregar = scanner.nextLine();
                    
                    try {
                        registro.agregarEstudiante(nombreAgregar);
                        System.out.println("¡Estudiante agregado exitosamente!");
                        
                    } catch (IllegalArgumentException e) {
                        System.err.println("Excepción Atrapada [IllegalArgumentException]: " + e.getMessage());
                        
                    } catch (IllegalStateException e) {
                        System.err.println("Excepción Atrapada: " + e.getMessage());
                    }
                    break;
                    
                case "2":
                    System.out.print("Ingresa el nombre a buscar: ");
                    String nombreBuscar = scanner.nextLine();
                    
                    try {
                        String encontrado = registro.buscarEstudiante(nombreBuscar);
                        System.out.println("Resultado: El estudiante '" + encontrado + "' SÍ está registrado.");
                        
                    } catch (NoSuchElementException e) {
                        System.err.println("Excepción Atrapada [NoSuchElementException]: " + e.getMessage());
                    }
                    break;
                    
                case "3":
                    ejecutando = false;
                    System.out.println("Saliendo del programa...");
                    break;
                    
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }
        
        scanner.close();
    }
}