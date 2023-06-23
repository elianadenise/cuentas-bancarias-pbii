package cuentasBancarias;

import java.util.Objects;

public abstract class Cuenta implements Comparable<Cuenta>{

	protected String propietario;
	protected Double saldo;
	protected Integer numeroCuenta;
	protected String claveBancariaUniforme;
	
	public Cuenta(String propietario, Integer numeroCuenta, String claveBancariaUniforme) {
		this.propietario = propietario;
		this.numeroCuenta = numeroCuenta;
		this.claveBancariaUniforme = claveBancariaUniforme;
		this.saldo = 0.0;
	}
	
	public Boolean depositar(String clave, Double valor) {
		if(this.claveBancariaUniforme.equals(clave)){
			this.saldo += valor;
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	
	public Boolean transferir(String clave, Cuenta cuenta, Double valor) {
		if(this.claveBancariaUniforme.equals(clave)){
			if(this.saldo >= valor) {
				this.saldo -= valor;
				cuenta.setSaldo(cuenta.getSaldo() + valor);
				return Boolean.TRUE;
			} 
		}
		return Boolean.FALSE;
	}
	
	public abstract Boolean extraer(String clave, Double valor) throws SaldoInsuficiente;	
	
	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numeroCuenta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cuenta other = (Cuenta) obj;
		return Objects.equals(numeroCuenta, other.numeroCuenta);
	}

	public String getClaveBancariaUniforme() {
		return claveBancariaUniforme;
	}
	
	@Override
	public int compareTo(Cuenta c) {
		return this.getNumeroCuenta().compareTo(c.getNumeroCuenta());
	}

	public Integer getNumeroCuenta() {
		return numeroCuenta;
	}
	
}
