package cuentasBancarias;

public class SaldoInsuficiente extends Exception {

	public SaldoInsuficiente() {}
	public SaldoInsuficiente(String mensaje) {
		super(mensaje);
	}
}
