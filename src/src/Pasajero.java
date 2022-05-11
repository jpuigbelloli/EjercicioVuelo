package src;

public class Pasajero {

	private String nombre;
	private Integer dni;
	private Double saldo;
	private Boolean esVip;

	public Pasajero(String nombre, Integer dni, Double saldo) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.saldo = saldo;
		this.esVip = false;
	}

	// GETTERS & SETTERS
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Boolean getEsVip() {
		return esVip;
	}

	public void setEsVip(Boolean esVip) {
		this.esVip = esVip;
	}

	@Override
	public String toString() {
		String result = "";
		if (getEsVip() == true) {
			result += "Nombre: " + nombre + ", DNI: " + dni + " - Cliente VIP";
		} else {
			result += "Nombre: " + nombre + ", DNI: " + dni + "\n";
		}

		return result;
	}

}
