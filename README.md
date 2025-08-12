# EducacionAmbiental
---
### Importante
**Es una simulación sobre lo que seria el backend de una pagina web, ademas cabe aclarar que tiene una base de datos el cual es SQL SERVER por lo que los datos no pueden guardarse al momento de probar el programa o pueden dar error, en la carpeta "SCRIPT" (branch Main) se encuentra la creacion de base de datos y los componentes necesarios para que la base de datos funcione correctamente**

---
**La aplicacion se tiene que clonar o descargar desde el branch Master**
---

### Descripción

**EducacionAmbiental** es una aplicación de escritorio desarrollada en Java con NetBeans que simula una plataforma web educativa enfocada en la conciencia ambiental. El proyecto funciona como un prototipo que recrea una experiencia tipo página web dentro de una app de escritorio, con interfaces visuales y módulos interactivos.

Esta plataforma educativa está diseñada para fomentar hábitos sostenibles y una actitud crítica frente a problemas ecológicos, integrando funcionalidades como administración de usuarios, manejo de módulos educativos, control de gamificaciones, coordinación de comunidades y foros, y administración del sistema.

---

### Funcionalidades principales

- **Módulos Educativos:** Permite gestionar distintos cursos y contenidos con información detallada de títulos, subtítulos y descripciones.
- **Administración de Usuarios:** Control de perfiles de profesores y alumnos dentro del sistema.
- **Control de Gamificaciones:** Seguimiento y motivación del aprendizaje activo a través de recompensas y niveles.
- **Coordinación de Comunidades y Foros:** Facilita la interacción y discusión entre los participantes del sistema.
- **Simulación Web en Escritorio:** Interfaz gráfica que simula la navegación y experiencia de una página web dentro de una aplicación de escritorio.

---

### Tecnologías utilizadas

- **Java:** Lenguaje de programación principal para la lógica y gestión de la aplicación.
- **NetBeans:** Entorno de desarrollo integrado (IDE) utilizado para crear la aplicación.
- **Swing/AWT:** Para la construcción de la interfaz gráfica que emula una plataforma web.

---

### Estructura del proyecto

``` 
EducacionAmbiental/
├── build/               # Archivos generados para compilación o distribución
├── dist/                # Archivos listos para distribución (build final)
├── nbproject/           # Configuraciones del proyecto NetBeans
├── src/                 # Código fuente y recursos del proyecto
├── build.xml            # Archivo de automatización de compilación (Ant)
├── manifest.mf          # Archivo de manifiesto para empaquetado
``` 
---

### Instalación y uso

1. **Clonar el repositorio**

     ```bash
    git clone --single-branch --branch master https://github.com/OverBM/EducacionAmbiental.git
    ``` 
    En caso de que no funcione clonar directamente desde el main puede usar esta otra forma:
    ```bash
    git clone https://github.com/OverBM/EducacionAmbiental.git
    ```
