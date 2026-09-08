package com.example.practica_prueba_archexa.domain.port.in;

import com.example.practica_prueba_archexa.domain.model.Product;

import java.util.List;

public interface ProductUseCase {

    Product createProduct(Product product);

    List<Product> listProducts();

    Product findProductById(Long id);

    Product updateProduct(Long id, Product product);

    void deleteProduct(Long id);

    Product updateProductStock(Long id, Integer stock);
}
