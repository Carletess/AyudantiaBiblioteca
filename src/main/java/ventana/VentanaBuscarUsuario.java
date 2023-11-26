package ventana;

import modelo.Biblioteca;
import modelo.Especialidad;
import modelo.Libro;
import modelo.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class VentanaBuscarUsuario extends Ventana {
    private JButton botonBuscar, botonRegresar;
    private JLabel textoEncabezado, textoRut;
    private JComboBox listaEspecialidad;
    private JTextField campoRut;
    private Biblioteca biblioteca;

    public VentanaBuscarUsuario(Biblioteca biblioteca) {
        super("Búsqueda de Usuarios", 500, 520);
        this.biblioteca = biblioteca;
        generarElementosVentana();
    }

    private void generarElementosVentana() {
        generarCampoRut();
        generarBotonBuscarPersona();
        generarBotonCancelar();
    }

    private void generarCampoRut(){
        String textoRut= "Rut Usuario:";
        super.generarJLabel(this.textoRut,textoRut,20,50,150,20);
        this.campoRut= super.generarJTextField(200,50,250,20);
        this.add(this.campoRut);
    }

    private void generarBotonBuscarPersona() {
        String textoBoton= "Buscar Persona por Rut";
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
    private String[][] buscarUsuarioPorRut(String rut) {
        List<Usuario> usuarios = biblioteca.getUsuarios();
        String[][] datosUsuario = new String[1][3];

        for (Usuario usuario : usuarios) {
            if (usuario.getRut().equals(rut)) {
                // Si el RUT coincide, se agrega la información del usuario a la matriz
                datosUsuario[0][0] = usuario.getNombre();
                datosUsuario[0][1] = usuario.getRut();
                datosUsuario[0][2] = usuario.getNumeroTelefonico();
                break;  // Termina la búsqueda después de encontrar el usuario
            }
        }
        return datosUsuario;
    }


    private String[][] registrarUsuarios() {
        String rutBuscado = this.campoRut.getText();

        if (rutBuscado.isEmpty()) {
            // Si el campo de RUT está vacío, mostrar un mensaje de error o manejar de alguna manera
            return new String[0][0];
        }

        // Llama al método buscarUsuarioPorRut para obtener la información del usuario encontrado
        return buscarUsuarioPorRut(rutBuscado);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.botonBuscar) {
            String[] nombreColumnas = {"Nombre", "Rut", "Numero telefónico"};
            VentanaTabla ventanaTabla = new VentanaTabla(registrarUsuarios(), nombreColumnas);
        }
        if (e.getSource() == this.botonRegresar) {
            VentanaMenuBienvenida ventanaMenuBienvenida = new VentanaMenuBienvenida(biblioteca);
            this.dispose();
        }
    }

}