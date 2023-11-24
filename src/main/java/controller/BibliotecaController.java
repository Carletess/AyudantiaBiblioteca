package controller;

import data.GestorDatos;
import modelo.Biblioteca;
import modelo.Especialidad;
import modelo.Libro;

import java.util.List;

public class BibliotecaController {

    public static Biblioteca cargaMasivaDatos(Biblioteca biblioteca){
        GestorDatos.leerArchivoLibros(biblioteca, "libros.txt");
        GestorDatos.leerArchivoUsuarios(biblioteca, "usuarios.txt");
        return biblioteca;
    }
    public static List buscarLibro(Biblioteca biblioteca, String nombre){
        return biblioteca.obtenerLibroPorNombre(nombre);
    }
    public static Libro agregarLibro(Biblioteca biblioteca, String nombre, String isbn, String autor, String editorial,Especialidad especialidad){
        return biblioteca.agregarLibro(nombre, isbn, autor, editorial, especialidad);
    }

    public static void almacenarDatos(Biblioteca biblioteca){
        GestorDatos.registrarDatos(biblioteca.getUsuarios(),"usuarios.txt");
        GestorDatos.registrarDatos(biblioteca.getLibros(),"libros.txt");
    }
}
