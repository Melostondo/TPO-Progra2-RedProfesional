package RedProfesional;

import RedProfesional.Arbol.ArbolHabilidades;
import RedProfesional.Diccionario.DiccionarioUsuarios;
import RedProfesional.Grafo.RedConexiones;

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

    }
}