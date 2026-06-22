package RedProfesional.Grafo;

import RedProfesional.Usuario;

/*
 * Grafo de conexiones entre usuarios de la red profesional.
 * Cada usuario es un vértice y cada conexión entre usuarios es una arista.
 * Se utiliza una matriz de adyacencia para representar los contactos.
 */

public class RedConexiones implements GrafoTDA {

    private static final int MAX = 100;
    private Usuario[] vertices;
    private int[][] matriz;
    private int cantidad;

    public RedConexiones() {
        vertices = new Usuario[MAX];
        matriz = new int[MAX][MAX];
        cantidad = 0;
    }

    @Override
    public void insertarVertice(Usuario usuario) {
        if (cantidad == MAX) {
            System.out.println("Error: no se pueden insertar más usuarios.");
        } else if (existeVertice(usuario)) {
            System.out.println("Error: el usuario ya existe en la red.");
        } else {
            vertices[cantidad] = usuario;
            cantidad++;
        }
    }

    @Override
    public void eliminarVertice(Usuario usuario) {
        int pos = obtenerIndice(usuario);

        if (pos == -1) {
            System.out.println("Error: el usuario no existe.");
        } else {

            // SE ELIMINA DEL ARREGLO Y SE CORRE TODOS LOS USUARIOS UNA POSICION PARA LA IZQUIERDA PARA TAPAR EL ESPACIO VACIO
            for (int i = pos; i < cantidad - 1; i++) {
                vertices[i] = vertices[i + 1];
            }

            // ELIMINA LA FILA CORRESPONDIENTE DEL USUARIO Y MUEVE UNA FILA PARA ARRIBA
            for (int i = pos; i < cantidad - 1; i++) {
                for (int j = 0; j < cantidad; j++) {
                    matriz[i][j] = matriz[i + 1][j];
                }
            }

            // ELIMINA LA COLUMNA CORRESPONDIENTE DEL USUARIO Y MUEVE TODAS LAS COLUMNAS PARA LA IZQUIERDA
            for (int j = pos; j < cantidad - 1; j++) {
                for (int i = 0; i < cantidad; i++) {
                    matriz[i][j] = matriz[i][j + 1];
                }
            }

            cantidad--;
            vertices[cantidad] = null;

            // LIMPIA LA UTLIMA FILA Y COLUMNA INSERTANDO 0
            for (int i = 0; i < MAX; i++) {
                matriz[cantidad][i] = 0;
                matriz[i][cantidad] = 0;
            }
        }
    }

    @Override
    public void insertarArista(Usuario origen, Usuario destino) {
        // BUSCA EN QUE POSICION ESTA CADA USUARIO PARA CREAR LA ARISTA
        int posOrigen = obtenerIndice(origen);
        int posDestino = obtenerIndice(destino);

        if (posOrigen == -1 || posDestino == -1) {
            System.out.println("Error: uno de los usuarios no existe.");
        } else {
            // CREA LA CONEXION ENTRE USARIOS EN LA MATRIZ DE ADYACENCIA
            matriz[posOrigen][posDestino] = 1;
            matriz[posDestino][posOrigen] = 1;
        }
    }

    @Override
    public void eliminarArista(Usuario origen, Usuario destino) {
        // BUSCA EN QUE POSICION ESTA CADA USUARIO
        int posOrigen = obtenerIndice(origen);
        int posDestino = obtenerIndice(destino);

        if (posOrigen == -1 || posDestino == -1) {
            System.out.println("Error: uno de los usuarios no existe.");
        } else {
            // ELIMINA LA CONEXION ENTRE USARIOS EN LA MATRIZ DE ADYACENCIA
            matriz[posOrigen][posDestino] = 0;
            matriz[posDestino][posOrigen] = 0;
        }
    }

    @Override
    public boolean existeVertice(Usuario usuario) {
        return obtenerIndice(usuario) != -1;
    }

    @Override
    public boolean existeArista(Usuario origen, Usuario destino) {
        // OBTIENE LA POSICION DE AMBOS USUARIOS
        int posOrigen = obtenerIndice(origen);
        int posDestino = obtenerIndice(destino);

        if (posOrigen == -1 || posDestino == -1) {
            return false;
        }
        // VERIFICA SI EN LA MATRIZ HAY UN 1 (OSEA SI HAY RLACION ENTRE VERTICES)
        return matriz[posOrigen][posDestino] == 1;
    }


