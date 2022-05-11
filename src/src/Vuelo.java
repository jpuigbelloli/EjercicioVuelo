package src;

import java.util.ArrayList;
import java.util.HashSet;

public class Vuelo {

	private Integer numeroVuelo;
	private Double precioVuelo;
	private Integer cantidadMaximaPasajeros;
	HashSet<Pasajero> pasajerosConPasaje;
	ArrayList<Pasajero> asientosAsignados;
	private Boolean despego;
	ArrayList<Pasajero> queNoPudieronViajar;

	public Vuelo(Integer numeroVuelo, Double precioVuelo, Integer cantidadMaximaPasajeros) {
		this.numeroVuelo = numeroVuelo;
		this.precioVuelo = precioVuelo;
		this.cantidadMaximaPasajeros = cantidadMaximaPasajeros;
		pasajerosConPasaje = new HashSet<Pasajero>();
		asientosAsignados = new ArrayList<Pasajero>();
		despego = false;
		queNoPudieronViajar = new ArrayList<Pasajero>();
	}

	// GETTERS & SETTERS
	public Integer getNumeroVuelo() {
		return numeroVuelo;
	}

	public HashSet<Pasajero> getPasajerosConPasaje() {
		return pasajerosConPasaje;
	}

	public void setPasajerosConPasaje(HashSet<Pasajero> pasajerosConPasaje) {
		this.pasajerosConPasaje = pasajerosConPasaje;
	}

	public void setNumeroVuelo(Integer numeroVuelo) {
		this.numeroVuelo = numeroVuelo;
	}

	public Double getPrecioVuelo() {
		return precioVuelo;
	}

	public void setPrecioVuelo(Double precioVuelo) {
		this.precioVuelo = precioVuelo;
	}

	public Integer getCantidadMaximaPasajeros() {
		return cantidadMaximaPasajeros;
	}

	public void setCantidadMaximaPasajeros(Integer cantidadMaximaPasajeros) {
		this.cantidadMaximaPasajeros = cantidadMaximaPasajeros;
	}

	public Double descuentoParaClienteVip() {

		Double descuento = getPrecioVuelo() * 0.05;
		return getPrecioVuelo() - descuento;
	}

	public boolean comprarPasaje(Pasajero pasajero) {
		Boolean exito = false;
		if (pasajero.getEsVip() == true && getPrecioVuelo() <= pasajero.getSaldo()) {
			pasajerosConPasaje.add(pasajero);
			pasajero.setSaldo(getPrecioVuelo() - descuentoParaClienteVip());
			exito = true;
		}
		if (getPrecioVuelo() <= pasajero.getSaldo()) {
			pasajerosConPasaje.add(pasajero);
			pasajero.setSaldo(pasajero.getSaldo() - getPrecioVuelo());
			exito = true;
		}
		return exito;
	}

	public void asignarAsiento(Pasajero pasajero) {
		if (pasajerosConPasaje.contains(pasajero) && !getDespego()) {
			asientosAsignados.add(pasajero);
			pasajerosConPasaje.remove(pasajero);
		}

	}

	public ArrayList<Pasajero> getAsientosAsignados() {
		return asientosAsignados;
	}

	public void setAsientosAsignados(ArrayList<Pasajero> asientosAsignados) {
		this.asientosAsignados = asientosAsignados;
	}

	public Boolean getDespego() {
		return despego;
	}

	public void setDespego(Boolean despego) {
		this.despego = despego;
	}

}
