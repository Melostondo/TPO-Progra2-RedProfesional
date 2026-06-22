package RedProfesional.Diccionario;
import RedProfesional.Usuario;

/*
 * Implementación de un Diccionario TDA para gestionar usuarios.
 * Cada usuario se almacena mediante una clave única (ID),
 * permitiendo operaciones de inserción, búsqueda, modificación y eliminación.
 */

public class DiccionarioUsuarios implements DiccionarioTDA {

    private static final int MAX = 100;
    private int[] claves;
    private Usuario[] valores;
    private int cant;

    @Override
    public void inicializarDiccionario() {
        claves = new int[MAX];
        valores = new Usuario[MAX];
        cant = 0;
    }

    private int buscarPosicion(int clave) { //BUSCA LA POSICION DEL USUARIO MEDIANTE SU CLAVE
        for (int i = 0; i < cant; i++) {
            if (claves[i] == clave) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void insertar(int clave, Usuario valor) { // INSERTA UN USUARIO AL DICCIONARIO
        if (cant == MAX) {
            System.out.println("Error: diccionario lleno");
        } else if (pertenece(clave)) {
            System.out.println("Error: la clave ya existe");
        } else {
            claves[cant] = clave;
            valores[cant] = valor;
            cant++;
        }
    }

    @Override
    public void eliminar(int clave) { //ELIMINA AL USUARIO DEL DICCIONARIO MEDIANTE LA CALVE
        int pos = buscarPosicion(clave);

        if (pos == -1) {
            System.out.println("Error: clave inexistente");
        } else {
            for (int i = pos; i < cant - 1; i++) {
                claves[i] = claves[i + 1];
                valores[i] = valores[i + 1];
            }
            cant--;
        }
    }

    @Override
    public Usuario recuperar(int clave) { // MEDIANTE LA CLAVE OBTIENE LOS VALORES
        int pos = buscarPosicion(clave);

        if (pos == -1) {
            return null;
        }

        return valores[pos];
    }

    @Override
    public boolean pertenece(int clave) { // BUSCA AL USUARIO MEDIANTE LA CLAVE PARA VERIFICAR SI PERTENCE

        return buscarPosicion(clave) != -1;
    }

    @Override
    public void modificar(int clave, Usuario nuevoValor) { // MODIFICA AL USUARIO MEDIANTE LA BUSQUEDA POR CLAVE
        int pos = buscarPosicion(clave);

        if (pos == -1) {
            System.out.println("Error: clave inexistente");
        } else {
            valores[pos] = nuevoValor;
        }
    }

    @Override
    public int tamano() {

        return cant;
    }

    @Override
    public boolean estaVacia() {
        return cant == 0;
    }

    @Override
    public int[] listarClaves() {
        int[] resultado = new int[cant];

        for (int i = 0; i < cant; i++) {
            resultado[i] = claves[i];
        }

        return resultado;
    }
}