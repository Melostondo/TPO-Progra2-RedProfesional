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
        tope = tope.siguiente;
    }

    @Override
    public HistorialCambios tope() {
        return tope.valor;
    }

    @Override
    public boolean pilaVacia() {
        return (tope == null);
    }
}