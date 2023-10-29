import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Crear una instancia de Biblioteca
        Biblioteca biblioteca = new Biblioteca("Biblioteca Temuco", "Calle Temuco");

        // Crear instancias de Bibliotecario, Usuario, y Libro
        Bibliotecario bibliotecario = new Bibliotecario("Nicolas", "123456789", "Calle Araucania", 1);
        Usuario usuario = new Usuario("Carlos", "987654321", 1234567890);
        Libro libro = new Libro("Harry Potter", "J. K. Rowling", "Editorial Magica", "1234567890");

        // Obtener la fecha actual (puedes personalizar esto según tus necesidades)
        Date fechaInicio = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaInicio);
        calendar.add(Calendar.DAY_OF_MONTH, 14);  // Agregar 14 días para la fecha de término
        Date fechaTermino = calendar.getTime();

        // Generar un préstamo utilizando el método generarPrestamo
        Prestamo prestamo = biblioteca.generarPrestamo(bibliotecario, usuario, fechaInicio, fechaTermino, libro);

        // Puedes imprimir información sobre el préstamo
        System.out.println("Préstamo generado:");
        System.out.println("Bibliotecario: " + prestamo.getBibliotecario().getNombre());
        System.out.println("Usuario: " + prestamo.getUsuario().getNombre());
        System.out.println("Libro: " + prestamo.getLibro().getNombre());
        System.out.println("Fecha de Inicio: " + prestamo.getFechaInicio());
        System.out.println("Fecha de Término: " + prestamo.getFechaTermino());
    }
    // SE PUEDE SEPARAR EN MÉTODOS PERO NO ME DA EL TIEMPO
}
