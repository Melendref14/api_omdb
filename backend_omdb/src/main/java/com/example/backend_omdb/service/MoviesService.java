package com.example.backend_omdb.service;

import com.example.backend_omdb.config.ApiConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MoviesService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ApiConfig omdbConfig;

    public String getHarryPotterMovies() {
        String url = String.format("%s/?s=Harry+Potter&apikey=%s", omdbConfig.getApiUrl(), omdbConfig.getApiKey());
        return restTemplate.getForObject(url, String.class);
    }
}