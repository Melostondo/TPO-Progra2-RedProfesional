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
            for (int i = pos; i < cantidad - 1; i++) {
                vertices[i] = vertices[i + 1];
            }

            for (int i = pos; i < cantidad - 1; i++) {
                for (int j = 0; j < cantidad; j++) {
                    matriz[i][j] = matriz[i + 1][j];
                }
            }

            for (int j = pos; j < cantidad - 1; j++) {
                for (int i = 0; i < cantidad; i++) {
                    matriz[i][j] = matriz[i][j + 1];
                }
            }

            cantidad--;
            vertices[cantidad] = null;

            for (int i = 0; i < MAX; i++) {
                matriz[cantidad][i] = 0;
                matriz[i][cantidad] = 0;
            }
        }
    }

    @Override
    public void insertarArista(Usuario origen, Usuario destino) {
        int posOrigen = obtenerIndice(origen);
        int posDestino = obtenerIndice(destino);

        if (posOrigen == -1 || posDestino == -1) {
            System.out.println("Error: uno de los usuarios no existe.");
        } else {
            matriz[posOrigen][posDestino] = 1;
            matriz[posDestino][posOrigen] = 1;
        }
    }

    @Override
    public void eliminarArista(Usuario origen, Usuario destino) {
        int posOrigen = obtenerIndice(origen);
        int posDestino = obtenerIndice(destino);

        if (posOrigen == -1 || posDestino == -1) {
            System.out.println("Error: uno de los usuarios no existe.");
        } else {
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
        int posOrigen = obtenerIndice(origen);
        int posDestino = obtenerIndice(destino);

        if (posOrigen == -1 || posDestino == -1) {
            return false;
        }

        return matriz[posOrigen][posDestino] == 1;
    }

    private int obtenerIndice(Usuario usuario) {
        for (int i = 0; i < cantidad; i++) {
            if (vertices[i].getIdUsuario() == usuario.getIdUsuario()) {
                return i;
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
        int posOrigen = obtenerIndice(origen);
        int posDestino = obtenerIndice(destino);

        if (posOrigen == -1 || posDestino == -1) {
            return -1;
        }

        boolean[] visitados = new boolean[cantidad];
        int[] distancia = new int[cantidad];

        for (int i = 0; i < cantidad; i++) {
            visitados[i] = false;
            distancia[i] = -1;
        }

        int[] cola = new int[cantidad];
        int frente = 0;
        int fin = 0;

        cola[fin] = posOrigen;
        fin++;

        visitados[posOrigen] = true;
        distancia[posOrigen] = 0;

        while (frente < fin) {

            int actual = cola[frente];
            frente++;

            for (int i = 0; i < cantidad; i++) {

                if (matriz[actual][i] == 1 && !visitados[i]) {

                    visitados[i] = true;
                    distancia[i] = distancia[actual] + 1;

                    cola[fin] = i;
                    fin++;

                    if (i == posDestino) {
                        return distancia[i];
                    }
                }
            }
        }

        return -1;
    }


    @Override
    public void sugerirContactos(Usuario usuario) {

        int posUsuario = obtenerIndice(usuario);

        if (posUsuario == -1) {
            System.out.println("Usuario inexistente.");
            return;
        }

        System.out.println("Contactos recomendados para " + usuario.getNombre() + ":");

        for (int i = 0; i < cantidad; i++) {

            if (matriz[posUsuario][i] == 1) {

                for (int j = 0; j < cantidad; j++) {

                    if (matriz[i][j] == 1 &&
                            j != posUsuario &&
                            matriz[posUsuario][j] == 0) {

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