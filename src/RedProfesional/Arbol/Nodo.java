package RedProfesional.Arbol;

public class Nodo {
    String nombre;
    Nodo[] hijos;
    int cantidadHijos;

    public Nodo(String nombre) {
        this.nombre = nombre;
        this.hijos = new Nodo[10];
        this.cantidadHijos = 0;
    }
}