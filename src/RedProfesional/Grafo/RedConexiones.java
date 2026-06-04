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