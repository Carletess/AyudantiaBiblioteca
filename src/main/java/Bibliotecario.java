public class Bibliotecario {
	private String nombre;
	private String rut;
	private String direccion;
	private int id;
	private Biblioteca biblioteca;
	private Prestamo prestamo;

	public Bibliotecario(String nombre, String rut, String direccion, int id) {
		this.nombre = nombre;
		this.rut = rut;
		this.direccion = direccion;
		this.id = id;
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

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
}