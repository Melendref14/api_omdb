package com.example.backend_omdb.service;

import com.example.backend_omdb.exception.ApiRequestException;
import com.example.backend_omdb.model.Movie;
import com.example.backend_omdb.repository.MovieRepository;
import io.github.cdimascio.dotenv.Dotenv;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Servicio para manejar la lógica de negocio relacionada con las películas.
 */
@Service
public class MoviesService {

    private final RestTemplate restTemplate;
    private final Dotenv dotenv;
    private final MovieRepository movieRepository;

    public MoviesService(RestTemplate restTemplate, MovieRepository movieRepository) {
        this.restTemplate = restTemplate;
        this.dotenv = Dotenv.load();
        this.movieRepository = movieRepository;
    }

    public List<Movie> getHarryPotterMovies(String title, String year, Integer personalRating) {
        try {
            String apiUrl = dotenv.get("OMDB_API_URL") + "?apikey=" + dotenv.get("OMDB_API_KEY") + "&s=harry+potter";
            
            // Realizar la solicitud HTTP a la API de OMDB
            String response = restTemplate.getForObject(apiUrl, String.class);

            // Verificar si la respuesta es nula y lanzar una excepción si es necesario
            if (response == null) {
                throw new ApiRequestException("No se encontraron películas de Harry Potter...");
            }

            // Parsear la respuesta JSON
            JSONObject jsonResponse = new JSONObject(response);
            JSONArray moviesArray = jsonResponse.getJSONArray("Search");

            // Crear una lista de objetos Movie con la información relevante
            List<Movie> movies = new ArrayList<>();
            for (int i = 0; i < moviesArray.length(); i++) {
                JSONObject movieJson = moviesArray.getJSONObject(i);
                Movie movie = new Movie();
                movie.setImdbID(movieJson.getString("imdbID"));
                movie.setTitle(movieJson.getString("Title"));
                movie.setYear(movieJson.getString("Year"));
                movie.setPoster(movieJson.getString("Poster"));
                movie.setPersonalRating((int) (Math.random() * 5) + 1); // Valoración personal aleatoria del 1 al 5
                movies.add(movie);

                // Guardar la película en la base de datos
                movieRepository.save(movie);
            }

            // Aplicar filtros
            return movies.stream()
                    .filter(movie -> title == null || movie.getTitle().contains(title))
                    .filter(movie -> year == null || movie.getYear().equals(year))
                    .filter(movie -> personalRating == null || movie.getPersonalRating() == personalRating)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            // Manejar cualquier excepción lanzada durante la solicitud HTTP
            throw new ApiRequestException("Error al obtener las películas de Harry Potter...", e);
        }
    }
}