package Package;

public class CuentaBancaria {
	private String numeroCuenta;
	private String titular;
	protected double saldo;
	
	public CuentaBancaria(String numeroCuenta, String titular, double saldo) {
		if(saldo<0) {
			throw new IllegalArgumentException("El saldo inicial no puede ser negativo.");
		}
		this.numeroCuenta=numeroCuenta;
		this.titular=titular;
		this.saldo=saldo;
	}
	
	public void depositar(double monto) {
		if(monto<=0) {
			throw new IllegalArgumentException("El monto a depositar debe ser mayor a cero.");
		}
		this.saldo += monto;
		System.out.println("Deposito exitoso. Nuevo saldo: $" + this.saldo);
	}
	public void retirar(double monto) throws SaldoInsuficienteException {
		if(monto<=0) {
			throw new IllegalArgumentException("El monto a retirar debe ser mayor a cero.");
		}
	
		if(monto>this.saldo) {
			throw new SaldoInsuficienteException("Error: saldo insuficiente. Saldo Actual: $" + this.saldo);
		}
		this.saldo -= monto;
		System.out.println("Retiro exitoso. Nuevo saldo: $" + this.saldo);
	}
	
	public void transferir(CuentaBancaria destino, double monto) throws CuentaNoEncontradaException, SaldoInsuficienteException{
		if(destino == null) {
			throw new CuentaNoEncontradaException("Error: cuenta de destino no existe en el sistema");
		}
		this.retirar(monto);
		destino.depositar(monto);
		System.out.println("Tranferencia de " + monto + " Soles enviada a " + destino.getTitular());
	}
	
	public void cerrarCuenta() throws SaldoNoCeroException{
		if(this.saldo > 0) {
			throw new SaldoNoCeroException("No se puede cerrar la cuenta, Aun hay" + this.saldo + " soles en la cuenta.");
		}else if(this.saldo < 0) {
			throw new SaldoNoCeroException("No se puede cerrar la cuenta. Tienes una deuda de " + this.saldo + " soles.");
		}
		System.out.println("La cuenta ha sido cerrada exitosamente.");
	}
	
	public double getSaldo() {
        return saldo;
    }
    
    public String getTitular() {
        return titular;
    }
    
    
}
