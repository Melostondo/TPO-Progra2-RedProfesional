package RedProfesional;

public class Perfil {
    private String descripcion;
    private String experiencia;

    public Perfil(String descripcion, String experiencia) {
        this.descripcion = descripcion;
        this.experiencia = experiencia;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getExperiencia() {
        return experiencia;
    }
    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    @Override
    public String toString() {
        return "Perfil{" +
                "descripcion='" + descripcion + '\'' +
                ", experiencia='" + experiencia + '\'' +
                '}';
    }
}
