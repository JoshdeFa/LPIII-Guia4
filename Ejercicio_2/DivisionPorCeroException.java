package Ejercicio_2;

public class DivisionPorCeroException extends ArithmeticException {
    public DivisionPorCeroException(String mensaje) {
        super(mensaje);
    }
}