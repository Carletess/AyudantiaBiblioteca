package org.example;


public class Libro {
    private String nombre;
    private String autor;
    private String editorial;

    //constructor
    public Libro(String nombre, String autor, String editorial){
        this.nombre = nombre;
        this.autor = autor;
        this.editorial = editorial;
    }

    // getters
    public String obtenerNombreDeLibro(){
        return nombre;
    }

    public String obtenerAutorDeLibro(){
        return autor;
    }

    public String obtenerEditorialDeLibro(){
        return editorial;
    }

    // setters
    // setear == set; para yo comprender mi código en el futuro
    public void setearNombreDeLibro(String nombre){
        this.nombre = nombre;
    }

    public void setearAutorDeLibro(String autor){
        this.autor = autor;
    }

    public void setearEditorialDeLibro(String editorial){
        this.editorial = editorial;
    }
}
