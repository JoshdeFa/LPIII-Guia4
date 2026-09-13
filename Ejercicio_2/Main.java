package Ejercicio_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculadora calc = new Calculadora();
        
        System.out.println("--- CALCULADORA BÁSICA ---");

        try {
            System.out.print("Ingresa el primer número: ");
            double num1 = Double.parseDouble(scanner.nextLine()); 
            
            System.out.print("Ingresa el segundo número: ");
            double num2 = Double.parseDouble(scanner.nextLine());
            
            System.out.print("Elige la operación (+, -, *, /): ");
            String operacion = scanner.nextLine();

            double resultado = 0;
            boolean operacionValida = true;

            switch (operacion) {
                case "+":
                    resultado = calc.sumar(num1, num2);
                    break;
                case "-":
                    resultado = calc.restar(num1, num2);
                    break;
                case "*":
                    resultado = calc.multiplicar(num1, num2);
                    break;
                case "/":
                    resultado = calc.dividir(num1, num2); 
                    break;
                default:
                    throw new IllegalArgumentException("Operación no válida: '" + operacion + "'");
            }

            if(operacionValida) {
                System.out.println("El resultado es: " + resultado);
            }

        } catch (DivisionPorCeroException e) {
            System.err.println("Excepción Personalizada Atrapada: " + e.getMessage());
            
        } catch (ArithmeticException e) {
            System.err.println("Excepción Aritmética Atrapada: " + e.getMessage());
            
        } catch (IllegalArgumentException e) {
            System.err.println("Argumento Ilegal Atrapado: " + e.getMessage());
            
        } finally {
            scanner.close();
            System.out.println("Calculadora finalizada.");
        }
    }
}
