package modelo;

public abstract class Persona {
    protected String nombre;
    protected String rut;

    public Persona(String nombre, String rut) {
        this.nombre = nombre;
        this.rut = rut;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return this.rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

}