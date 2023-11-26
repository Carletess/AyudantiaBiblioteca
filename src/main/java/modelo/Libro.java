package modelo;

public class Libro {
	private String nombre;
	private String isbn;
	private String autor;
	private String editorial;
	private Especialidad especialidad;


	// Constructor actualizado
	public Libro(String nombre,String isbn, String autor, String editorial, Especialidad especialidad ) {
		this.nombre = nombre;
		this.isbn = isbn;
		this.autor = autor;
		this.editorial = editorial;
		this.especialidad = especialidad;
	}

	public Libro(){
		this.nombre = "Sin datos";
		this.isbn = "Sin datos";
		this.editorial = "Sin datos";
		this.autor = "Sin datos";
		this.especialidad = null;
	}

	// Métodos getters y setters

	public String getNombre() {
		return this.nombre;
	}

	public String getIsbn() {
		return this.isbn;
	}

	public String getAutor() {
		return this.autor;
	}

	public String getEditorial() {
		return this.editorial;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	@Override
	public String toString(){
		return this.nombre + "," + this.isbn + "," + this.autor + ","+this.editorial + "," + this.especialidad;
	}
}