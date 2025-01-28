package com.example.backend_omdb.exception;

/**
 * Clase que representa una excepción personalizada para las solicitudes de la API.
 */
public class ApiRequestException extends RuntimeException {

    /**
     * Constructor para crear una nueva instancia de ApiRequestException con un mensaje de error.
     *
     * @param message El mensaje de error.
     */
    public ApiRequestException(String message) {
        super(message);
    }

    /**
     * Constructor para crear una nueva instancia de ApiRequestException con un mensaje de error y una causa.
     *
     * @param message El mensaje de error.
     * @param cause La causa de la excepción.
     */
    public ApiRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
