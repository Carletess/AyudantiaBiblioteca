public class Usuario {
	private String nombre;
	private String rut;
	private int numeroTelefonico;
	private Biblioteca biblioteca;
	private Prestamo prestamo;

	public Usuario Usuario(String nombre, String rut, String numeroTelefonico) {
		throw new UnsupportedOperationException();
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