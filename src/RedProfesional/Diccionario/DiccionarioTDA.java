package RedProfesional.Diccionario;
import RedProfesional.Usuario;

public interface DiccionarioTDA {
    void inicializarDiccionario();
    void insertar(int clave, Usuario valor);
    void eliminar(int clave);
    Usuario recuperar(int clave);
    boolean pertenece(int clave);
    void modificar(int clave, Usuario nuevoValor);
    int tamano();
    boolean estaVacia();
    int[] listarClaves();
}
