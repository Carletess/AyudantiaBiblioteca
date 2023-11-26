package ventana;

import controller.BibliotecaController;
import modelo.Biblioteca;
import ventana.*;

import javax.swing.*;
import java.awt.event.*;

public class VentanaMenuBienvenida extends Ventana {

    private JLabel textoMenu;
    private JButton botonAgregarLibro;

    private JButton botonAgregarUsuario;
    private JButton botonBuscarLibro;
    private JButton botonBuscarUsuario;
    private JButton botonSalida;
    protected Biblioteca biblioteca;

    public VentanaMenuBienvenida(Biblioteca biblioteca) {
        super("Menu Biblioteca", 500, 520);
        this.biblioteca = biblioteca;
        generarElementosVentana();
    }

    private void generarElementosVentana() {
        generarMensajeMenu();
        generarBotonAgregarLibro();
        generarBotonAgregarUsuario();
        generarBotonBuscarLibro();
        generarBotonBuscarUsuario();
        // generarBotonVenderVehiculo();
        generarBotonSalir();
    }

    private void generarMensajeMenu() {
        String textoBienvenida = "Sistema de Biblioteca";
        super.generarJLabelEncabezado(this.textoMenu, textoBienvenida, 20, 30, 500, 30);
    }

    private void generarBotonAgregarLibro() {
        String textoBoton = "Agregar Libro";
        this.botonAgregarLibro = super.generarBoton(textoBoton, 175, 100, 150, 40);
        this.add(this.botonAgregarLibro);
        this.botonAgregarLibro.addActionListener(this);
    }

    private void generarBotonAgregarUsuario() {
        String textoBoton = "Agregar Usuario";
        this.botonAgregarUsuario = super.generarBoton(textoBoton, 175, 180, 150, 40);
        this.add(this.botonAgregarUsuario);
        this.botonAgregarUsuario.addActionListener(this);
    }

    private void generarBotonBuscarLibro(){
        String textoBoton = "Buscar Libro";
        this.botonBuscarLibro=super.generarBoton(textoBoton, 175, 260, 150, 40);
        this.add(this.botonBuscarLibro);
        this.botonBuscarLibro.addActionListener(this);
    }

    private void generarBotonBuscarUsuario(){
        String textoBoton = "Buscar Usuario";
        this.botonBuscarUsuario=super.generarBoton(textoBoton, 175, 340, 150, 40);
        this.add(this.botonBuscarUsuario);
        this.botonBuscarUsuario.addActionListener(this);
    }

    private void generarBotonSalir() {
        String textoBoton = "Salir";
        this.botonSalida = super.generarBoton(textoBoton, 175, 420, 150, 40);
        this.add(this.botonSalida);
        this.botonSalida.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.botonAgregarLibro) {
            VentanaAgregarLibro ventanaAgregarLibro = new VentanaAgregarLibro(biblioteca);
            // Cierra la ventana actual
            this.dispose();
        }

        if (e.getSource() == this.botonAgregarUsuario) {
            VentanaAgregarUsuario ventanaAgregarUsuario = new VentanaAgregarUsuario(biblioteca);
            this.dispose();
        }

        if (e.getSource() == this.botonBuscarLibro) {
            VentanaBuscarLibro ventanaBuscarLibro = new VentanaBuscarLibro(biblioteca);
            this.dispose();
        }

        if (e.getSource() == this.botonBuscarUsuario) {
            VentanaBuscarUsuario ventanaBuscarUsuario = new VentanaBuscarUsuario(biblioteca);
            this.dispose();
        }

        if (e.getSource() == this.botonSalida) {
            BibliotecaController.almacenarDatos(this.biblioteca);
            this.dispose();
            System.exit(0);
        }
    }
}