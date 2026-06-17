package RedProfesional.Pila;

import RedProfesional.HistorialCambios;

public class RegistroCambios implements PilaTDA {
    private NodoCambio tope;

    @Override
    public void inicializarPila() {
        tope = null;
    }

    @Override
    public void apilar(HistorialCambios x) {
        NodoCambio nuevo = new NodoCambio();
        nuevo.valor = x;
        nuevo.siguiente = tope;
        tope = nuevo;
    }

    @Override
    public void desapilar() {
        if (pilaVacia()) {
            System.out.println("Error: no se puede desapilar porque la pila está vacía.");
        } else {
            tope = tope.siguiente;
        }
    }

    @Override
    public HistorialCambios tope() {
        if (pilaVacia()) {
            System.out.println("Error: la pila está vacía.");
            return null;
        }

        return tope.valor;
    }

    @Override
    public boolean pilaVacia() {
        return tope == null;
    }
}