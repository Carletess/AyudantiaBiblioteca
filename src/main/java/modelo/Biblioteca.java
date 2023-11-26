package modelo;

import utils.ValidadorRut;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Biblioteca {
	private String nombre;
	private String direccion;
	private Bibliotecario bibliotecario;
	private ArrayList<Libro> libros;
	private ArrayList<Usuario> usuarios;
	private ArrayList<Bibliotecario> bibliotecarios;

	public Biblioteca(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.libros = new ArrayList<>();
		this.usuarios = new ArrayList<>();
		this.bibliotecarios = new ArrayList<>();
	}

	public void agregarBibliotecario(String nombre, String rut, String direccion, int idBibliotecario) {
		this.bibliotecario = new Bibliotecario(nombre, rut, direccion, idBibliotecario);
	}

	public Prestamo generarPrestamo(Bibliotecario bibliotecario, Usuario usuario, Date fechaInicio, Date fechaTermino, ArrayList<Libro> libros) {
		return new Prestamo(fechaInicio, fechaTermino, libros, usuario, bibliotecario);
	}

	private boolean libroExiste(Libro libro) {
		return libros.contains(libro);
	}

	public Persona buscarUsuario(String rut) {
		Persona usuario = null;

		for (Usuario usuarioAux : this.usuarios) {
			if (usuarioAux.getRut().equals(rut)) {
				usuario = usuarioAux;
				break;
			}
		}

		if (usuario == null && this.bibliotecarios != null) {
			for (Bibliotecario bibliotecarioAux : this.bibliotecarios) {
				if (bibliotecarioAux.getRut().equals(rut)) {
					usuario = bibliotecarioAux;
					break;
				}
			}
		}

		return usuario;
	}

	public Libro agregarLibro(String nombre, String isbn, String autor, String editorial, Especialidad especialidad) {
		Libro libro = new Libro(nombre,isbn,autor,editorial,especialidad);
		this.libros.add(libro);

		return libro;
	}

	public boolean agregarUsuario(String nombre, String rut, String numeroTelefonico) {
		if (ValidadorRut.validarDigito(rut) && this.buscarUsuario(rut) == null) {
			Usuario usuario = new Usuario(nombre, rut, numeroTelefonico);
			this.usuarios.add(usuario);
			return true;
		} else {
			return false;
		}
	}


	public ArrayList<Libro> obtenerLibrosPorAutor(String autor) {
		ArrayList<Libro> librosDelAutor = new ArrayList<>();

		for (Libro libro : libros) {
			if (libro.getAutor().equals(autor)) {
				librosDelAutor.add(libro);
			}
		}
		return librosDelAutor;
	}

	public List<Libro> obtenerLibroPorNombre(String nombreLibro) {
		List<Libro> librosEncontrados = new ArrayList<>();

		for (Libro libro : this.libros) {
			if (libro.getNombre().equals(nombreLibro)) {
				librosEncontrados.add(libro);
			}
		}

		return librosEncontrados;
	}

	public List<Libro> obtenerLibroPorEspecialidad(Especialidad especialidad) {
		List<Libro> libros = new ArrayList<Libro>();
		for (Libro libro : this.libros) {
			if (libro.getEspecialidad().equals(especialidad)) {
				libros.add(libro);
			}
		}
		return libros;
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

	public Bibliotecario getBibliotecario() {
		return bibliotecario;
	}

	public ArrayList<Libro> getLibros() {
		return libros;
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}
}