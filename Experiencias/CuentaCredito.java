package Package;

public class CuentaCredito extends CuentaBancaria{
	private double limiteCredito;
	public CuentaCredito(String numeroCuenta, String titular, double saldo, double limiteCredito) {
		super(numeroCuenta, titular, saldo);
		this.limiteCredito = limiteCredito;
	}
	@Override
	public void retirar (double monto) throws SaldoInsuficienteException{
		if(monto <= 0) {
			throw new IllegalArgumentException("El monto a retirar debe ser mayor a cero.");
		}
		double saldoDisponible = this.saldo + limiteCredito;
		if(monto > saldoDisponible) {
			throw new LimiteCreditoExcedidoException("Error: Límite de credito excedido. Tu límite extra es de $" + limiteCredito);
		}
		this.saldo -= monto;
		System.out.println("Retiro exitoso (Cuenta de Credito). Nuevo Saldo: $" + this.saldo);
	}
}
