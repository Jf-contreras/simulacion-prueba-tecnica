package com.example.practica_prueba_archexa.domain.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException() {
        super("Producto inexistente");
    }
}
