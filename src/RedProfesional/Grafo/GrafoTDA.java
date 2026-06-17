package RedProfesional.Grafo;
import RedProfesional.Usuario;

public interface GrafoTDA {

    void insertarVertice(Usuario usuario);
    void eliminarVertice(Usuario usuario);
    void insertarArista(Usuario origen, Usuario destino);
    void eliminarArista(Usuario origen, Usuario destino);
    boolean existeVertice(Usuario usuario);
    boolean existeArista(Usuario origen, Usuario destino);
    void mostrarMatriz();
    void mostrarVertices();
    int gradoSeparacion(Usuario origen, Usuario destino);
    void sugerirContactos(Usuario usuario);
}
