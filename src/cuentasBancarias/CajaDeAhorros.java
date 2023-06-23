package cuentasBancarias;

public class CajaDeAhorros extends Cuenta{

	private Integer contadorDeExtracciones;
	private Double cargoAdicional;
	public CajaDeAhorros(String propietario, Integer numeroCuenta, String clave) {
		super(propietario, numeroCuenta, clave);
		this.contadorDeExtracciones = 0;
		this.cargoAdicional = 6.0;
	}

	@Override
	public Boolean extraer(String clave, Double valor) throws SaldoInsuficiente{
		if(this.claveBancariaUniforme.equals(clave)){
			if(this.contadorDeExtracciones < 5 && this.saldo >= valor) {
				this.saldo -= valor;
				this.contadorDeExtracciones++;
				return Boolean.TRUE;
			} else if(this.contadorDeExtracciones >= 5 && this.saldo >= valor) {
				this.saldo -= (valor + this.cargoAdicional);
				this.contadorDeExtracciones++;
				return Boolean.TRUE;
			} else {
				throw new SaldoInsuficiente("No posee saldo suficiente");
			}
		}
		return Boolean.FALSE;
	}

}
