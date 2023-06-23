package cuentasBancarias;

import java.util.*;

public class Banco {

	private TreeSet<Cuenta> cuentas;
	private Map<Integer, Transaccion> transacciones;
	
	public Banco() {
		this.cuentas = new TreeSet<Cuenta>();
		this.transacciones = new TreeMap<Integer, Transaccion>();
	}
	
	public Boolean crearCuenta(Cuenta cuenta) {
		return this.cuentas.add(cuenta);
	}
	
	public Boolean registrarTransaccion(Transaccion transaccion) throws CuentaInexistenteException {
	    if (this.cuentas.contains(transaccion.getOrigen()) && (transaccion.getMotivo().equals(MotivoTransaccion.DEPOSITO) || transaccion.getMotivo().equals(MotivoTransaccion.EXTRACCION))) {
	        this.transacciones.put(transaccion.getIdentificador(), transaccion);
	        MotivoTransaccion motivo = transaccion.getMotivo();
	        switch (motivo) {
	            case DEPOSITO:
	                transaccion.getOrigen().depositar(transaccion.getOrigen().getClaveBancariaUniforme(), transaccion.getMonto());
	                break;
	            case EXTRACCION:
	                try {
	                    transaccion.getOrigen().extraer(transaccion.getOrigen().getClaveBancariaUniforme(), transaccion.getMonto());
	                } catch (SaldoInsuficiente e) {
	                    e.printStackTrace();
	                }
	                break;
	            default:
	                break;
	        }
	        return Boolean.TRUE;
	    } else if (this.cuentas.contains(transaccion.getOrigen()) && this.cuentas.contains(transaccion.getDestino()) && transaccion.getMotivo().equals(MotivoTransaccion.TRANSFERENCIA)) {
	        this.transacciones.put(transaccion.getIdentificador(), transaccion);
	        MotivoTransaccion motivo = transaccion.getMotivo();
	        switch (motivo) {
	            case TRANSFERENCIA:
	                transaccion.getOrigen().transferir(transaccion.getOrigen().getClaveBancariaUniforme(), transaccion.getDestino(), transaccion.getMonto());
	                break;
	            default:
	                break;
	        }
	        return Boolean.TRUE;
	    } else {
	    	throw new CuentaInexistenteException("La cuenta origen o destino no existe en el banco");
	    }
	}

	
	public Integer cantidadDeCuentas() {
		return this.cuentas.size();
	}
	public Integer cantidadTransacciones() {
		return this.transacciones.size();
	}
	
}
