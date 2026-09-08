package com.example.practica_prueba_archexa.domain.exception;

public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException() {
        super("La categoria no existe");
    }
}
