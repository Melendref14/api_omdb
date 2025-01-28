package com.example.backend_omdb.config;

//Dotenv
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApiConfig {

    private final Dotenv dotenv = Dotenv.load();
    
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public String getApiUrl() {
        return dotenv.get("OMDB_API_URL");
    }

    public String getApiKey() {
        return dotenv.get("OMDB_API_KEY");
    }
}
