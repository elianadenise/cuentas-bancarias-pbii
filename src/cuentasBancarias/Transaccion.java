package cuentasBancarias;

import java.util.Objects;

public class Transaccion implements Comparable<Transaccion>{

	private MotivoTransaccion motivo;
	private Cuenta origen;
	private Cuenta destino;
	private Integer identificador;
	private Double monto;
	
	public Transaccion(Integer identificador, MotivoTransaccion motivo, Cuenta origen, Cuenta destino, Double monto) {
		this.motivo = motivo;
		this.origen = origen;
		this.destino = destino;
		this.monto = monto;
		this.identificador = identificador;
	}

	public Transaccion(Integer identificador, MotivoTransaccion motivo, Cuenta origen, Double monto) {
		this.motivo = motivo;
		this.origen = origen;
		this.monto = monto;
		this.identificador = identificador;
	}
	public Integer getIdentificador() {
		return identificador;
	}

	public Cuenta getOrigen() {
		return origen;
	}

	public Cuenta getDestino() {
		return destino;
	}

	public MotivoTransaccion getMotivo() {
		return motivo;
	}

	public Double getMonto() {
		return monto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(identificador);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaccion other = (Transaccion) obj;
		return Objects.equals(identificador, other.identificador);
	}

	@Override
	public int compareTo(Transaccion o) {
		return this.getIdentificador().compareTo(o.getIdentificador());
	}
	

	
	
	
}
