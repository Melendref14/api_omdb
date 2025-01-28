package com.example.backend_omdb.service;

import com.example.backend_omdb.exception.ApiRequestException;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Servicio para manejar la lógica de negocio relacionada con las películas.
 */
@Service
public class MoviesService {

    private final RestTemplate restTemplate;
    private final Dotenv dotenv;

    /**
     * Constructor para inyectar las dependencias necesarias.
     *
     * @param restTemplate El RestTemplate para realizar solicitudes HTTP.
     */
    public MoviesService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.dotenv = Dotenv.load();
    }

    /**
     * Obtiene las películas de Harry Potter desde la API de OMDB.
     *
     * @return Una cadena con la respuesta de la API de OMDB.
     * @throws ApiRequestException Si ocurre un error al obtener las películas.
     */
    public String getHarryPotterMovies() {
        try {
            // Construir la URL de la API usando las variables de entorno
            String apiUrl = dotenv.get("OMDB_API_URL") + "?apikey=" + dotenv.get("OMDB_API_KEY") + "&s=harry+potter";
            
            // Realizar la solicitud HTTP a la API de OMDB
            String response = restTemplate.getForObject(apiUrl, String.class);
            
            // Verificar si la respuesta es nula y lanzar una excepción si es necesario
            if (response == null) {
                throw new ApiRequestException("No se encontraron películas de Harry Potter.");
            }
            
            // Retornar la respuesta de la API
            return response;
        } catch (Exception e) {
            // Manejar cualquier excepción lanzada durante la solicitud HTTP
            throw new ApiRequestException("Error al obtener las películas de Harry Potter.", e);
        }
    }
}