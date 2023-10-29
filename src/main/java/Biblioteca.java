import java.util.ArrayList;
import java.util.Date;

public class Biblioteca {
	private String nombre;
	private String direccion;
	private Bibliotecario bibliotecario;
	private ArrayList<Libro> libro = new ArrayList<Libro>();
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

	public Biblioteca Biblioteca(String nombre, String direccion, Libro libro) {
		throw new UnsupportedOperationException();
	}

	public Prestamo generarPrestamo(Bibliotecario bilbiotecario, Libro libro, Usuario usuario, Date fechaInicio, Date fechaTermino) {
		throw new UnsupportedOperationException();
	}

	private boolean libroExiste(Libro libro) {
		throw new UnsupportedOperationException();
	}

	private Libro buscarLibro(String nombreLibro) {
		throw new UnsupportedOperationException();
	}

	private void agregarLibro(Libro libro) {
		throw new UnsupportedOperationException();
	}

	public ArrayList<Libro> obtenerLibroPorAutor(String autor) {
		throw new UnsupportedOperationException();
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
}