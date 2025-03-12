package com.example.springFirstApp.util;

/**
 * Clase genérica para manejar resultados de operaciones, incluyendo éxito y fracaso.
 *
 * @param <T> Tipo de dato que se espera en el resultado.
 */
public class Result<T> {

    private final T data;
    private final boolean success;
    private final String message;
    private final int statusCode; // Código de estado HTTP

    // Constructor privado para forzar el uso de los métodos estáticos
    public Result(T data, boolean success, String message, int statusCode) {
        this.data = data;
        this.success = success;
        this.message = message;
        this.statusCode = statusCode;
    }

    /**
     * Método para crear un resultado de éxito.
     *
     * @param data Datos que se devolverán.
     * @param message Mensaje descriptivo.
     * @return Un objeto Result con éxito.
     */
    public static <T> Result<T> success(T data, String message) {
        return new Result<>(data, true, message, 200); // 200: OK
    }

    /**
     * Método para crear un resultado de fracaso.
     *
     * @param message Mensaje descriptivo del error.
     * @param statusCode Código de estado HTTP asociado al error.
     * @return Un objeto Result con fracaso.
     */
    public static <T> Result<T> failure(String message, int statusCode) {
        return new Result<>(null, false, message, statusCode);
    }

    /**
     * Método para crear un resultado de fracaso con un código de estado por defecto (400: Bad Request).
     *
     * @param message Mensaje descriptivo del error.
     * @return Un objeto Result con fracaso.
     */
    public static <T> Result<T> failure(String message) {
        return failure(message, 400); // 400: Bad Request por defecto
    }

    // Getters
    public T getData() {
        return data;
    }

    public boolean isSuccess() {
        return success;
    }

    public boolean isFailure() {
        return !success;
    }

    public String getMessage() {
        return message;
    }

    public int getStatusCode() {
        return statusCode;
    }
}