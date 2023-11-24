package modelo;

public class Libro {
	private String nombre;
	private String isbn;
	private String autor;
	private String editorial;
	private Especialidad especialidad;
	private boolean disponible;


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
		this.disponible = false;

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



	public boolean isDisponible() {
		return this.disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
}
