package RedProfesional.Arbol;

public interface ArbolTDA {
    void inicializarArbol(String raiz);
    void insertarHabilidad(String habilidadPadre, String nuevaHabilidad);
    boolean buscarHabilidad(String habilidad);
    void mostrarPreorden();
    void mostrarPostorden();
    void mostrarJerarquia();
    int contarHabilidades();
    boolean estaVacio();
}
