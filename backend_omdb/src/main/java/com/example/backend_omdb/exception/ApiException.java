package com.example.backend_omdb.exception;

import org.springframework.http.HttpStatus;

/**
 * Clase que representa una excepción de la API.
 */
public class ApiException {
    private final String message;
    private final HttpStatus httpStatus;

    /**
     * Constructor para crear una nueva instancia de ApiException.
     *
     * @param message El mensaje de error.
     * @param httpStatus El estado HTTP asociado con el error.
     */
    public ApiException(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    /**
     * Obtiene el mensaje de error.
     *
     * @return El mensaje de error.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Obtiene el estado HTTP asociado con el error.
     *
     * @return El estado HTTP.
     */
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}