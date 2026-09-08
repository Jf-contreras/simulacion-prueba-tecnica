package com.example.practica_prueba_archexa.infraestructure.adapter.in.rest.controller;

import com.example.practica_prueba_archexa.domain.model.Product;
import com.example.practica_prueba_archexa.domain.port.in.CategoryUseCase;
import com.example.practica_prueba_archexa.domain.port.in.ProductUseCase;
import com.example.practica_prueba_archexa.infraestructure.adapter.in.rest.ProductDto;
import com.example.practica_prueba_archexa.infraestructure.adapter.in.rest.ProductMapper;
import com.example.practica_prueba_archexa.infraestructure.adapter.in.rest.ProductResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    private final ProductUseCase productUseCase;
    private final CategoryUseCase categoryUseCase;

    private final ProductMapper productMapper;

    public ProductController(ProductUseCase productUseCase, CategoryUseCase categoryUseCase, ProductMapper productMapper) {
        this.productUseCase = productUseCase;
        this.categoryUseCase = categoryUseCase;
        this.productMapper = productMapper;
    }

    @PostMapping("/products")
    public ResponseEntity<ProductResponse> createProduct(@RequestBody @Valid ProductDto productDto) {
        Product product = productMapper.mapToProduct(productDto);
        ProductResponse productResponse = productMapper.mapToProductResponse(productUseCase.createProduct(product));
        return ResponseEntity.status(HttpStatus.CREATED).body(productResponse);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductResponse> findProductById(@PathVariable Long id){
        Product product = productUseCase.findProductById(id);
        ProductResponse productResponse = productMapper.mapToProductResponse(product);
        return ResponseEntity.ok().body(productResponse);
    }

    @GetMapping("/productos")
    public ResponseEntity<List<ProductResponse>> findAllProducts(){
        List<ProductResponse> productResponseList = productUseCase.listProducts().stream()
                .map(productMapper::mapToProductResponse).toList();

       return ResponseEntity.ok(productResponseList);
    }

}
