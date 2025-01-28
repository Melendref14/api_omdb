package com.example.backend_omdb.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Clase de configuración para la API.
 */
@Configuration
public class ApiConfig {

    // Cargar las variables de entorno usando Dotenv
    private final Dotenv dotenv = Dotenv.load();

    /**
     * Define un bean de RestTemplate para realizar solicitudes HTTP.
     *
     * @return Una instancia de RestTemplate.
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /**
     * Obtiene la URL de la API desde las variables de entorno.
     *
     * @return La URL de la API.
     */
    public String getApiUrl() {
        return dotenv.get("OMDB_API_URL");
    }

    /**
     * Obtiene la clave de la API desde las variables de entorno.
     *
     * @return La clave de la API.
     */
    public String getApiKey() {
        return dotenv.get("OMDB_API_KEY");
    }
}
