package Ejercicio_1;
import java.io.IOException;
public class Main {
    public static void main(String[] args) {
        AppExcepciones app = new AppExcepciones();
        boolean ejecutando = true;

        System.out.println("--- PROGRAMA DE LECTURA DE CARACTERES ---");
        System.out.println("Ingresa caracteres uno por uno y presiona Enter.");
        System.out.println("(Ingresa la letra 'q' para salir del programa)");
        System.out.println("-----------------------------------------");

        while (ejecutando) {
            try {
                app.procesar();
                
            } catch (ExcepcionVocal e) {
                System.out.println("[Excepción] " + e.getMessage());
                
            } catch (ExcepcionNumero e) {
                System.out.println("[Excepción] " + e.getMessage());
                
            } catch (ExcepcionBlanco e) {
                System.out.println("[Excepción] " + e.getMessage());
                
            } catch (ExcepcionSalida e) {
                System.out.println("\n[FIN DEL PROGRAMA] " + e.getMessage());
                ejecutando = false; 
                
            } catch (IOException e) {
                System.out.println("Error de Lectura (E/S): " + e.getMessage());
            }
        }
    }
}
