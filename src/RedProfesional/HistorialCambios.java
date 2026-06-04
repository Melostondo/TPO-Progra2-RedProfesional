package RedProfesional;

public class HistorialCambios {
    private String fechaCambio;
    private String descripcionCambio;
    private Perfil perfilAnterior;

    public HistorialCambios(String fechaCambio, String descripcionCambio, Perfil perfilAnterior) {
        this.fechaCambio = fechaCambio;
        this.descripcionCambio = descripcionCambio;
        this.perfilAnterior = perfilAnterior;
    }

    public String getFechaCambio() {
        return fechaCambio;
    }
    public void setFechaCambio(String fechaCambio) {
        this.fechaCambio = fechaCambio;
    }

    public String getDescripcionCambio() {
        return descripcionCambio;
    }
    public void setDescripcionCambio(String descripcionCambio) {
        this.descripcionCambio = descripcionCambio;
    }

    public Perfil getPerfilAnterior() {
        return perfilAnterior;
    }
    public void setPerfilAnterior(Perfil perfilAnterior) {
        this.perfilAnterior = perfilAnterior;
    }

    @Override
    public String toString() {
        return "HistorialCambios{" +
                "fechaCambio='" + fechaCambio + '\'' +
                ", descripcionCambio='" + descripcionCambio + '\'' +
                ", perfilAnterior=" + perfilAnterior +
                '}';
    }
}
