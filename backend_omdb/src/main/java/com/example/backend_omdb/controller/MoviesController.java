package com.example.backend_omdb.controller;

import com.example.backend_omdb.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
     * @return Una cadena con la respuesta de la API de OMDB.
     */
    @GetMapping("/harrypotter")
    public String getHarryPotterMovies() {
        return moviesService.getHarryPotterMovies();
    }
}