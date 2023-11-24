package modelo;

public class Bibliotecario extends Persona{
	private String direccion;
	private int id;
	private Biblioteca biblioteca;
	private Prestamo prestamo;

	public Bibliotecario(String nombre, String rut, String direccion, int id) {
		super(nombre, rut);
		this.direccion = direccion;
		this.id = id;
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

	public Prestamo getPrestamo() {
		return prestamo;
	}

	public String toString(){
		return super.nombre+","+super.rut+","+this.id;
	}
}