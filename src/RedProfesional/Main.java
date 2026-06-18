package RedProfesional;

import RedProfesional.Arbol.ArbolHabilidades;
import RedProfesional.Cola.BandejaPostulaciones;
import RedProfesional.Cola.ColaTDA;
import RedProfesional.Diccionario.DiccionarioUsuarios;
import RedProfesional.Grafo.RedConexiones;
import RedProfesional.Pila.PilaTDA;
import RedProfesional.Pila.RegistroCambios;

public class Main {

    public static void main(String[] args) {

        /*
         * ============================================================
         * CASOS DE PRUEBA - TPO RED PROFESIONAL
         * ============================================================
         * Este Main permite demostrar el funcionamiento de los módulos
         * principales implementados:
         *
         * 1. Diccionario de usuarios
         * 2. Grafo de conexiones profesionales
         * 3. Árbol de habilidades
         * 4. Cola de postulaciones
         * 5. Pila de historial de cambios
         * ============================================================
         */

        // ============================================================
        // DATOS BASE PARA LAS PRUEBAS
        // ============================================================

        Perfil perfil1 = new Perfil("Programador Java", "2 años");
        Perfil perfil2 = new Perfil("Analista Funcional", "3 años");
        Perfil perfil3 = new Perfil("Analista de Datos", "1 año");
        Perfil perfil4 = new Perfil("Especialista en Redes", "4 años");

        Usuario usuario1 = new Usuario(1, "Juan", "juan@gmail.com", perfil1);
        Usuario usuario2 = new Usuario(2, "Pedro", "pedro@gmail.com", perfil2);
        Usuario usuario3 = new Usuario(3, "Manuel", "manuel@gmail.com", perfil3);
        Usuario usuario4 = new Usuario(4, "Ana", "ana@gmail.com", perfil4);


        // ============================================================
        // CASO DE PRUEBA 1: DICCIONARIO DE USUARIOS
        // ============================================================

        System.out.println("\n====================================");
        System.out.println(" CASO 1: BÚSQUEDA DE USUARIOS");
        System.out.println("====================================");

        DiccionarioUsuarios diccionario = new DiccionarioUsuarios();
        diccionario.inicializarDiccionario();

        System.out.println("\nFuncionalidad evaluada: alta y búsqueda de usuarios por ID.");

        diccionario.insertar(usuario1.getIdUsuario(), usuario1);
        diccionario.insertar(usuario2.getIdUsuario(), usuario2);
        diccionario.insertar(usuario3.getIdUsuario(), usuario3);
        diccionario.insertar(usuario4.getIdUsuario(), usuario4);

        System.out.println("Resultado esperado: 4 usuarios registrados.");
        System.out.println("Resultado obtenido: " + diccionario.tamano() + " usuarios registrados.");

        System.out.println("\nBúsqueda de usuario existente con ID 1:");
        System.out.println("Resultado esperado: encontrar a Juan.");
        System.out.println("Resultado obtenido: " + diccionario.recuperar(1));

        System.out.println("\nBúsqueda de usuario inexistente con ID 99:");
        System.out.println("Resultado esperado: null.");
        System.out.println("Resultado obtenido: " + diccionario.recuperar(99));

        System.out.println("\nModificación del perfil del usuario con ID 1:");
        Perfil perfilActualizado = new Perfil("Desarrollador Senior", "5 años");
        Usuario usuario1Actualizado = new Usuario(1, "Juan Actualizado", "juannuevo@gmail.com", perfilActualizado);

        diccionario.modificar(1, usuario1Actualizado);

        System.out.println("Resultado esperado: usuario con datos actualizados.");
        System.out.println("Resultado obtenido: " + diccionario.recuperar(1));


        // ============================================================
        // CASO DE PRUEBA 2: GRAFO DE CONEXIONES PROFESIONALES
        // ============================================================

        System.out.println("\n====================================");
        System.out.println(" CASO 2: RED PROFESIONAL");
        System.out.println("====================================");

        /*
         * En esta prueba se verifica:
         * - Inserción de usuarios como vértices.
         * - Creación de conexiones como aristas.
         * - Verificación de conexiones.
         * - Cálculo del grado de separación.
         * - Sugerencia de contactos recomendados.
         */

        RedConexiones red = new RedConexiones();

        red.insertarVertice(usuario1Actualizado);
        red.insertarVertice(usuario2);
        red.insertarVertice(usuario3);
        red.insertarVertice(usuario4);

        red.insertarArista(usuario1Actualizado, usuario2);
        red.insertarArista(usuario2, usuario3);
        red.insertarArista(usuario2, usuario4);

        System.out.println("\nUsuarios cargados en la red:");
        red.mostrarVertices();

        System.out.println("\nMatriz de adyacencia:");
        red.mostrarMatriz();

        System.out.println("\nVerificación de conexión directa:");
        System.out.println("Resultado esperado: Juan y Pedro conectados = true.");
        System.out.println("Resultado obtenido: " + red.existeArista(usuario1Actualizado, usuario2));

        System.out.println("\nGrado de separación:");
        System.out.println("Resultado esperado entre Juan y Manuel: 2.");
        System.out.println("Resultado obtenido: " + red.gradoSeparacion(usuario1Actualizado, usuario3));

        System.out.println("\nContactos recomendados para Juan:");
        System.out.println("Resultado esperado: Manuel y Ana, porque tienen a Pedro como vínculo común.");
        System.out.println("Resultado obtenido:");
        red.sugerirContactos(usuario1Actualizado);


        // ============================================================
        // CASO DE PRUEBA 3: ÁRBOL DE HABILIDADES
        // ============================================================

        System.out.println("\n====================================");
        System.out.println(" CASO 3: JERARQUÍA DE HABILIDADES");
        System.out.println("====================================");

        /*
         * En esta prueba se verifica:
         * - Creación de una jerarquía de habilidades.
         * - Inserción de categorías y subcategorías.
         * - Búsqueda de habilidades.
         * - Visualización jerárquica.
         */

        ArbolHabilidades arbol = new ArbolHabilidades();

        arbol.inicializarArbol("Tecnología");

        arbol.insertarHabilidad("Tecnología", "Desarrollo");
        arbol.insertarHabilidad("Tecnología", "Infraestructura");

        arbol.insertarHabilidad("Desarrollo", "Java");
        arbol.insertarHabilidad("Desarrollo", "Python");

        arbol.insertarHabilidad("Infraestructura", "Redes");

        System.out.println("\nJerarquía de habilidades:");
        arbol.mostrarJerarquia();

        System.out.println("\nBúsqueda de habilidad existente:");
        System.out.println("Resultado esperado para Java: true.");
        System.out.println("Resultado obtenido: " + arbol.buscarHabilidad("Java"));

        System.out.println("\nBúsqueda de habilidad inexistente:");
        System.out.println("Resultado esperado para Marketing: false.");
        System.out.println("Resultado obtenido: " + arbol.buscarHabilidad("Marketing"));

        System.out.println("\nCantidad total de habilidades:");
        System.out.println("Resultado esperado: 6.");
        System.out.println("Resultado obtenido: " + arbol.contarHabilidades());


        // ============================================================
        // CASO DE PRUEBA 4: COLA DE POSTULACIONES
        // ============================================================

        System.out.println("\n====================================");
        System.out.println(" CASO 4: GESTIÓN DE POSTULACIONES");
        System.out.println("====================================");

        /*
         * En esta prueba se verifica:
         * - Registro de postulaciones.
         * - Procesamiento respetando el orden de llegada.
         * - Manejo de cola vacía.
         */

        ColaTDA colaPostulaciones = new BandejaPostulaciones();
        colaPostulaciones.inicializarCola();

        Postulacion post1 = new Postulacion(101, usuario1Actualizado.getIdUsuario(), "Desarrollador Backend", "10-06-2026");
        Postulacion post2 = new Postulacion(102, usuario2.getIdUsuario(), "Arquitecto de Software", "11-06-2026");
        Postulacion post3 = new Postulacion(103, usuario3.getIdUsuario(), "Analista de Datos", "12-06-2026");

        colaPostulaciones.acolar(post1);
        colaPostulaciones.acolar(post2);
        colaPostulaciones.acolar(post3);

        System.out.println("\nResultado esperado: las postulaciones se procesan en orden FIFO.");
        System.out.println("Resultado obtenido:");

        while (!colaPostulaciones.colaVacia()) {
            System.out.println("Atendiendo postulación: " + colaPostulaciones.primero().getPuesto());
            colaPostulaciones.desacolar();
        }

        System.out.println("\nPrueba de cola vacía:");
        System.out.println("Resultado esperado: mensaje de error controlado.");
        System.out.print("Resultado obtenido: ");
        colaPostulaciones.desacolar();


        // ============================================================
        // CASO DE PRUEBA 5: PILA DE HISTORIAL DE CAMBIOS
        // ============================================================

        System.out.println("\n====================================");
        System.out.println(" CASO 5: HISTORIAL DE CAMBIOS");
        System.out.println("====================================");

        /*
         * En esta prueba se verifica:
         * - Registro de cambios en una pila.
         * - Recuperación del último cambio realizado.
         * - Deshacer la última actualización.
         * - Manejo de pila vacía.
         */

        PilaTDA historial = new RegistroCambios();
        historial.inicializarPila();

        HistorialCambios cambio1 = new HistorialCambios("12-06-2026", "Se actualizó la experiencia a 5 años", perfil1);
        HistorialCambios cambio2 = new HistorialCambios("13-06-2026", "Se agregó habilidad Java", perfilActualizado);

        historial.apilar(cambio1);
        historial.apilar(cambio2);

        System.out.println("\nResultado esperado: el último cambio debe ser 'Se agregó habilidad Java'.");
        System.out.println("Resultado obtenido: " + historial.tope().getDescripcionCambio());

        System.out.println("\nDeshaciendo último cambio:");
        System.out.println("Cambio eliminado: " + historial.tope().getDescripcionCambio());
        historial.desapilar();

        System.out.println("\nResultado esperado: ahora el tope debe ser 'Se actualizó la experiencia a 5 años'.");
        System.out.println("Resultado obtenido: " + historial.tope().getDescripcionCambio());

        historial.desapilar();

        System.out.println("\nPrueba de pila vacía:");
        System.out.println("Resultado esperado: mensaje de error controlado.");
        System.out.print("Resultado obtenido: ");
        historial.desapilar();


        // ============================================================
        // FIN DE PRUEBAS
        // ============================================================

        System.out.println("\n====================================");
        System.out.println(" FIN DE LOS CASOS DE PRUEBA");
        System.out.println("====================================");
    }
}