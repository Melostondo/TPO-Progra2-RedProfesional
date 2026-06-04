package RedProfesional.Pila;

import RedProfesional.HistorialCambios;

public interface PilaTDA {
    void inicializarPila();
    void apilar(HistorialCambios x);
    void desapilar();
    HistorialCambios tope();
    boolean pilaVacia();
}