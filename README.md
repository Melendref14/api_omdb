# Proyecto OMDB

Este es un proyecto que consta de un backend desarrollado con Spring Boot y un frontend desarrollado con Next.js.

## Requisitos

- Node.js (versión 14 o superior)
- npm o yarn
- Java (versión 17 o superior)
- Maven
- MySQL

## Configuración

### Backend

1. Clona el repositorio:

    ```bash
    git clone https://github.com/tu-usuario/tu-repositorio.git
    cd tu-repositorio/backend_omdb
    ```

2. Configura la base de datos MySQL:

    Crea una base de datos llamada `apiomdb` y actualiza las credenciales en el archivo [src/main/resources/application.properties](http://_vscodecontentref_/0):

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/apiomdb
    spring.datasource.username=root
    spring.datasource.password=tu-contraseña
    ```

3. Configura las variables de entorno:

    Crea un archivo [.env](http://_vscodecontentref_/1) en el directorio [backend_omdb](http://_vscodecontentref_/2) con el siguiente contenido:

    ```env
    OMDB_API_URL=https://www.omdbapi.com
    OMDB_API_KEY=tu-api-key
    ```

4. Compila y ejecuta el proyecto:

    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

    El backend estará disponible en `http://localhost:8080`.

### Frontend

1. Navega al directorio del frontend:

    ```bash
    cd ../frontend_omdb
    ```

2. Instala las dependencias:

    ```bash
    npm install
    ```

3. Configura las variables de entorno:

    Crea un archivo [.env](http://_vscodecontentref_/3) en el directorio [frontend_omdb](http://_vscodecontentref_/4) con el siguiente contenido:

    ```env
    NEXT_PUBLIC_API_URL=http://localhost:8080/api
    ```

4. Inicia el servidor de desarrollo:

    ```bash
    npm run dev
    ```

    El frontend estará disponible en `http://localhost:3000`.

## Ejecución simultánea

Para tener el backend y el frontend corriendo simultáneamente, abre dos terminales:

1. En la primera terminal, navega al directorio del backend y ejecuta el backend:

    ```bash
    cd backend_omdb
    mvn spring-boot:run
    ```

2. En la segunda terminal, navega al directorio del frontend y ejecuta el frontend:

    ```bash
    cd frontend_omdb
    npm run dev
    ```

De esta manera, tendrás el backend corriendo en `http://localhost:8080` y el frontend en `http://localhost:3000`.