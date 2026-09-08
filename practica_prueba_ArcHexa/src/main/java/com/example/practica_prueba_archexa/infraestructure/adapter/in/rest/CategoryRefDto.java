package com.example.practica_prueba_archexa.infraestructure.adapter.in.rest;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class CategoryRefDto {
    @NotNull
    private Long id;
}
