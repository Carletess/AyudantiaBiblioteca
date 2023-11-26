package ventana;

import modelo.Biblioteca;
import modelo.Libro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class VentanaBuscarLibro extends Ventana {
    private JButton botonBuscar, botonRegresar;
    private JLabel textoEncabezado, textoNombre;
    private JTextField campoNombre;
    private Biblioteca biblioteca;

    public VentanaBuscarLibro(Biblioteca biblioteca) {
        super("Búsqueda de Libros", 500, 520);
        this.biblioteca = biblioteca;
        generarElementosVentana();
    }

    private void generarElementosVentana() {
        generarCampoNombre();
        generarBotonBuscarLibro();
        generarBotonCancelar();
    }

    private void generarCampoNombre() {
        String textoNombre = "Nombre Libro:";
        super.generarJLabel(this.textoNombre, textoNombre, 20, 50, 150, 20);
        this.campoNombre = super.generarJTextField(200, 50, 250, 20);
        this.add(this.campoNombre);
    }

    private void generarBotonBuscarLibro() {
        String textoBoton = "Buscar Libro";
        this.botonBuscar = super.generarBoton(textoBoton, 75, 400, 150, 20);
        this.add(this.botonBuscar);
        this.botonBuscar.addActionListener(this);
    }

    private void generarBotonCancelar() {
        String textoBotonRegresar = "Volver";
        this.botonRegresar = super.generarBoton(textoBotonRegresar, 275, 400, 150, 20);
        this.add(this.botonRegresar);
        this.botonRegresar.addActionListener(this);
    }

    private String[][] buscarLibroPorNombre(String nombreLibro) {
        List<Libro> libros = biblioteca.getLibros();
        List<String[]> datosLibros = new ArrayList<>();

        for (Libro libro : libros) {
            if (libro.getNombre().equals(nombreLibro)) {
                // Si el nombre del libro coincide, se agrega la información del libro a la lista
                String[] datosLibro = new String[5];
                datosLibro[0] = libro.getNombre();
                datosLibro[1] = libro.getEspecialidad().getEspecialidad();
                datosLibro[2] = libro.getIsbn();
                datosLibro[3] = libro.getAutor();
                datosLibro[4] = libro.getEditorial();

                datosLibros.add(datosLibro);
            }
        }

        // Convertir la lista de datos de libros a una matriz
        String[][] resultado = new String[datosLibros.size()][5];
        for (int i = 0; i < datosLibros.size(); i++) {
            resultado[i] = datosLibros.get(i);
        }

        return resultado;
    }

    private String[][] registrarLibros() {
        String nombreBuscado = this.campoNombre.getText();

        if (nombreBuscado.isEmpty()) {
            return new String[0][0];
        }

        // Llama al método buscarUsuarioPorRut para obtener la información del usuario encontrado
        return buscarLibroPorNombre(nombreBuscado);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.botonBuscar) {
            String[] nombreColumnas = {"Nombre", "ISBN", "Autor", "Editorial", "Especialidad"};
            VentanaTabla ventanaTabla = new VentanaTabla(registrarLibros(), nombreColumnas);
        }
        if (e.getSource() == this.botonRegresar) {
            VentanaMenuBienvenida ventanaMenuBienvenida = new VentanaMenuBienvenida(biblioteca);
            this.dispose();
        }
    }
}
