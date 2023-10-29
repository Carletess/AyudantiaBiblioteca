import java.util.ArrayList;
import java.util.Date;

public class Biblioteca {
	private String nombre;
	private String direccion;
	private Bibliotecario bibliotecario;
	private ArrayList<Libro> libro = new ArrayList<Libro>();
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

	public Biblioteca(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
	}


	public Prestamo generarPrestamo(Bibliotecario bibliotecario, Usuario usuario, Date fechaInicio, Date fechaTermino, Libro libro) {
		Prestamo prestamo = new Prestamo();
		prestamo.setBibliotecario(bibliotecario);
		prestamo.setUsuario(usuario);
		prestamo.setFechaInicio(fechaInicio);
		prestamo.setFechaTermino(fechaTermino);
		prestamo.setLibro(libro);
		return prestamo;
	}

	private boolean libroExiste(Libro libro) {
		for (Libro l : this.libro) {
			if (l.equals(libro)) {
				return true;
			}
		}
		return false;
	}

	private Libro buscarLibro(String nombreLibro) {
		for (Libro libro : this.libro) {
			if (libro.getNombre().equals(nombreLibro)) {
				return libro;
			}
		}
		return null;
	}

	private void agregarLibro(Libro libro) {
		if (!libroExiste(libro)) {
			this.libro.add(libro);
			System.out.println("Libro agregado con éxito: " + libro.getNombre());
		} else {
			System.out.println("El libro ya existe en la biblioteca: " + libro.getNombre());
		}
	}

	public ArrayList<Libro> obtenerLibroPorAutor(String autor) {
		ArrayList<Libro> librosDelAutor = new ArrayList<>();

		for (Libro libro : this.libro) {
			if (libro.getAutor().equals(autor)) {
				librosDelAutor.add(libro);
			}
		}
		return librosDelAutor;
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