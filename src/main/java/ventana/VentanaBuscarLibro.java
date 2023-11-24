package ventana;

import modelo.Biblioteca;
import modelo.Especialidad;
import modelo.Libro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class VentanaBuscarLibro extends Ventana {
    private JButton botonBuscar, botonRegresar;
    private JLabel textoEncabezado, textoNombre;
    private JComboBox listaEspecialidad;
    private JTextField campoNombre;
    private Biblioteca biblioteca;

    public VentanaBuscarLibro(Biblioteca biblioteca) {
        super("Búsqueda de Libros", 500, 520);
        this.biblioteca = biblioteca;
        generarElementosVentana();
    }

    private void generarElementosVentana() {
        generarCampoNombre();
        generarBotonBuscarVehiculo();
        generarBotonCancelar();
    }

    private void generarCampoNombre(){
        String textoNombre= "Nombre Libro:";
        super.generarJLabel(this.textoNombre,textoNombre,20,50,150,20);
        this.campoNombre= super.generarJTextField(200,50,250,20);
        this.add(this.campoNombre);
    }

    private void generarBotonBuscarVehiculo() {
        String textoBoton= "Buscar Libro";
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
    private String[][] registrarLibro(){
        List<Libro> libros= new ArrayList<>();
        String[][] datosLibros;
        if(this.campoNombre.getText().length()==0){
            System.out.println(this.listaEspecialidad.getSelectedItem());
            libros = biblioteca.obtenerLibroPorEspecialidad((Especialidad) this.listaEspecialidad.getSelectedItem());
        }

        System.out.println(libros.size());
        datosLibros = new String[libros.size()][5];
        for(int i=0; i < libros.size(); i++){
            datosLibros[i][0]=libros.get(i).getNombre();
            datosLibros[i][1]=libros.get(i).getEspecialidad().getEspecialidad();
            datosLibros[i][2]=libros.get(i).getIsbn();
            datosLibros[i][3]=libros.get(i).getAutor();
            datosLibros[i][4]=libros.get(i).getEditorial();
        }
        return datosLibros;
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.botonBuscar){
            String[] nombreColumnas={"Nombre","Especialidad","ISBN","Autor","Editorial"};
            VentanaTabla ventanaTabla = new VentanaTabla(registrarLibro(),nombreColumnas);
        }
        if (e.getSource() == this.botonRegresar){
            VentanaMenuBienvenida ventanaMenuBienvenida = new VentanaMenuBienvenida(biblioteca);
            this.dispose();
        }

    }
}
