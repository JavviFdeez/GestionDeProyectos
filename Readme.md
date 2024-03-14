# Sistema de Gestión de Proyectos en Java

## Descripción

El **Sistema de Gestión de Proyectos** es una aplicación Java que permite a los usuarios organizar y 
gestionar proyectos de software. La aplicación incluye funciones como la creación de proyectos, 
asignación de colaboradores, creación de tareas y seguimiento del estado de las mismas.
El **Sistema de Gestión de Proyectos** es una aplicación Java que permite a los usuarios organizar y gestionar proyectos de software. La aplicación incluye funciones como la creación de proyectos, asignación de colaboradores, creación de tareas y seguimiento del estado de las mismas.

## Funcionalidades

1. **Inicio de Sesión:**
    - Inicio de sesión con usuario y contraseña (hash).
    - Registro de nuevos usuarios con nombre, usuario, contraseña y correo (validado con expresiones regulares).

2. **Gestión de Proyectos:**
    - Creación de proyectos con nombre y descripción.
    - Asignación de colaboradores a los proyectos.
    - Listado de proyectos creados y proyectos en los que el usuario es colaborador.

3. **Gestión de Tareas:**
    - Creación de tareas para un proyecto con nombre, descripción, fecha de inicio, fecha límite, colaborador encargado y estado.
    - Estados de tarea: SIN INICIAR, EN TRÁMITE, FINALIZADA.
    - Visualización y cambio de estado de tareas para colaboradores.
    - CRUD completo de tareas para el creador del proyecto.

4. **Sesión de Usuario y Persistencia:**
    - Mantenimiento de la sesión de usuario durante la ejecución.
    - Persistencia de la información del sistema al cerrar la aplicación.

## Tecnologías Utilizadas

- Java
- Intellij IDEA
- Git/GitHub (repositorio colaborativo)
- Trello (gestión de tareas y sprints)