package com.example.practica_prueba_archexa.infraestructure.adapter.in.rest;

import com.example.practica_prueba_archexa.domain.model.Category;
import com.example.practica_prueba_archexa.domain.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductResponse mapToProductResponse(Product productCreated){

        Category categoryProduct = productCreated.getCategory();

        CategoryResponse categoryResponse = new CategoryResponse(
                categoryProduct.getId(),
                categoryProduct.getName(),
                categoryProduct.getDescription()
        );

        return new ProductResponse(
                productCreated.getId(),
                productCreated.getName(),
                productCreated.getDescription(),
                productCreated.getPrice(),
                productCreated.getStock(),
                categoryResponse
        );
    }

    public Product mapToProduct(ProductDto productDto){
        Product product = new Product();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.getStock());

        Category category = new Category();
        category.setId(productDto.getCategory().getId());

        product.setCategory(category);

        return product;
    }
}
