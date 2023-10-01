package org.example;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private final List<Libro> libros = new ArrayList<>(); // final
    private String nombre;
    private String direccion;

    // constructor
    public Biblioteca(String nombre, String direccion, Libro libro) {
        this.libros.add(libro);
        this.nombre = nombre;
        this.direccion = direccion;
    }

    // getters
    public List<Libro> obtenerListaDeLibros(){
        return this.libros;
    }

    public String obtenerNombreDeBiblioteca(){
        return this.nombre;
    }

    public String obtenerDireccionDeBiblioteca(){
        return this.direccion;
    }

    // setters
    // setear == set; para yo comprender mi código en el futuro
    public void setearLibro(Libro libro){
        this.libros.add(libro);
    }

    public void setearNombreDeBiblioteca(String nombre){
        this.nombre = nombre;
    }

    public void setearDireccionDeBiblioteca(String direccion){
        this.direccion = direccion;
    }
}