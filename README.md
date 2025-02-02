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
    git clone https://github.com/Melendref14/api_omdb
    cd tu-repositorio/backend_omdb
    ```

2. Configura las variables de entorno:

    Copia el archivo `.env.example` a `.env` y actualiza los valores según tu configuración local:

    ```bash
    cp .env.example .env
    ```

3. Inicia el backend:

    ```bash
    mvn spring-boot:run
    ```

### Frontend

1. Navega al directorio del frontend:

    ```bash
    cd ../frontend_omdb
    ```

2. Instala las dependencias:

    ```bash
    npm install
    ```

3. Inicia el frontend:

    ```bash
    npm run dev
    ```

## Ver la Aplicación

Puedes ver la aplicación en producción en el siguiente dominio: [OMDB App](https://api-omdb-nine.vercel.app/)