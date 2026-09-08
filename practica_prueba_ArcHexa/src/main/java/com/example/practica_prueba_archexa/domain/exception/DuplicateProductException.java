package com.example.practica_prueba_archexa.domain.exception;

public class DuplicateProductException extends RuntimeException {
    public DuplicateProductException() {
        super("Ya existe un producto con el mismo nombre");
    }
}
