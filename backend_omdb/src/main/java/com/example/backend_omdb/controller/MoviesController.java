package com.example.backend_omdb.controller;

import com.example.backend_omdb.model.Movie;
import com.example.backend_omdb.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controlador REST para manejar las solicitudes relacionadas con las películas.
 */
@RestController
@RequestMapping("/api/omdb")
public class MoviesController {

    @Autowired
    private MoviesService moviesService;

    /**
     * Endpoint para obtener las películas de Harry Potter.
     * 
     * @return Una lista de objetos Movie con la información de las películas.
     */
    @GetMapping("/harrypotter")
    public List<Movie> getHarryPotterMovies(@RequestParam(required = false) String title,
                                            @RequestParam(required = false) String year,
                                            @RequestParam(required = false) Integer personalRating) {
        return moviesService.getHarryPotterMovies(title, year, personalRating);
    }
}