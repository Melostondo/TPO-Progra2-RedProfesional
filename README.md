# Trabajo Práctico Obligatorio - Red Profesional

Proyecto correspondiente a la asignatura Programación II, enfocado en la implementación de Tipos de Datos Abstractos (TDA) desarrollados desde cero sin utilizar colecciones nativas de Java.

## Integrantes del grupo
* Elostondo Manuel
* Pettis Francisco

## Alternativa elegida
*  Alternativa A:"Ecosistema de red social profesional"

## Estructuras de datos utilizadas
Para resolver la problemática planteada, se implementaron los siguientes TDAs propios:
1. Diccionario (Estático): Implementado con arreglos paralelos para almacenar y gestionar de forma eficiente a los usuarios del sistema mediante su ID único.
2. Grafo (Matriz de Adyacencia): Implementado para representar la red de conexiones profesionales. Los vértices son los usuarios y las aristas representan el contacto entre ellos.
3. Árbol N-ario: Implementado con nodos enlazados y arreglos de hijos para representar la jerarquía de las habilidades profesionales (ej. Tecnología -> Desarrollo -> Java).
4. Cola (Dinámica): Implementada mediante nodos enlazados simples para gestionar la bandeja de postulaciones, respetando el orden de llegada (FIFO).
5. Pila (Dinámica): Implementada con nodos enlazados para llevar un registro del historial de cambios en el perfil del usuario, permitiendo deshacer la última acción (LIFO).

## Funcionalidades implementadas
* Alta, baja, modificación y búsqueda de usuarios en el diccionario.
* Vinculación entre usuarios, cálculo de grado de separación y sugerencia de contactos en común.
* Inserción y búsqueda en una jerarquía de habilidades organizadas por categorías.
* Recepción y procesamiento en orden de postulaciones a puestos de trabajo.
* Registro de cambios en el perfil con capacidad de restaurar el estado anterior.

## Link del repositorio
* https://github.com/Melostondo/TPO-Progra2-RedProfesional

## Actividades realizadas por cada integrante
* Elostondo Manuel:TDAs de Arbol, Diccionario, Grafo, Habilidad, HistorialDeCambios y Main
* Pettis Francisco: TDAs de pila, cola, Perfil, Usuario, Postulacion y Main

## Instrucciones de ejecución
1. Clonar el repositorio.
2. Abrir el proyecto en cualquier IDE compatible con Java (Eclipse, IntelliJ, VSCode).
3. Asegurarse de que no existan errores de compilación en los paquetes RedProfesional.
4. Ejecutar la clase Main.java ubicada en la raíz del proyecto.
5. La consola mostrará la ejecución secuencial de los 5 casos de prueba principales documentados, detallando la funcionalidad evaluada, el resultado esperado y el resultado obtenido.
