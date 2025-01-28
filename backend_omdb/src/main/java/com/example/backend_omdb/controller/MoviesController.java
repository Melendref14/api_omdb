package com.example.backend_omdb.controller;

import com.example.backend_omdb.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/omdb")
public class MoviesController {

    @Autowired
    private MoviesService omdbService;

    @GetMapping("/harrypotter")
    public String getHarryPotterMovies() {
        return omdbService.getHarryPotterMovies();
    }
}