package com.example.practica_prueba_archexa.domain.port.out;

import com.example.practica_prueba_archexa.domain.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepositoryPort {

    Product save(Product product);

    List<Product> findAll();

    Optional<Product> findById(Long id);

    Optional<Product> findByName(String name);

    void deleteById(Long id);

    boolean existsByCategoryId(Long id);

}
