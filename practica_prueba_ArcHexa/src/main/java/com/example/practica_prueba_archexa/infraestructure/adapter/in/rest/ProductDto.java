package com.example.practica_prueba_archexa.infraestructure.adapter.in.rest;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDto {
    @NotBlank
    private String name;
    private String description;
    @Positive
    @NotNull
    private BigDecimal price;
    @PositiveOrZero
    @NotNull
    private Integer stock;
    @Valid
    @NotNull
    private CategoryRefDto category;
}
