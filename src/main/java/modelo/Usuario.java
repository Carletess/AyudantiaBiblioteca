package modelo;

import modelo.Prestamo;

public class Usuario extends Persona {
	private String numeroTelefonico;
	private Prestamo prestamo;

	public Usuario(String nombre, String rut, String numeroTelefonico) {
		super(nombre, rut);
		this.numeroTelefonico = numeroTelefonico;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRut() {
		return this.rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getNumeroTelefonico() {
		return this.numeroTelefonico;
	}

	public void setNumeroTelefonico(String numeroTelefonico) {
		this.numeroTelefonico = numeroTelefonico;
	}
}