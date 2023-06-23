package cuentasBancarias;

public class CuentaInexistenteException extends Exception {

	public CuentaInexistenteException() {}
	public CuentaInexistenteException(String mensaje) {
		super(mensaje);
	}
}
