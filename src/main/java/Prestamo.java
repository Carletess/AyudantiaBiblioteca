import java.util.ArrayList;
import java.util.Date;
public class Prestamo {
	private Date fechaInicio;
	private Date fechaTermino;
	private ArrayList<Libro> libro = new ArrayList<Libro>();
	private Usuario usuario;
	private Bibliotecario bibliotecario;

	public Prestamo Prestamo(Bibliotecario bibliotecario, Usuario usuario, Date fechaInicio, Date fechaTermino, Libro libro) {
		throw new UnsupportedOperationException();
	}

	public Bibliotecario getBibliotecario() {
		return this.bibliotecario;
	}

	public void setBibliotecario(Bibliotecario bibliotecario) {
		this.bibliotecario = bibliotecario;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public Date getFechaTermino() {
		return this.fechaTermino;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public void setFechaTermino(Date fechaTermino) {
		this.fechaTermino = fechaTermino;
	}

	public Libro getLibro() {
		throw new UnsupportedOperationException();
	}

	public void setLibro(Libro libro) {
		throw new UnsupportedOperationException();
	}
}