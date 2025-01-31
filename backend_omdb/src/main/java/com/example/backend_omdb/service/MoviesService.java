package com.example.backend_omdb.service;

import com.example.backend_omdb.config.ApiConfig;
import com.example.backend_omdb.exception.ApiRequestException;
import com.example.backend_omdb.model.Movie;
import com.example.backend_omdb.repository.MovieRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MoviesService {

    // Constante para la búsqueda de películas de Harry Potter
    private static final String HARRY_POTTER_SEARCH_QUERY = "Harry+Potter";

    private final RestTemplate restTemplate;
    private final ApiConfig apiConfig;
    private final MovieRepository movieRepository;

    // Inyección de dependencias a través del constructor
    public MoviesService(RestTemplate restTemplate, ApiConfig apiConfig, MovieRepository movieRepository) {
        this.restTemplate = restTemplate;
        this.apiConfig = apiConfig;
        this.movieRepository = movieRepository;
    }

    /**
     * Obtiene una lista de películas de Harry Potter, aplicando filtros opcionales.
     *
     * @param title          Título de la película para filtrar (opcional).
     * @param year           Año de la película para filtrar (opcional).
     * @param personalRating Valoración personal para filtrar (opcional).
     * @return Lista de películas filtradas.
     * @throws ApiRequestException Si ocurre un error al obtener las películas.
     */
    public List<Movie> getHarryPotterMovies(String title, String year, Integer personalRating) {
        try {
            // Obtener la respuesta de la API
            String apiResponse = fetchHarryPotterMoviesFromApi();

            // Parsear la respuesta y crear/actualizar las películas
            List<Movie> movies = parseMoviesFromApiResponse(apiResponse);

            // Aplicar filtros y devolver la lista resultante
            return filterMovies(movies, title, year, personalRating);
        } catch (Exception e) {
            throw new ApiRequestException("Error al obtener las películas de Harry Potter", e);
        }
    }

    /**
     * Realiza una solicitud a la API para obtener películas de Harry Potter.
     *
     * @return Respuesta de la API en formato JSON.
     * @throws ApiRequestException Si la respuesta de la API es nula.
     */
    private String fetchHarryPotterMoviesFromApi() {
        String apiUrl = apiConfig.getApiUrl();
        String apiKey = apiConfig.getApiKey();
        String url = String.format("%s?apikey=%s&s=%s", apiUrl, apiKey, HARRY_POTTER_SEARCH_QUERY);
        String response = restTemplate.getForObject(url, String.class);

        if (response == null) {
            throw new ApiRequestException("No se encontraron películas de Harry Potter...");
        }

        return response;
    }

    /**
     * Parsea la respuesta de la API y crea o actualiza las películas en la base de datos.
     *
     * @param apiResponse Respuesta de la API en formato JSON.
     * @return Lista de películas parseadas.
     */
    private List<Movie> parseMoviesFromApiResponse(String apiResponse) {
        JSONObject jsonResponse = new JSONObject(apiResponse);
        JSONArray moviesArray = jsonResponse.getJSONArray("Search");

        List<Movie> movies = new ArrayList<>();
        for (int i = 0; i < moviesArray.length(); i++) {
            JSONObject movieJson = moviesArray.getJSONObject(i);
            Movie movie = createOrUpdateMovieFromJson(movieJson);
            movies.add(movie);

            // Guardar la película en la base de datos
            movieRepository.save(movie);
        }

        return movies;
    }

    /**
     * Crea o actualiza una película a partir de un objeto JSON.
     *
     * @param movieJson Objeto JSON que representa una película.
     * @return Película creada o actualizada.
     */
    private Movie createOrUpdateMovieFromJson(JSONObject movieJson) {
        String imdbID = movieJson.getString("imdbID");

        // Buscar la película en la base de datos o crear una nueva si no existe
        Movie movie = movieRepository.findById(imdbID).orElse(new Movie());

        // Actualizar los datos de la película
        movie.setImdbID(imdbID);
        movie.setTitle(movieJson.getString("Title"));
        movie.setYear(movieJson.getString("Year"));
        movie.setPoster(movieJson.getString("Poster"));

        // Asignar una valoración personal aleatoria si no tiene una
        if (movie.getPersonalRating() == 0) {
            movie.setPersonalRating(generateRandomPersonalRating());
        }

        return movie;
    }

    /**
     * Genera una valoración personal aleatoria entre 1 y 5.
     *
     * @return Valoración personal aleatoria.
     */
    private int generateRandomPersonalRating() {
        return (int) (Math.random() * 5) + 1;
    }

    /**
     * Filtra la lista de películas según los criterios proporcionados.
     *
     * @param movies         Lista de películas a filtrar.
     * @param title          Título para filtrar (opcional).
     * @param year           Año para filtrar (opcional).
     * @param personalRating Valoración personal para filtrar (opcional).
     * @return Lista de películas filtradas.
     */
    private List<Movie> filterMovies(List<Movie> movies, String title, String year, Integer personalRating) {
        return movies.stream()
                .filter(movie -> title == null || movie.getTitle().contains(title))
                .filter(movie -> year == null || movie.getYear().equals(year))
                .filter(movie -> personalRating == null || movie.getPersonalRating() == personalRating)
                .collect(Collectors.toList());
    }
}