package Package;

public class LimiteCreditoExcedidoException extends SaldoInsuficienteException{
	public LimiteCreditoExcedidoException(String mensaje) {
		super(mensaje);
	}
}
