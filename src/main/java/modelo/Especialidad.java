package modelo;

public enum Especialidad {
    SUSPENSO("Suspenso"),
    CIENCIA_FICCION("Ciencia Ficción"),
    TERROR("Terror"),
    AUTO_AYUDA("Auto Ayuda");

    private String especialidad;

    private Especialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }
}
