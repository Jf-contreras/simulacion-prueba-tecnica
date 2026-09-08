package com.example.practica_prueba_archexa.aplicacion.service;

import com.example.practica_prueba_archexa.domain.model.Category;
import com.example.practica_prueba_archexa.domain.port.in.CategoryUseCase;
import com.example.practica_prueba_archexa.domain.port.out.CategoryRepositoryPort;
import com.example.practica_prueba_archexa.domain.port.out.ProductRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements  CategoryUseCase {

    private final ProductRepositoryPort productRepositoryPort;
    private final CategoryRepositoryPort categoryRepositoryPort;

    public CategoryService(CategoryRepositoryPort categoryRepositoryPort, ProductRepositoryPort productRepositoryPort){
        this.categoryRepositoryPort = categoryRepositoryPort;
        this.productRepositoryPort = productRepositoryPort;
    }

    @Override
    public Category createCategory(Category category) {
        return categoryRepositoryPort.save(category);
    }

    @Override
    public List<Category> listCategories() {
        return categoryRepositoryPort.findAll();
    }

    @Override
    public Category findCategory(Long id) {
        return categoryRepositoryPort.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria inexistente"));
    }

    @Override
    public void deleteCategory(Long id) {
        findCategory(id);
        boolean hasProducts = productRepositoryPort.existsByCategoryId(id);
        if(hasProducts){
            throw new RuntimeException("La categoria no se puede eliminar porque tiene productos asociados");
        }
        categoryRepositoryPort.deleteById(id);
    }
}
