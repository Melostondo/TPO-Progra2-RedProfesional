package RedProfesional;

import RedProfesional.Arbol.ArbolHabilidades;
import RedProfesional.Diccionario.DiccionarioUsuarios;
import RedProfesional.Grafo.RedConexiones;
import RedProfesional.Cola.ColaTDA;
import RedProfesional.Cola.BandejaPostulaciones;
import RedProfesional.Pila.PilaTDA;
import RedProfesional.Pila.RegistroCambios;

public class Main {
    public static void main(String[] args) {

        System.out.println("====================================");
        System.out.println(" PRUEBA 1: BÚSQUEDA DE USUARIOS");
        System.out.println("====================================");

        // Crear diccionario
        DiccionarioUsuarios diccionario = new DiccionarioUsuarios();
        diccionario.inicializarDiccionario();

        // Crear perfiles
        Perfil perfil1 = new Perfil("Programador Java", "2 años");
        Perfil perfil2 = new Perfil("Analista Funcional", "3 años");

        // Crear usuarios
        Usuario usuario1 = new Usuario(1, "Juan", "juan@gmail.com", perfil1);
        Usuario usuario2 = new Usuario(2, "Pedro", "pedro@gmail.com", perfil2);

        // Insertar usuarios
        diccionario.insertar(1, usuario1);
        diccionario.insertar(2, usuario2);

        System.out.println("Cantidad de usuarios: " + diccionario.tamano());

        System.out.println("\nUsuario con ID 1:");
        System.out.println(diccionario.recuperar(1));

        // Modificar usuario
        Perfil perfilNuevo = new Perfil("Desarrollador Senior", "5 años");
        Usuario usuarioActualizado = new Usuario(1, "Juan Actualizado", "juannuevo@gmail.com", perfilNuevo);

        diccionario.modificar(1, usuarioActualizado);

        System.out.println("\nUsuario modificado:");
        System.out.println(diccionario.recuperar(1));

        // Eliminar usuario
        diccionario.eliminar(2);

        System.out.println("\nCantidad luego de eliminar: " + diccionario.tamano());
        System.out.println("¿Existe ID 2? " + diccionario.pertenece(2));


        System.out.println("\n====================================");
        System.out.println(" PRUEBA 2: RED PROFESIONAL");
        System.out.println("====================================");

        /*
         * PRUEBA DEL GRAFO DE CONEXIONES ENTRE USUARIOS
         * Se verifica:
         * - Inserción de usuarios como vértices
         * - Creación de conexiones
         * - Verificación de conexiones
         * - Visualización de matriz de adyacencia
         */

        RedConexiones red = new RedConexiones();

        // Insertar usuarios como vértices
        red.insertarVertice(usuario1);
        red.insertarVertice(usuario2);

        // Crear conexión entre usuarios
        red.insertarArista(usuario1, usuario2);

        // Mostrar usuarios y conexiones
        red.mostrarVertices();
        red.mostrarMatriz();

        System.out.println("\n¿Juan está conectado con Pedro? " + red.existeArista(usuario1, usuario2));
        System.out.println("¿Pedro está conectado con Juan? " + red.existeArista(usuario2, usuario1));


        System.out.println("\n====================================");
        System.out.println(" PRUEBA 3: JERARQUÍA DE HABILIDADES");
        System.out.println("====================================");

        ArbolHabilidades arbol = new ArbolHabilidades();

        // Crear raíz
        arbol.inicializarArbol("Tecnología");

        // Agregar categorías
        arbol.insertarHabilidad("Tecnología", "Desarrollo");
        arbol.insertarHabilidad("Tecnología", "Infraestructura");

        // Agregar subcategorías
        arbol.insertarHabilidad("Desarrollo", "Java");
        arbol.insertarHabilidad("Desarrollo", "Python");
        arbol.insertarHabilidad("Infraestructura", "Redes");

        // Mostrar árbol
        System.out.println("\nJerarquía de habilidades:");
        arbol.mostrarJerarquia();

        // Buscar habilidad
        System.out.println("\n¿Existe Java? " + arbol.buscarHabilidad("Java"));

        // Contar habilidades
        System.out.println("Cantidad total de habilidades: " + arbol.contarHabilidades());


        System.out.println("\n====================================");
        System.out.println(" PRUEBA 4: GESTIÓN DE POSTULACIONES (COLA)");
        System.out.println("====================================");

        /*
         * PRUEBA DE LA COLA DE POSTULACIONES LABORALES
         * Se verifica:
         * - Inicialización de la cola
         * - Acolar postulaciones asociadas a usuarios
         * - Procesamiento respetando el orden de llegada (FIFO)
         */

        // Crear cola
        ColaTDA colaPostulaciones = new BandejaPostulaciones();
        colaPostulaciones.inicializarCola();

        // Crear postulaciones
        Postulacion post1 = new Postulacion(101, usuario1.getIdUsuario(), "Desarrollador Backend", "10-06-2026");
        Postulacion post2 = new Postulacion(102, usuario2.getIdUsuario(), "Arquitecto de Software", "11-06-2026");

        // Acolar postulaciones
        colaPostulaciones.acolar(post1);
        System.out.println("Postulación encolada: " + post1.getPuesto());
        colaPostulaciones.acolar(post2);
        System.out.println("Postulación encolada: " + post2.getPuesto());

        // Procesar y desacolar postulaciones
        System.out.println("\nProcesando postulaciones:");
        while (!colaPostulaciones.colaVacia()) {
            System.out.println("Atendiendo postulación: " + colaPostulaciones.primero().getPuesto());
            colaPostulaciones.desacolar();
        }


        System.out.println("\n====================================");
        System.out.println(" PRUEBA 5: HISTORIAL DE CAMBIOS (PILA)");
        System.out.println("====================================");

        /*
         * PRUEBA DE LA PILA DE HISTORIAL DE CAMBIOS
         * Se verifica:
         * - Inicialización de la pila
         * - Apilar modificaciones de perfil
         * - Desapilar para deshacer la última actualización (LIFO)
         */

        // Crear pila
        PilaTDA historial = new RegistroCambios();
        historial.inicializarPila();

        // Crear registros de cambios
        HistorialCambios cambio1 = new HistorialCambios("12-06-2026", "Se actualizó la experiencia a 5 años", perfil1);
        HistorialCambios cambio2 = new HistorialCambios("13-06-2026", "Se agregó habilidad Java", perfil1);

        // Apilar cambios
        historial.apilar(cambio1);
        System.out.println("Cambio apilado: " + cambio1.getDescripcionCambio());
        historial.apilar(cambio2);
        System.out.println("Cambio apilado: " + cambio2.getDescripcionCambio());

        // Deshacer último cambio
        System.out.println("\nDeshaciendo el último cambio:");
        if (!historial.pilaVacia()) {
            System.out.println("Deshaciendo: " + historial.tope().getDescripcionCambio());
            historial.desapilar();
        }

        // Mostrar estado del tope
        System.out.println("Último estado en el tope:");
        if (!historial.pilaVacia()) {
            System.out.println(historial.tope().getDescripcionCambio());
        }
    }
}