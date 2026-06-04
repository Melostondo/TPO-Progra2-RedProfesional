package RedProfesional.Cola;

import RedProfesional.Postulacion;

public interface ColaTDA {
    void inicializarCola();
    void acolar(Postulacion x);
    void desacolar();
    Postulacion primero();
    boolean colaVacia();
}