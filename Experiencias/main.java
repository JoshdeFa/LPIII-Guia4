package Package;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.FileNotFoundException;
import java.io.IOException;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CuentaBancaria miCuenta = null; 
        CuentaBancaria cuentaDestino = new CuentaBancaria("999", "Carlos (Destino)", 0);
        ReporteTransacciones gestorReportes = new ReporteTransacciones();
        boolean tieneTransacciones = false; 
        int opcion = 0;

        do {
            System.out.println("\n====== SISTEMA BANCARIO ======");
            System.out.println("1. Crear Nueva Cuenta");
            System.out.println("2. Depositar Dinero");
            System.out.println("3. Retirar Dinero");
            System.out.println("4. Consultar Saldo");
            System.out.println("5. Transferir a Carlos (Cuenta 999)");
            System.out.println("6. Cerrar Mi Cuenta");
            System.out.println("7. Generar Reporte de Transacciones");
            System.out.println("8. Leer Reporte desde Archivo");
            System.out.println("9. Salir");
            System.out.print("Elige una opción (1-9): ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.println("\n--- CREAR CUENTA ---");
                        System.out.print("Número de cuenta: ");
                        String numero = scanner.nextLine();
                        System.out.print("Nombre del titular: ");
                        String titular = scanner.nextLine();
                        System.out.print("Saldo inicial: ");
                        double saldo = scanner.nextDouble();
                        
                        // Usamos CuentaCredito (Experiencia 3) con un límite por defecto de 500
                        miCuenta = new CuentaCredito(numero, titular, saldo, 500);
                        tieneTransacciones = false; // Al crear, el historial está vacío
                        System.out.println("¡Cuenta creada con éxito! Tienes un límite de crédito de $500.");
                        break;

                    case 2:
                        if (miCuenta == null) { System.out.println("Error: Crea una cuenta primero."); break; }
                        System.out.print("Monto a depositar: ");
                        double deposito = scanner.nextDouble();
                        miCuenta.depositar(deposito);
                        tieneTransacciones = true; 
                        break;

                    case 3:
                        if (miCuenta == null) { System.out.println("Error: Crea una cuenta primero."); break; }
                        System.out.print("Monto a retirar: ");
                        double retiro = scanner.nextDouble();
                        miCuenta.retirar(retiro);
                        tieneTransacciones = true; 
                        break;

                    case 4:
                        if (miCuenta == null) { System.out.println("Error: Crea una cuenta primero."); break; }
                        System.out.println("\nTitular: " + miCuenta.getTitular());
                        System.out.println("Saldo actual: $" + miCuenta.getSaldo());
                        break;
                        
                    case 5:
                        if (miCuenta == null) { System.out.println("Error: Crea una cuenta primero."); break; }
                        System.out.print("Monto a transferir: ");
                        double montoTransferencia = scanner.nextDouble();
                        miCuenta.transferir(cuentaDestino, montoTransferencia);
                        tieneTransacciones = true; 
                        break;
                        
                    case 6:
                        if (miCuenta == null) { System.out.println("Error: Crea una cuenta primero."); break; }
                        miCuenta.cerrarCuenta();
                        miCuenta = null; 
                        tieneTransacciones = false;
                        break;
                        
                    case 7:
                        if (miCuenta == null) { System.out.println("Error: Crea una cuenta primero."); break; }
                        
                        gestorReportes.generarReporte(miCuenta, tieneTransacciones);
                        break;
                        
                    case 8:
                        System.out.print("Ingresa el nombre del archivo a leer (ej. Reporte_Juan.txt): ");
                        String nombreArchivo = scanner.nextLine();
                        gestorReportes.leerReporte(nombreArchivo);
                        break;

                    case 9:
                        System.out.println("Cerrando recursos y saliendo del sistema. ¡Hasta luego!");
                        break;

                    default:
                        System.out.println("Opción no válida. Intenta de nuevo.");
                }

            // ---EXCEPCIONES---
            } catch (InputMismatchException e) {
                System.out.println("Error de formato: Debes ingresar un número válido.");
                scanner.nextLine(); 
            } catch (IllegalArgumentException e) {
                System.out.println("Error de validación: " + e.getMessage());
            } catch (LimiteCreditoExcedidoException e) {
                System.out.println("Alerta de Crédito: " + e.getMessage());
            } catch (SaldoInsuficienteException e) {
                System.out.println("Operación denegada: " + e.getMessage());
            } catch (CuentaNoEncontradaException e) {
                System.out.println("Error de transferencia: " + e.getMessage());
            } catch (SaldoNoCeroException e) {
                System.out.println("No se pudo cerrar la cuenta: " + e.getMessage());
            } catch (HistorialVacioException e) {
                System.out.println("Error al generar reporte: " + e.getMessage());
            } catch (FileNotFoundException e) {
                System.out.println("Error de lectura: El archivo especificado no existe en el sistema.");
            } catch (IOException e) {
                System.out.println("Error del sistema de archivos: No se pudo guardar el reporte.");
            }

        } while (opcion != 9);
        
        scanner.close();
    }
}