    private int obtenerIndice(Usuario usuario) {
        // RECORRE EL ARREGLO BUSCANDO AL USUARIO POR SU ID
        for (int i = 0; i < cantidad; i++) {
            if (vertices[i].getIdUsuario() == usuario.getIdUsuario()) {
                return i; // SI LO ENCUENTRA DEVUELVE LA POSICION
            }
        }
        return -1;
    }

    @Override
    public void mostrarVertices() {
        System.out.println("Usuarios en la red:");

        for (int i = 0; i < cantidad; i++) {
            System.out.println(vertices[i]);
        }
    }

    @Override
    public int gradoSeparacion(Usuario origen, Usuario destino) {
        // BUSCA LA POSICION DE AMBOS  USUARIO
        int posOrigen = obtenerIndice(origen);
        int posDestino = obtenerIndice(destino);

        if (posOrigen == -1 || posDestino == -1) {
            return -1;
        }


        boolean[] visitados = new boolean[cantidad]; // ARREGLO PARA SABER QUE USUARIOS YA RECORRIO
        int[] distancia = new int[cantidad]; // ARREGLO PARA SABER CUANTAS CONEXIONES HAY DESDE EL ORIGEN HASTA EL USUARIO DESTINO

        // SE INICIALIZAN LOS ARREGLOS SIN VALORES, NINGUNO FUE VISITADO NI TIENE CONEXIONES
        for (int i = 0; i < cantidad; i++) {
            visitados[i] = false;
            distancia[i] = -1;
        }

        // SE USA UNA COLA PARA RECORRER EL GRAFO POR NIVELES
        int[] cola = new int[cantidad];
        int frente = 0;
        int fin = 0;

        // SE AGREGA EL USUARIO ORIGEN A LA COLA
        cola[fin] = posOrigen;
        fin++;

        visitados[posOrigen] = true; // SE MARCA COMO RECORRIDO
        distancia[posOrigen] = 0; // DISTANCIA 0 PORQUE ES EL INICIO


        while (frente < fin) {  //MIENTRAS HAYA UN USUARIO EN LA COLA SE SIGUE RECORRIENDO

            int actual = cola[frente];
            frente++;

            // RECORRE LAS CONEXIONES DEL USUARIO ATUAL
            for (int i = 0; i < cantidad; i++) {

                if (matriz[actual][i] == 1 && !visitados[i]) { // COMPUREBA SI EXISTE UNA CONEXION Y SI NO FUE VISITADO

                    visitados[i] = true; // LO MARCA COMO VISITIADO PAR NO VOLVER A PASAR POR EL
                    distancia[i] = distancia[actual] + 1; // CALCULA LA DISTANCIA

                    cola[fin] = i; // LO AGREGA A LA COLA PARA ANALIZARLO DEPUES
                    fin++;

                    if (i == posDestino) {
                        return distancia[i]; // SI ENCUENTRA EL QUE ESTABA BUSCANDO DEVUELVE LA DISTANCIA
                    }
                }
            }
        }

        return -1;
    }


    @Override
    public void sugerirContactos(Usuario usuario) {

        int posUsuario = obtenerIndice(usuario); // BUSCA LA POSICION DEL USUARIO

        if (posUsuario == -1) {
            System.out.println("Usuario inexistente.");
            return;
        }

        System.out.println("Contactos recomendados para " + usuario.getNombre() + ":");

        for (int i = 0; i < cantidad; i++) {

            if (matriz[posUsuario][i] == 1) { // RECORRE LA FILA DEL USUARIO EN LA MATRIZ, SI DEVUELVE 1 ES QUE ENCONTRO UNA REALACION

                for (int j = 0; j < cantidad; j++) { // RECORRE LOS CONTACTOS

                    if (matriz[i][j] == 1 && // VERIFICA QUE EXISTA LA CONEXION
                            j != posUsuario && // QUE NO SEA EL MISMO USUARIO
                            matriz[posUsuario][j] == 0) { // QUE EL USUARIO ORIGINAL TODAVIA NO ESTE CONECTADO CON ESE USUARIO

                        System.out.println(vertices[j].getNombre());
                    }
                }
            }
        }
    }

    @Override
    public void mostrarMatriz() {
        System.out.println("Matriz de conexiones:");

        for (int i = 0; i < cantidad; i++) {
            for (int j = 0; j < cantidad; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}