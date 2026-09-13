package Ejercicio_3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Numero miNumero = new Numero();
        
        System.out.println("--- GESTIÓN DE NÚMEROS POSITIVOS ---");

        try {
            System.out.print("Ingresa un número positivo: ");
            double valorIngresado = Double.parseDouble(scanner.nextLine());
            
            miNumero.setValor(valorIngresado);
            
            System.out.println("¡Éxito! El valor guardado es: " + miNumero.getValor());

        } catch (IllegalArgumentException e) {

            System.err.println("Excepción Atrapada: " + e.getMessage());
            
        } catch (Exception e) {

            System.err.println("Error genérico: Formato numérico incorrecto.");
            
        } finally {
            scanner.close();
            System.out.println("Programa finalizado.");
        }
    }
}
