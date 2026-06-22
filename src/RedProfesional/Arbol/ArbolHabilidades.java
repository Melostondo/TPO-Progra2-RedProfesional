package RedProfesional.Arbol;

/*
 * Árbol de habilidades profesionales.
 * Permite organizar competencias laborales de forma jerárquica,
 * por ejemplo: Tecnología > Desarrollo > Java.
 */
public class ArbolHabilidades implements ArbolTDA {

    private Nodo raiz;

    @Override
    public void inicializarArbol(String raiz) {

        this.raiz = new Nodo(raiz);
    }

    @Override
    public void insertarHabilidad(String habilidadPadre, String nuevaHabilidad) {
        Nodo padre = buscarNodo(this.raiz, habilidadPadre);

        if (padre == null) { // BUSCA LA HABILIAD PADRE, EJEMPLO DESARROLLO --> JAVA - PYTHON
            System.out.println("Error: no existe la habilidad padre.");

        } else if (padre.cantidadHijos == padre.hijos.length) { // VERIFICA SI TIENE EL MAXIMO DE HIJOS
            System.out.println("Error: no se pueden agregar más subhabilidades.");

        } else {
            padre.hijos[padre.cantidadHijos] = new Nodo(nuevaHabilidad); // CREA EL NODO, EJEMPLO PYTHON
            padre.cantidadHijos++;
        }
    }

    @Override
    public boolean buscarHabilidad(String habilidad) {

        return buscarNodo(this.raiz, habilidad) != null;
    }

    private Nodo buscarNodo(Nodo actual, String habilidad) {

        if (actual == null) {
            return null; // DEVUELVE NULL SI LLEGO A UN NODO VACIO, ESO QUIER DECIR QUE NO ENCONTRO NADA POR ESA RAMA
        }

        if (actual.nombre.equalsIgnoreCase(habilidad)) { // COMPARA EL NOMBRE DEL NODO ACTUAL CON LA HABILIDAD
            return actual;
        }

        for (int i = 0; i < actual.cantidadHijos; i++) { // SI NO LO ENCONTRO SE FIJA EN SUS HIJOS
            Nodo encontrado = buscarNodo(actual.hijos[i], habilidad); // LLAMADO RECURSIVO PARA SEGUIR LA BUSQUEDA CON CADA HIJO

            if (encontrado != null) {
                return encontrado; // SI LA ENCONTRO LA DEVUELVE
            }
        }

        return null;
    }

    @Override
    public void mostrarPreorden() {
        mostrarPreorden(this.raiz);
        System.out.println();
    }

    private void mostrarPreorden(Nodo actual) {
        if (actual == null) {
            return;
        }

        System.out.print(actual.nombre + " ");

        for (int i = 0; i < actual.cantidadHijos; i++) {
            mostrarPreorden(actual.hijos[i]);
        }
    }

    @Override
    public void mostrarPostorden() {
        mostrarPostorden(this.raiz);
        System.out.println();
    }

    private void mostrarPostorden(Nodo actual) {
        if (actual == null) {
            return;
        }

        for (int i = 0; i < actual.cantidadHijos; i++) {
            mostrarPostorden(actual.hijos[i]);
        }

        System.out.print(actual.nombre + " ");
    }

    @Override
    public void mostrarJerarquia() {
        mostrarJerarquia(this.raiz, 0);
    }

    private void mostrarJerarquia(Nodo actual, int nivel) {
        if (actual == null) {
            return; // SI EL NODO NO EXISTE TERMINA LA FUNCION RECURSIVA
        }

        for (int i = 0; i < nivel; i++) {
            System.out.print("  "); // IMPRIME ESPACIOS SEGUN EL NIVEL DEL NODO
        }

        System.out.println("- " + actual.nombre); // MUESTRA EL NOMBRE DE LA HABILIDAD ACUTAL

        for (int i = 0; i < actual.cantidadHijos; i++) {
            mostrarJerarquia(actual.hijos[i], nivel + 1);
        }
    }

    @Override
    public int contarHabilidades() {

        return contarHabilidades(this.raiz);
    }

    private int contarHabilidades(Nodo actual) {
        if (actual == null) {
            return 0;
        }

        int total = 1;

        for (int i = 0; i < actual.cantidadHijos; i++) {
            total += contarHabilidades(actual.hijos[i]);
        }

        return total;
    }

    @Override
    public boolean estaVacio() {

        return raiz == null;
    }
}