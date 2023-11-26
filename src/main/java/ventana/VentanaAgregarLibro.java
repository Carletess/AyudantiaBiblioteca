package ventana;

import modelo.Biblioteca;
import modelo.Bibliotecario;
import modelo.Especialidad;

import javax.swing.*;
import javax.swing.text.InternationalFormatter;
import java.awt.event.ActionEvent;

public class VentanaAgregarLibro extends Ventana {
    private JLabel textoEncabezado, textoEspecialidad, textoNombre, textoISBN, textoAutor, textoEditorial;
    private JTextField campoNombre, campoISBN, campoAutor, campoEditorial;
    private JButton botonRegistrar, botonCancelar;
    private JFormattedTextField campoEspecialidad;
    private JComboBox listaEspecialidad;
    private Biblioteca biblioteca;
    private void generarEncabezado() {
        String textoCabecera = "Registro de Libros";
        super.generarJLabelEncabezado(this.textoEncabezado, textoCabecera, 190, 10, 200, 50);

    }
    public VentanaAgregarLibro(Biblioteca biblioteca){
        super("Registro de Libros", 500, 520);
        this.biblioteca= biblioteca;
        generarElementosVentana();
    }
    private void generarElementosVentana() {
        generarEncabezado();
        generarListaEspecialidad();
        generarCampoNombre();
        generarCampoISBN();
        generarCampoAutor();
        generarCampoEditorial();
        generarBotonRegistrar();
        generarBotonCancelar();
    }

    private void generarCampoNombre(){
        String textoNombre= "Nombre Libro: ";
        super.generarJLabel(this.textoNombre,textoNombre,20,50,150,20);
        this.campoNombre= super.generarJTextField(200,50,250,20);
        this.add(this.campoNombre);
    }

    private void generarListaEspecialidad(){
        super.generarJLabel(this.textoEspecialidad,"Especialidad libro:",20,100,100,20);
        String [] listaDesplegable = new String[]{"Suspenso","Ciencia ficcion","Terror","Auto Ayuda"};
        this.listaEspecialidad=super.generarListaDesplegable(listaDesplegable,120,100, 100, 20);
        this.add(this.listaEspecialidad);
    }


    private void generarCampoISBN() {
        super.generarJLabel(this.textoISBN, "ISBN:", 20, 150, 200, 20);
        this.campoISBN = super.generarJTextField(200, 150, 250, 20);
        this.add(this.campoISBN);
    }

    private void generarCampoAutor() {
        super.generarJLabel(this.textoAutor, "Autor:", 20, 200, 200, 20);
        this.campoAutor = super.generarJTextField(200, 200, 250, 20);
        this.add(this.campoAutor);
    }

    private void generarCampoEditorial() {
        super.generarJLabel(this.textoEditorial, "Editorial:", 20, 250, 200, 20);
        this.campoEditorial = super.generarJTextField(200, 250, 250, 20);
        this.add(this.campoEditorial);
    }

    private void generarBotonRegistrar() {
        String textoBoton= "Registrar Libro";
        this.botonRegistrar = super.generarBoton(textoBoton, 75, 400, 150, 20);
        this.add(this.botonRegistrar);
        this.botonRegistrar.addActionListener(this);
    }
    private void generarBotonCancelar() {
        String textoBotonCancelar = "Cancelar";
        this.botonCancelar = super.generarBoton(textoBotonCancelar, 275, 400, 150, 20);
        this.add(this.botonCancelar);
        this.botonCancelar.addActionListener(this);
    }

    private boolean registrarLibro() {
        if (this.campoNombre.getText().isEmpty() || this.campoISBN.getText().isEmpty() ||
                this.campoAutor.getText().isEmpty() || this.campoEditorial.getText().isEmpty() ||
                this.listaEspecialidad.getSelectedItem() == null) {
            return false;
        } else {
            try {
                String nombre = this.campoNombre.getText();
                String isbn = this.campoISBN.getText();
                String autor = this.campoAutor.getText();
                String editorial = this.campoEditorial.getText();

                // Obtén la especialidad seleccionada como String desde la lista desplegable
                String especialidadSeleccionada = (String) this.listaEspecialidad.getSelectedItem();

                // Convierte el String a un elemento del enum Especialidad
                Especialidad especialidad = Especialidad.valueOf(especialidadSeleccionada.replace(" ", "_").toUpperCase());

                biblioteca.agregarLibro(nombre, isbn, autor, editorial, especialidad);
                return true;
            } catch (IllegalArgumentException e) {
                // Manejo de excepciones si la conversión falla (por ejemplo, si el String no coincide con ningún valor del enum)
                return false;
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.botonRegistrar){
            if(registrarLibro()){
                Especialidad especialidad = Especialidad.valueOf(((String) this.listaEspecialidad.getSelectedItem()).replace(" ", "_").toUpperCase());
                JOptionPane.showMessageDialog(this,"Libro registrado correctamente","Mensaje de confirmación",
                        JOptionPane.INFORMATION_MESSAGE);
                VentanaMenuBienvenida ventanaMenuBienvenida = new VentanaMenuBienvenida(biblioteca);
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(this,"Complete todos los datos", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource() == this.botonCancelar){
            VentanaMenuBienvenida ventanaMenuBienvenida = new VentanaMenuBienvenida(biblioteca);
            this.dispose();
        }

    }
}