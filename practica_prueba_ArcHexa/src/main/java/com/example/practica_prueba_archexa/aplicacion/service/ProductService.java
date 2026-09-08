package com.example.practica_prueba_archexa.aplicacion.service;

import com.example.practica_prueba_archexa.domain.exception.CategoryNotFoundException;
import com.example.practica_prueba_archexa.domain.exception.DuplicateProductException;
import com.example.practica_prueba_archexa.domain.exception.ProductNotFoundException;
import com.example.practica_prueba_archexa.domain.model.Product;
import com.example.practica_prueba_archexa.domain.port.in.ProductUseCase;
import com.example.practica_prueba_archexa.domain.port.out.CategoryRepositoryPort;
import com.example.practica_prueba_archexa.domain.port.out.ProductRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements ProductUseCase {

    private final ProductRepositoryPort productRepositoryPort;

    private final CategoryRepositoryPort categoryRepositoryPort;

    public ProductService(ProductRepositoryPort productRepositoryPort, CategoryRepositoryPort categoryRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
        this.categoryRepositoryPort = categoryRepositoryPort;
    }

    @Override
    public Product createProduct(Product product) {
        Optional<Product> productExisting = productRepositoryPort.findByName(product.getName());
        if (productExisting.isPresent()) {
            throw new DuplicateProductException();
        }
        categoryRepositoryPort.findById(product.getCategory().getId())
                .orElseThrow(CategoryNotFoundException::new);
       return productRepositoryPort.save(product);
    }

    @Override
    public List<Product> listProducts() {
        return productRepositoryPort.findAll();
    }

    @Override
    public Product findProductById(Long id) {
        return productRepositoryPort.findById(id)
                .orElseThrow(ProductNotFoundException::new);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Product productExisting = productRepositoryPort.findById(id)
                .orElseThrow(ProductNotFoundException::new);

        Optional<Product> productWithSameName = productRepositoryPort.findByName(product.getName());

        if(productWithSameName.isPresent() && !productWithSameName.get().getId().equals(id)){
            throw new DuplicateProductException();
        }

        categoryRepositoryPort.findById(product.getCategory().getId())
                .orElseThrow(CategoryNotFoundException::new);

        productExisting.setName(product.getName());
        productExisting.setDescription(product.getDescription());
        productExisting.setPrice(product.getPrice());
        productExisting.setStock(product.getStock());
        productExisting.setCategory(product.getCategory());
        return productRepositoryPort.save(productExisting);
    }

    @Override
    public void deleteProduct(Long id) {
        findProductById(id);
        productRepositoryPort.deleteById(id);
    }

    @Override
    public Product updateProductStock(Long id, Integer stock) {
        Product product = findProductById(id);
        product.setStock(stock);
        return productRepositoryPort.save(product);
    }


}
