package test;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Test;
import src.Pasajero;
import src.Vuelo;

public class TestVuelo {

	@Test
	public void queSePuedaComprarUnPasaje() {
		String nombre = "Jose Puig Belloli";
		Integer dni = 39333188;
		Double saldo = 15000.0;
		Integer numeroVuelo = 2;
		Double precioVuelo = 500.0;
		Integer cantidadMaximaPasajeros = 100;

		Pasajero pasajero = new Pasajero(nombre, dni, saldo);
		Vuelo vuelo = new Vuelo(numeroVuelo, precioVuelo, cantidadMaximaPasajeros);

		assertTrue(vuelo.comprarPasaje(pasajero));
	}

	@Test
	public void queNoSePuedaComprar2PasajesAlMismoPasajero() {
		String nombre = "Jose Puig Belloli";
		Integer dni = 39333188;
		Double saldo = 15000.0;
		Integer numeroVuelo = 2;
		Double precioVuelo = 500.0;
		Integer cantidadMaximaPasajeros = 100;
		int cantidadPasajesVendidosEsperados = 1;
		Pasajero pasajero = new Pasajero(nombre, dni, saldo);
		Vuelo vuelo = new Vuelo(numeroVuelo, precioVuelo, cantidadMaximaPasajeros);

		vuelo.comprarPasaje(pasajero);
		vuelo.comprarPasaje(pasajero);
		assertEquals(cantidadPasajesVendidosEsperados, vuelo.getPasajerosConPasaje().size());
	}

	@Test
	public void queHayaDescuentoDelCincoPorcientoParaPasajerosVIP() {
		String nombre = "Jose Puig Belloli";
		Integer dni = 39333188;
		Double saldo = 200.0;
		Integer numeroVuelo = 2;
		Double precioVuelo = 200.0;
		Integer cantidadMaximaPasajeros = 100;
		Double saldoRestanteClienteVip = 10.0;

		Pasajero pasajero = new Pasajero(nombre, dni, saldo);
		pasajero.setEsVip(true);

		Vuelo vuelo = new Vuelo(numeroVuelo, precioVuelo, cantidadMaximaPasajeros);
		vuelo.comprarPasaje(pasajero);

		assertEquals(saldoRestanteClienteVip, pasajero.getSaldo());
	}

	@Test
	public void queSePuedaAsignarUnAsientoAUnPasajeroDeUnVuelo() {
		String nombre = "Jose Puig Belloli";
		Integer dni = 39333188;
		Double saldo = 200.0;
		Integer numeroVuelo = 2;
		Double precioVuelo = 200.0;
		Integer cantidadMaximaPasajeros = 100;
		Pasajero pasajero = new Pasajero(nombre, dni, saldo);
		Vuelo vuelo = new Vuelo(numeroVuelo, precioVuelo, cantidadMaximaPasajeros);

		vuelo.comprarPasaje(pasajero);
		vuelo.asignarAsiento(pasajero);
	}

	@Test
	public void queNoSePuedaAsignarElMismoAsiento() {
		String nombre = "Jose Puig Belloli";
		Integer dni = 39333188;
		Double saldo = 200.0;
		Integer numeroVuelo = 2;
		Double precioVuelo = 200.0;
		Integer cantidadMaximaPasajeros = 100;
		Pasajero pasajero = new Pasajero(nombre, dni, saldo);
		Vuelo vuelo = new Vuelo(numeroVuelo, precioVuelo, cantidadMaximaPasajeros);

		vuelo.comprarPasaje(pasajero);
		vuelo.asignarAsiento(pasajero);
	}

	@Test
	public void queNoSePuedaAsignarAcientoSiElAvionDespego() {
		String nombre = "Jose Puig Belloli";
		Integer dni = 39333188;
		Double saldo = 200.0;
		Integer numeroVuelo = 2;
		Double precioVuelo = 200.0;
		Integer cantidadMaximaPasajeros = 100;

		Pasajero pasajero = new Pasajero(nombre, dni, saldo);
		Vuelo vuelo = new Vuelo(numeroVuelo, precioVuelo, cantidadMaximaPasajeros);
		vuelo.comprarPasaje(pasajero);
		vuelo.setDespego(true);
		vuelo.asignarAsiento(pasajero);

		int cantidadDePasajerosPretendidoEnElVuelo = 0;

		assertEquals(cantidadDePasajerosPretendidoEnElVuelo, vuelo.getAsientosAsignados().size());
	}

	@Test
	public void queSePuedaMostrarLosQueNoPudieronSubirAlAvion() {
		String nombre = "Jose Puig Belloli";
		Integer dni = 39333188;
		Double saldo = 200.0;
		Integer numeroVuelo = 2;
		Double precioVuelo = 200.0;
		Integer cantidadMaximaPasajeros = 100;
		Pasajero pasajero = new Pasajero(nombre, dni, saldo);
		Vuelo vuelo = new Vuelo(numeroVuelo, precioVuelo, cantidadMaximaPasajeros);

		vuelo.comprarPasaje(pasajero);
		vuelo.setDespego(true);
		pasajero.setEsVip(true);
		vuelo.asignarAsiento(pasajero);

		System.out.println(vuelo.getPasajerosConPasaje());
	}

}
