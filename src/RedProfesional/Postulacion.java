package RedProfesional;

public class Postulacion {
    private int idPostulacion;
    private int idUsuario;
    private String puesto;
    private String fecha;

    public Postulacion(int idPostulacion, int idUsuario, String puesto, String fecha) {
        this.idPostulacion = idPostulacion;
        this.idUsuario = idUsuario;
        this.puesto = puesto;
        this.fecha = fecha;
    }

    public int getIdPostulacion() {
        return idPostulacion;
    }
    public void setIdPostulacion(int idPostulacion) {
        this.idPostulacion = idPostulacion;
    }

    public int getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getPuesto() {
        return puesto;
    }
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Postulacion{" +
                "idPostulacion=" + idPostulacion +
                ", idUsuario=" + idUsuario +
                ", puesto='" + puesto + '\'' +
                ", fecha='" + fecha + '\'' +
                '}';
    }
}
