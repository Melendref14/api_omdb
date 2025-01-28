package com.example.backend_omdb.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Controlador de excepciones global para manejar las excepciones de la API.
 */
@RestControllerAdvice
public class ApiExceptionHandler {
    
    /**
     * Maneja las excepciones de tipo ApiRequestException.
     *
     * @param e La excepción ApiRequestException.
     * @return Una respuesta con el mensaje de error y el estado HTTP.
     */
    @ExceptionHandler(value = { ApiRequestException.class })
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException e) {
        // Definir el estado HTTP como BAD_REQUEST (400)
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        
        // Crear una instancia de ApiException con el mensaje de error y el estado HTTP
        ApiException apiException = new ApiException(
            e.getMessage(),
            badRequest
        );
        
        // Retornar una ResponseEntity con la ApiException y el estado HTTP
        return new ResponseEntity<>(apiException, badRequest);
    }
}
