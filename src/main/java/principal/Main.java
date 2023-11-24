package principal;

import controller.BibliotecaController;
import modelo.Biblioteca;
import ventana.VentanaMenuBienvenida;

public class Main {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca("temuco", "god street");
        biblioteca = BibliotecaController.cargaMasivaDatos(biblioteca);
        VentanaMenuBienvenida ventana = new VentanaMenuBienvenida(biblioteca);
    }
}
