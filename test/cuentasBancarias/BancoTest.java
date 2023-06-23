package cuentasBancarias;

import static org.junit.Assert.*;

import org.junit.Test;

public class BancoTest {

	@Test
	public void queSePuedaCrearCuentaBancaria() {
		Banco banco = new Banco();
		CuentaSueldo cuentaSueldo = new CuentaSueldo("Eliana", 1, "123");
		CuentaCorriente cuentaCorriente = new CuentaCorriente("Maxi", 100.0, 2, "234" );
		CajaDeAhorros cajaDeAhorros = new CajaDeAhorros("Lara", 3, "456");
		
		assertTrue(banco.crearCuenta(cuentaCorriente));
		assertTrue(banco.crearCuenta(cuentaSueldo));
		assertTrue(banco.crearCuenta(cajaDeAhorros));
		assertEquals(new Integer(3), banco.cantidadDeCuentas());
	}
	@Test
	public void queNoSePuedaCrearCuentaBancariaConMismoNumeroDeCuenta() {
		Banco banco = new Banco();
		CuentaSueldo cuentaSueldo = new CuentaSueldo("Eliana", 1, "123");
		CuentaCorriente cuentaCorriente = new CuentaCorriente("Maxi", 100.0, 1, "234" );
		
		assertTrue(banco.crearCuenta(cuentaCorriente));
		assertFalse(banco.crearCuenta(cuentaSueldo));
		assertEquals(new Integer(1), banco.cantidadDeCuentas());
	}
	@Test
	public void queSePuedaRealizarUnDepositoEnCuentaCorriente() {
		Banco banco = new Banco();
		CuentaCorriente cuentaCorriente = new CuentaCorriente("Maxi", 100.0, 2, "234" );
		banco.crearCuenta(cuentaCorriente);
		
		Transaccion transaccion = new Transaccion(1, MotivoTransaccion.DEPOSITO, cuentaCorriente, 500.0);
		
		try {
			assertTrue(banco.registrarTransaccion(transaccion));
		} catch (CuentaInexistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(new Integer(1), banco.cantidadTransacciones());
		assertEquals(new Double(500.0), cuentaCorriente.getSaldo());
		
	}
	@Test
	public void queSePuedaRealizarUnDepositoEnCajaDeAhorros() {
		Banco banco = new Banco();
		CajaDeAhorros cajaDeAhorros = new CajaDeAhorros("Lara", 3, "456");
		
		banco.crearCuenta(cajaDeAhorros);
		
		Transaccion transaccion = new Transaccion(1, MotivoTransaccion.DEPOSITO, cajaDeAhorros, 500.0);
		
		try {
			assertTrue(banco.registrarTransaccion(transaccion));
		} catch (CuentaInexistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(new Integer(1), banco.cantidadTransacciones());
		assertEquals(new Double(500.0), cajaDeAhorros.getSaldo());
		
	}
	@Test
	public void queSePuedaRealizarUnDepositoEnCuentaSueldo() {
		Banco banco = new Banco();
		CuentaSueldo cuentaSueldo = new CuentaSueldo("Eliana", 1, "123");
		banco.crearCuenta(cuentaSueldo);
		
		Transaccion transaccion = new Transaccion(1, MotivoTransaccion.DEPOSITO, cuentaSueldo, 500.0);
		
		try {
			assertTrue(banco.registrarTransaccion(transaccion));
		} catch (CuentaInexistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(new Integer(1), banco.cantidadTransacciones());
		assertEquals(new Double(500.0), cuentaSueldo.getSaldo());
		
	}
// --------------------------------------------------------------------------------------------------------------------
	@Test
	public void queSePuedaRealizarUnaExtranccionEnCuentaCorriente() {
		Banco banco = new Banco();
		CuentaCorriente cuentaCorriente = new CuentaCorriente("Maxi", 100.0, 2, "234" );
		banco.crearCuenta(cuentaCorriente);
		
		Transaccion transaccion = new Transaccion(1, MotivoTransaccion.DEPOSITO, cuentaCorriente, 500.0);
		Transaccion transaccionDos = new Transaccion(2, MotivoTransaccion.EXTRACCION, cuentaCorriente, 200.0);
		try {
			assertTrue(banco.registrarTransaccion(transaccion));
		} catch (CuentaInexistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			assertTrue(banco.registrarTransaccion(transaccionDos));
		} catch (CuentaInexistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(new Integer(2), banco.cantidadTransacciones());
		assertEquals(new Double(300.0), cuentaCorriente.getSaldo());
		
	}
	@Test
	public void queSePuedaRealizarUnaExtranccionEnCajaDeAhorros() {
		Banco banco = new Banco();
		CajaDeAhorros cajaDeAhorros = new CajaDeAhorros("Lara", 3, "456");
		
		banco.crearCuenta(cajaDeAhorros);
		
		Transaccion transaccion = new Transaccion(1, MotivoTransaccion.DEPOSITO, cajaDeAhorros, 500.0);
		Transaccion transaccionDos = new Transaccion(2, MotivoTransaccion.EXTRACCION, cajaDeAhorros, 200.0);
		try {
			assertTrue(banco.registrarTransaccion(transaccion));
		} catch (CuentaInexistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			assertTrue(banco.registrarTransaccion(transaccionDos));
		} catch (CuentaInexistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(new Integer(2), banco.cantidadTransacciones());
		assertEquals(new Double(300.0), cajaDeAhorros.getSaldo());
		
	}
	@Test
	public void queSePuedaRealizarUnaExtranccionEnCuentaSueldo() {
		Banco banco = new Banco();
		CuentaSueldo cuentaSueldo = new CuentaSueldo("Eliana", 1, "123");
		banco.crearCuenta(cuentaSueldo);
		
		Transaccion transaccion = new Transaccion(1, MotivoTransaccion.DEPOSITO, cuentaSueldo, 500.0);
		Transaccion transaccionDos = new Transaccion(2, MotivoTransaccion.EXTRACCION, cuentaSueldo, 200.0);
		try {
			assertTrue(banco.registrarTransaccion(transaccion));
		} catch (CuentaInexistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			assertTrue(banco.registrarTransaccion(transaccionDos));
		} catch (CuentaInexistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(new Integer(2), banco.cantidadTransacciones());
		assertEquals(new Double(300.0), cuentaSueldo.getSaldo());
		
	}
	
	// ----------- variantes extracciones
	
	@Test
	public void queSePuedaRealizar6ExtraccionesEnCajaDeAhorrosYSeCobreAdicional() throws CuentaInexistenteException {
		Banco banco = new Banco();
		CajaDeAhorros cajaDeAhorros = new CajaDeAhorros("Lara", 3, "456");
			
		banco.crearCuenta(cajaDeAhorros);
			
		Transaccion transaccion = new Transaccion(1, MotivoTransaccion.DEPOSITO, cajaDeAhorros, 500.0);
		Transaccion transaccionDos = new Transaccion(2, MotivoTransaccion.EXTRACCION, cajaDeAhorros, 10.0);
		Transaccion transaccionTres = new Transaccion(3, MotivoTransaccion.EXTRACCION, cajaDeAhorros, 10.0);
		Transaccion transaccionCuatro = new Transaccion(4, MotivoTransaccion.EXTRACCION, cajaDeAhorros, 10.0);
		Transaccion transaccionCinco = new Transaccion(5, MotivoTransaccion.EXTRACCION, cajaDeAhorros, 10.0);
		Transaccion transaccionSeis = new Transaccion(6, MotivoTransaccion.EXTRACCION, cajaDeAhorros, 10.0);
		Transaccion transaccionSiete= new Transaccion(7, MotivoTransaccion.EXTRACCION, cajaDeAhorros, 10.0);// + 6
		banco.registrarTransaccion(transaccion);
		banco.registrarTransaccion(transaccionDos);
		banco.registrarTransaccion(transaccionTres);
		banco.registrarTransaccion(transaccionCuatro);
		banco.registrarTransaccion(transaccionCinco);
		banco.registrarTransaccion(transaccionSeis);
		banco.registrarTransaccion(transaccionSiete);
		
		assertEquals(new Integer(7), banco.cantidadTransacciones());
		assertEquals(new Double(434.0), cajaDeAhorros.getSaldo());
	}
	
	@Test
	public void queSePuedaExtraerMasDelSaldoDisponibleEnCuentaCorriente() throws CuentaInexistenteException {
		Banco banco = new Banco();
		CuentaCorriente cuentaCorriente = new CuentaCorriente("Maxi", 200.0, 2, "234" );
		banco.crearCuenta(cuentaCorriente);
		
		Transaccion transaccion = new Transaccion(1, MotivoTransaccion.DEPOSITO, cuentaCorriente, 500.0);
		Transaccion transaccionDos = new Transaccion(2, MotivoTransaccion.EXTRACCION, cuentaCorriente,600.0);
		
		banco.registrarTransaccion(transaccion);
		banco.registrarTransaccion(transaccionDos);
		
		assertEquals(new Integer(2), banco.cantidadTransacciones());
		assertEquals(new Double(0.0), cuentaCorriente.getSaldo());
		assertEquals(new Double(95.0), cuentaCorriente.getLimiteAdicional()); 
	}
	
	//---- throws saldoInsuficiente
	
	@Test 
	public void queArrojeSaldoInsuficienteCuandoNoHayaMasSaldoEnCuentas() throws SaldoInsuficiente, CuentaInexistenteException{
		Banco banco = new Banco();
		CuentaSueldo cuentaSueldo = new CuentaSueldo("Eliana", 1, "123");
		CuentaCorriente cuentaCorriente = new CuentaCorriente("Maxi", 100.0, 2, "234" );
		CajaDeAhorros cajaDeAhorros = new CajaDeAhorros("Lara", 3, "456");
		
		banco.crearCuenta(cuentaCorriente);
		banco.crearCuenta(cuentaSueldo);
		banco.crearCuenta(cajaDeAhorros);
		
		Transaccion transaccion = new Transaccion(1, MotivoTransaccion.DEPOSITO, cuentaCorriente, 500.0);
		Transaccion transaccionDos = new Transaccion(2, MotivoTransaccion.EXTRACCION, cuentaCorriente,800.0);
		Transaccion transaccionTres = new Transaccion(3, MotivoTransaccion.DEPOSITO, cuentaSueldo, 500.0);
		Transaccion transaccionCuatro = new Transaccion(4, MotivoTransaccion.EXTRACCION, cuentaSueldo, 600.0);
		Transaccion transaccionCinco = new Transaccion(5, MotivoTransaccion.DEPOSITO, cajaDeAhorros, 500.0);
		Transaccion transaccionSeis = new Transaccion(6, MotivoTransaccion.EXTRACCION, cajaDeAhorros, 600.0);
		banco.registrarTransaccion(transaccion);
		banco.registrarTransaccion(transaccionDos);
		banco.registrarTransaccion(transaccionTres);
		banco.registrarTransaccion(transaccionCuatro);
		banco.registrarTransaccion(transaccionCinco);
		banco.registrarTransaccion(transaccionSeis);
	
		
		assertEquals(new Integer(6), banco.cantidadTransacciones());
		assertEquals(new Double(500.0), cuentaCorriente.getSaldo());
		assertEquals(new Double(500.0), cajaDeAhorros.getSaldo());
		assertEquals(new Double(500.0), cuentaSueldo.getSaldo());
	}
	
	// ---------------------------------------------
	@Test 
	public void queNoSePuedaHacerTransferenciaSiAlgunaDeLasCuentasNoExisteEnElBanco(){
		Banco banco = new Banco();
		CuentaSueldo cuentaSueldo = new CuentaSueldo("Eliana", 1, "123");
		CuentaCorriente cuentaCorriente = new CuentaCorriente("Maxi", 100.0, 2, "234" );
		banco.crearCuenta(cuentaSueldo);
		Transaccion transaccionUno = new Transaccion(1, MotivoTransaccion.DEPOSITO, cuentaSueldo, 500.0);
		Transaccion transaccionDos = new Transaccion(2, MotivoTransaccion.TRANSFERENCIA, cuentaSueldo, cuentaCorriente, 300.0);
		
		try {
			assertTrue(banco.registrarTransaccion(transaccionUno));
		} catch (CuentaInexistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			assertFalse(banco.registrarTransaccion(transaccionDos));
		} catch (CuentaInexistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(new Integer(1), banco.cantidadTransacciones());
	}
	
	@Test
	public void queSePuedaRealizarUnaTransferencia() throws CuentaInexistenteException{
		Banco banco = new Banco();
		CuentaSueldo cuentaSueldo = new CuentaSueldo("Eliana", 1, "123");
		CuentaCorriente cuentaCorriente = new CuentaCorriente("Maxi", 100.0, 2, "234" );
		banco.crearCuenta(cuentaCorriente);
		banco.crearCuenta(cuentaSueldo);
		Transaccion transaccionUno = new Transaccion(1, MotivoTransaccion.DEPOSITO, cuentaCorriente, 500.0);
		Transaccion transaccionDos = new Transaccion(2, MotivoTransaccion.TRANSFERENCIA, cuentaSueldo, cuentaCorriente, 300.0);
		

		assertTrue(banco.registrarTransaccion(transaccionUno));
	
		assertTrue(banco.registrarTransaccion(transaccionDos));
		
		assertEquals(new Integer(2), banco.cantidadTransacciones());
	}
}
