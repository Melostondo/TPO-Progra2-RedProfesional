package RedProfesional;

import RedProfesional.Diccionario.DiccionarioUsuarios;

public class Main {
    /*
     * PRUEBA DEL DICCIONARIO DE BÚSQUEDA DE USUARIOS
     * Se verifica:
     * - Inicialización
     * - Inserción
     * - Recuperación
     * - Modificación
     * - Eliminación
     * - Tamaño
     */


        public static void main(String[] args) {

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

            // Mostrar tamaño
            System.out.println("Cantidad de usuarios: " + diccionario.tamano());

            // Recuperar usuario
            System.out.println("Usuario con ID 1:");
            System.out.println(diccionario.recuperar(1));

            // Modificar usuario
            Perfil perfilNuevo = new Perfil("Desarrollador Senior", "5 años");
            Usuario usuarioNuevo = new Usuario(1, "Juan Actualizado", "juannuevo@gmail.com", perfilNuevo);

            diccionario.modificar(1, usuarioNuevo);

            System.out.println("Usuario modificado:");
            System.out.println(diccionario.recuperar(1));

            // Eliminar usuario
            diccionario.eliminar(2);

            System.out.println("Cantidad luego de eliminar: " + diccionario.tamano());

            // Verificar existencia
            System.out.println("¿Existe ID 2? " + diccionario.pertenece(2));
        }
}
