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
    private String[][] registrarVehiculo(){
        List<Usuario> usuarios= new ArrayList<>();
        String[][] datosUsuarios;

        System.out.println(usuarios.size());
        datosUsuarios = new String[usuarios.size()][3];
        for(int i=0; i < usuarios.size(); i++){
            datosUsuarios[i][0]=usuarios.get(i).getNombre();
            datosUsuarios[i][1]=usuarios.get(i).getRut();
            datosUsuarios[i][2]= usuarios.get(i).getNumeroTelefonico();
        }
        return datosUsuarios;
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.botonBuscar){
            String[] nombreColumnas={"Nombre", "Rut", "Numero telefónico"};
            VentanaTabla ventanaTabla = new VentanaTabla(registrarVehiculo(),nombreColumnas);
        }
        if (e.getSource() == this.botonRegresar){
            VentanaMenuBienvenida ventanaMenuBienvenida = new VentanaMenuBienvenida(biblioteca);
            this.dispose();
        }

    }
}
