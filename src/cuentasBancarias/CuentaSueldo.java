package cuentasBancarias;

public class CuentaSueldo extends Cuenta{

	public CuentaSueldo(String propietario, Integer numeroCuenta, String clave) {
		super(propietario, numeroCuenta, clave);
	}

	@Override
	public Boolean extraer(String clave, Double valor) throws SaldoInsuficiente{
		if(this.claveBancariaUniforme.equals(clave)){
			if(this.saldo >= valor) {
				this.saldo -= valor;
			return Boolean.TRUE;
			}
		}
		throw new SaldoInsuficiente("No posee saldo suficiente");
	}

}
