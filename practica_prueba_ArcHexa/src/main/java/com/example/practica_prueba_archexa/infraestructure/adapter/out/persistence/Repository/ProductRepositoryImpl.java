package com.example.practica_prueba_archexa.infraestructure.adapter.out.persistence.Repository;

import com.example.practica_prueba_archexa.domain.model.Product;
import com.example.practica_prueba_archexa.domain.port.out.ProductRepositoryPort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public class ProductRepositoryImpl implements ProductRepositoryPort, JpaRepository {
    @Override
    public Product save(Product product) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        return List.of();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Product> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public boolean existsByCategoryId(Long id) {
        return false;
    }
}
