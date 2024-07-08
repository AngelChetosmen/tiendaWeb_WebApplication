# Tienda Web

>[!NOTE]
> El proyecto **Tienda Web** ha sido desarrollado por las siguientes personas: 
>- J.L, Herrera Saavedra
>- J.M, Martínez Acosta
>- C.A, Parra García
>- J.A, Vega Reyes (autor de este repositorio)

Este proyecto fue desarrollado para la Unidad de Aprendizaje **"Tecnologías para el Desarrollo Web"**, grupo **4CM1** en la **Escuela Superior de Cómputo** del **Instituto Politécnico Nacional** en la Unidad **Zacatenco, Ciudad de México**.

>[!IMPORTANT]
El proyecto **Tienda Web** se ha implementado, probado y ejecutado con Apache Tomcat (**versión 10.0.27**) junto con el IDE NetBeans (**versión IDE 15**), por lo que es importante que se consideren estas herramientas para su perfecta visualización, si quieres visualizar directamente como se ve el proyecto funcionando, aquí te dejo un link que te podrá ayudar ver lo que se ha podido hacer con este proyecto: 
```url
     https://github.com/AngelChetosmen/tiendaWeb_WebApplication.git
```
>[!CAUTION]
Es posible que la url del proyecto en ocasiones no llegue a funcionar, ya sea por el proveedor o por el vencimiento de la liga. Si por alguna razón no llega a ser visible el proyecto, contáctame para poder resolverlo lo más pronto que me sea posible. 

## Descripción
El proyecto **Tienda Web** es una aplicación web desarrollada en Java utilizando NetBeans IDE. Esta aplicación permite gestionar productos en una tienda en línea, incluyendo funcionalidades para insertar, actualizar, eliminar y listar productos. El proyecto está diseñado para ejecutarse en un servidor Apache Tomcat y utiliza una base de datos MySQL para el almacenamiento de datos.

## Estructura del Proyecto
El proyecto está organizado en los siguientes módulos y directorios:

1. **Configuración del Proyecto**:
    - `pom.xml`: Archivo de configuración de Maven que gestiona las dependencias del proyecto.
    - `nb-configuration.xml`: Archivo de configuración de NetBeans.

2. **Código Fuente**:
    - `src/main/java/com/mycompany/tiendaweb/`: Contiene las clases Java que implementan la lógica de negocio y la interacción con la base de datos.
        - `ActualizarProducto.java`
        - `EliminarProducto.java`
        - `InsertarProducto.java`
        - `ListaProductos.java`
        - `MostrarProducto.java`
        - `Producto.java`
        - `ProductoDAO.java`
        - `TestDBConnection.java`

3. **Recursos Web**:
    - `src/main/webapp/`: Contiene los recursos web incluyendo páginas HTML, archivos CSS y JavaScript.
        - `META-INF/context.xml`: Archivo de configuración del contexto de la aplicación.
        - `actualizar.html`: Página HTML para actualizar productos.
        - `index.html`: Página principal de la tienda.
        - `insertar.html`: Página HTML para insertar nuevos productos.
        - `css/style.css`: Archivo CSS para el estilo de la aplicación.
        - `img/`: Directorio que contiene imágenes usadas en la aplicación.
        - `js/`: Directorio que contiene scripts JavaScript utilizados en la aplicación.

4. **Directorios de Compilación y Despliegue**:
    - `target/`: Contiene los archivos compilados y empaquetados de la aplicación.
        - `tiendaWeb-1.0-SNAPSHOT.war`: Archivo WAR generado para el despliegue en el servidor.
        - `classes/`: Contiene las clases Java compiladas.
        - `maven-archiver/`, `maven-status/`, `test-classes/`: Directorios usados por Maven durante el proceso de compilación y pruebas.

## Funcionalidades Principales
1. **Gestión de Productos**:
    - **Insertar Producto**: Permite agregar nuevos productos a la base de datos.
    - **Actualizar Producto**: Permite modificar la información de productos existentes.
    - **Eliminar Producto**: Permite eliminar productos de la base de datos.
    - **Listar Productos**: Permite ver una lista de todos los productos disponibles en la tienda.
    - **Mostrar Producto**: Permite ver los detalles de un producto específico.

2. **Interfaz de Usuario**:
    - Páginas HTML para interactuar con la aplicación.
    - Estilos CSS personalizados para una mejor presentación visual.
    - Scripts JavaScript para mejorar la interactividad y la experiencia del usuario.

## Requisitos
- **JDK 8 o superior**: Para compilar y ejecutar la aplicación Java.
- **Apache Maven**: Para gestionar las dependencias y la compilación del proyecto.
- **Apache Tomcat**: Para desplegar y ejecutar la aplicación web.
- **MySQL**: Para la gestión de la base de datos.
- **NetBeans**: (Opcional) IDE recomendado para el desarrollo y la gestión del proyecto.

## Instalación y Ejecución
1. **Clonar el Repositorio**:
    ```bash
    git clone https://github.com/AngelChetosmen/tiendaWeb_WebApplication.git
    ```

2. **Compilar el Proyecto**:
    ```bash
    cd tiendaWeb
    mvn clean install
    ```

3. **Desplegar en Tomcat**:
    - Copia el archivo WAR generado (`target/tiendaWeb-1.0-SNAPSHOT.war`) al directorio `webapps` de Tomcat.
    - Inicia el servidor Tomcat.

4. **Configurar la Base de Datos**:
    - Crea una base de datos en MySQL.
    - Actualiza las credenciales de la base de datos en el archivo `META-INF/context.xml`.

5. **Acceder a la Aplicación**:
    - Abre un navegador web y navega a `http://localhost:8080/tiendaWeb-1.0-SNAPSHOT`.

## Contribuciones
Las contribuciones son bienvenidas. Para grandes cambios, por favor abre un issue primero para discutir lo que te gustaría cambiar.

## Licencia
Este proyecto está licenciado bajo los términos de la licencia MIT. Consulta el archivo `LICENSE` para más detalles.

Cabe aclarar que este proyecto fue desarrollado por los autores mencionados al principio. El objetivo de este repositorio es contar con un espacio para la consulta pública de este proyecto, por lo que aquella modificación o contribución al proyecto **personalmente** yo, J.A Vega Reyes; no cuento con ningún problema con el análisis, visualización eh incluso mejoras en el proyecto. Dicho esto, no existe la garantía que los otros autores como el **Instituto Politécnico Nacional** y la **Escuela Superior de Cómputo** puedan dar su consentimiento respecto a una mejora o modificación al proyecto. Dicho lo anterior, se recomienda citar el origen del proyecto para evitar posibles plagios o simplemente problemas en algún futuro, muchas gracias por leer este README y que disfrutes de analizar este proyecto.

Saludos. :D
