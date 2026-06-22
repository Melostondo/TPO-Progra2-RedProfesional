package RedProfesional.Cola;

import RedProfesional.Postulacion;

public class BandejaPostulaciones implements ColaTDA {
    private NodoPostulacion primero;
    private NodoPostulacion ultimo;

    @Override
    public void inicializarCola() {
        primero = null;
        ultimo = null;
    }

    @Override
    public void acolar(Postulacion x) { // AGREGA UNA NUEVA POSTULACION EN LA COLA
        NodoPostulacion nuevo = new NodoPostulacion();
        nuevo.valor = x;
        nuevo.siguiente = null;

        if (ultimo != null) {
            ultimo.siguiente = nuevo;
        }

        ultimo = nuevo;

        if (primero == null) {
            primero = ultimo;
        }
    }

    @Override
    public void desacolar() { // ELIMINA/ATIENDE LA POSTULACION QUE SE ENCUENTRA AL FRENTE DE LA COLA
        if (colaVacia()) {
            System.out.println("Error: no se puede desacolar porque la cola está vacía.");
        } else {
            primero = primero.siguiente;

            if (primero == null) {
                ultimo = null;
            }
        }
    }

    @Override
    public Postulacion primero() { // ATIENDE LA PRIMERA POSTULACION
        if (colaVacia()) {
            System.out.println("Error: la cola está vacía.");
            return null;
        }

        return primero.valor;
    }

    @Override
    public boolean colaVacia() {
        return primero == null;
    }
}