public class Usuario {
	private String nombre;
	private String rut;
	private int numeroTelefonico;
	private Biblioteca biblioteca;
	private Prestamo prestamo;

	public Usuario(String nombre, String rut, int numeroTelefonico) {
		this.nombre = nombre;
		this.rut = rut;
		this.numeroTelefonico = numeroTelefonico;
	}

	public String getNombre() {
		return this.nombre;
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

	public int getNumeroTelefonico() {
		return this.numeroTelefonico;
	}

	public void setNumeroTelefonico(int numeroTelefonico) {
		this.numeroTelefonico = numeroTelefonico;
	}
}