package modelo;

public enum Especialidad {
    SUSPENSO("SUSPENSO"),
    CIENCIA_FICCION("CIENCIA FICCION"),
    TERROR("TERROR"),
    AUTO_AYUDA("AUTO AYUDA");

    private String especialidad;
    private Especialidad(String especialidad){
        this.especialidad= especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }
}
