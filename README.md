# TPO-RedProfesional

# INTEGRANTES
-Manuel Elostondo
-Francisco Pettis

---

# ALTERNATIVA ELEGIDA
# Alternativa A: Ecosistema de Red Social Profesional
Desarrollo de una plataforma orientada a la gestión de perfiles profesionales, conexiones laborales y 
flujo de información relacionado con oportunidades de empleo.

La solución propuesta contempla:
* Recuperación inmediata de perfiles mediante identificadores únicos.
* Gestión de conexiones entre profesionales.
* Organización jerárquica de habilidades y competencias.
* Administración de postulaciones laborales respetando el orden de llegada.
* Registro de modificaciones para permitir deshacer cambios realizados por los usuarios.

---

# ESTRUCTURA DE DATOS UTILIZADA
Diccionario:
Utilizado para almacenar y recuperar usuarios mediante un identificador único, permitiendo búsquedas eficientes de perfiles.

Grafo:
Utilizado para representar la red de contactos entre profesionales y las conexiones existentes entre ellos.

Árbol:
Utilizado para organizar jerárquicamente las habilidades y especialidades laborales.

Cola:
Utilizada para gestionar las postulaciones laborales respetando el orden de llegada (FIFO).

Pila:
Utilizada para almacenar el historial de cambios realizados en los perfiles y permitir deshacer modificaciones recientes (LIFO).

---

# FUNCIONALIDEADES IMPLEMENTADAS EN LA SEGUNDA ETAPA:
# Identificación inmediata de usuarios
* Alta de usuarios.
* Recuperación de usuarios mediante ID.
* Modificación de perfiles.
* Eliminación de usuarios.
* Verificación de existencia de usuarios.

# Red de contactos
* Inserción de usuarios en la red profesional.
* Creación de conexiones entre usuarios.
* Verificación de conexiones existentes.
* Visualización de la matriz de adyacencia.

# Jerarquía de habilidades
* Creación de categorías y subcategorías de habilidades.
* Búsqueda de habilidades.
* Visualización de la jerarquía completa.
* Conteo de habilidades registradas.

# Gestión de postulaciones
* Registro de postulaciones laborales.
* Procesamiento respetando el orden de llegada.

# Historial de cambios
* Registro de modificaciones realizadas sobre perfiles.
* Recuperación del último cambio realizado.
* Simulación de deshacer cambios mediante estructura tipo pila.

---

# EJECUCION DEL PROYECTO:
El proyecto incluye una clase `Main` que permite demostrar el funcionamiento de todas las estructuras implementadas mediante distintos casos de prueba.

Las pruebas incluyen:
1. Búsqueda de usuarios mediante Diccionario.
2. Gestión de conexiones mediante Grafo.
3. Organización de habilidades mediante Árbol.
4. Procesamiento de postulaciones mediante Cola.
5. Historial de cambios mediante Pila.

---

# REPOSITORIO DE GIT
Repositorio del proyecto:
https://github.com/Melostondo/TPO-Progra2-RedProfesional

---

# ACTIVIDADES REALIADAS POR CADA INTEGRANTE

# Manuel Elostondo
* Diseño general del proyecto.
* Implementación de la estructura Diccionario de Usuarios.
* Implementación de la estructura Grafo de Conexiones.
* Implementación de la estructura Árbol de Habilidades.
* Desarrollo y mantenimiento de la clase Main.
* Configuración y administración del repositorio GitHub.
* Pruebas funcionales de las estructuras implementadas.

# Francisco Pettis
* Implementación de la estructura Cola para gestión de postulaciones.
* Implementación de la estructura Pila para historial de cambios.
* Colaboración en pruebas funcionales.
* Modificaciones y mejoras sobre la clase Main.
* Integración de funcionalidades al repositorio.
