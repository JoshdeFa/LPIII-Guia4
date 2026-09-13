package Ejercicio_3;

public class Numero {
    
    // Atributo
    private double valor;

    // Constructor vacío
    public Numero() {
    }
    
    // Constructor con validación
    public Numero(double valorInicial) {
        setValor(valorInicial);
    }

    // Método para obtener el valor (Getter)
    public double getValor() {
        return valor;
    }

    // Método para establecer el valor con validación (Setter)
    public void setValor(double valor) {
        // Validamos que el valor no sea negativo
        if (valor < 0) {
            throw new IllegalArgumentException("Error: El valor no puede ser negativo (" + valor + ").");
        }
        // Si pasa la validación, asignamos el valor
        this.valor = valor;
    }
}
