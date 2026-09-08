package com.example.practica_prueba_archexa.infraestructure.adapter.in.rest;

import jakarta.validation.constraints.NotBlank;

public class CategoryDto {

    @NotBlank
    private String name;
    @NotBlank
    private String description;
}
