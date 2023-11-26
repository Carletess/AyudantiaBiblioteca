package ventana;

import modelo.Biblioteca;

import javax.swing.*;
import javax.swing.text.InternationalFormatter;
import java.awt.event.ActionEvent;

public class VentanaAgregarUsuario extends Ventana {
    private JLabel textoEncabezado, textoRut, textoNombre, textoDireccion, textoNumeroTelefonico, textoCorreo;
    private JTextField campoRut, campoNombre, campoNumeroTelefonico;
    private JButton botonRegistrar, botonCancelar;
    private Biblioteca biblioteca;


    public VentanaAgregarUsuario(Biblioteca biblioteca){
        super("Registro de Usuario", 500, 520);
        this.biblioteca = biblioteca;
        generarElementosVentana();
    }
    private void generarElementosVentana() {
        generarEncabezado();
        generarBotonCancelar();
        generarBotonRegistrar();
        generarCampoNombre();
        generarCampoNumeroTelefonico();
        generarCampoRut();
    }
    private void generarEncabezado() {
        String textoCabecera = "Registro de Usuarios";
        super.generarJLabelEncabezado(this.textoEncabezado, textoCabecera, 190, 10, 200, 50);

    }

    private void generarCampoNombre(){
        String textoNombre= "Nombre:";
        super.generarJLabel(this.textoNombre,textoNombre,20,50,150,20);
        this.campoNombre= super.generarJTextField(200,50,250,20);
        this.add(this.campoNombre);
    }
    private void generarCampoRut(){
        String textoRut= "Rut:";
        super.generarJLabel(this.textoRut,textoRut,20,100,150,20);
        this.campoRut= super.generarJTextField(200,100,250,20);
        this.add(this.campoRut);
    }

    private void generarCampoNumeroTelefonico(){
        String textoNumero= "Número telefónico:";
        super.generarJLabel(this.textoNumeroTelefonico,textoNumero,20,250,150,20);
        this.campoNumeroTelefonico= super.generarJTextField(200,250,250,20);
        this.add(this.campoNumeroTelefonico);
    }
    private boolean registrarUsuario(){
        return biblioteca.agregarUsuario(this.campoNombre.getText(), this.campoRut.getText(),this.campoNumeroTelefonico.getText());
    }

    private void generarBotonRegistrar() {
        String textoBoton= "Registrar Cliente";
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

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.botonRegistrar) {
            if(registrarUsuario()) {
                JOptionPane.showMessageDialog(this,"Usuario registrado correctamente");
                VentanaMenuBienvenida ventanaMenuBienvenida = new VentanaMenuBienvenida(biblioteca);
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(this,"Ingrese un rut válido");
            }

        }
        if (e.getSource() == this.botonCancelar){
            VentanaMenuBienvenida ventanaMenuBienvenida = new VentanaMenuBienvenida(biblioteca);
            this.dispose();
        }

    }

}