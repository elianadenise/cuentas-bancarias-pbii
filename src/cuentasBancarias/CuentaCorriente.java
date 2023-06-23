package cuentasBancarias;

public class CuentaCorriente extends Cuenta{

	private Double limiteAdicional;
	private Double debeAlBanco;
	public CuentaCorriente(String propietario, Double limiteAdicional, Integer numeroCuenta, String clave) {
		super(propietario, numeroCuenta, clave);
		this.limiteAdicional = limiteAdicional;
		this.debeAlBanco = 0.0;
	}


	@Override
	public Boolean extraer(String clave, Double valor) throws SaldoInsuficiente {
		if(this.claveBancariaUniforme.equals(clave)){
			if(this.saldo >= valor) {
				this.saldo -= valor;
				return Boolean.TRUE;
			} else if((this.saldo + this.limiteAdicional) >= valor) {
				this.limiteAdicional -= (valor-this.saldo) + (valor - this.saldo) * 0.05;
				this.saldo = 0.0;
				return Boolean.TRUE;
			}
		}
		throw new SaldoInsuficiente("No posee saldo suficiente");
	}


	public Double getDebeAlBanco() {
		return debeAlBanco;
	}


	public Double getLimiteAdicional() {
		return limiteAdicional;
	}
	
	
}
