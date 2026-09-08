package com.example.practica_prueba_archexa.domain.port.out;

import com.example.practica_prueba_archexa.domain.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepositoryPort {
    Category save(Category category);

    List<Category> findAll();

    Optional<Category> findById(Long id);

    void deleteById(Long id);
}
