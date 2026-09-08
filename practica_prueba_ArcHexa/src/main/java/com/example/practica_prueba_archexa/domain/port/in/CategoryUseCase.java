package com.example.practica_prueba_archexa.domain.port.in;

import com.example.practica_prueba_archexa.domain.model.Category;
import java.util.List;

public interface CategoryUseCase {
    Category createCategory(Category category);

    List<Category> listCategories();

    Category findCategory(Long id);

    void deleteCategory(Long id);
}
