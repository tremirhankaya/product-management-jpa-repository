package com.emirhan.product_crud_jpa_repo.controller;

import com.emirhan.product_crud_jpa_repo.entity.Product;
import com.emirhan.product_crud_jpa_repo.exception.ProductNotFoundException;
import com.emirhan.product_crud_jpa_repo.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/{productId}")
    public Product getProductById(@PathVariable int productId) {
        return productService.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product with ID " + productId + " not found"));
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        product.setId(0);
        Product savedProduct = productService.save(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @PutMapping("/{productId}")
    public Product updateProduct(@PathVariable int productId, @RequestBody Product product) {
        if (product.getId() == 0) {
            product.setId(productId);
        } else if (product.getId() != productId) {
            throw new IllegalArgumentException("IDs do not match. Please ensure URL ID and body ID are the same.");
        }

        return productService.findById(productId)
                .map(existingProduct -> {
                    existingProduct.setName(product.getName());
                    existingProduct.setPrice(product.getPrice());
                    existingProduct.setStock(product.getStock());
                    return productService.save(existingProduct);
                })
                .orElseThrow(() -> new ProductNotFoundException("Product with ID " + productId + " not found"));
    }

    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable int productId) {
        productService.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product with ID " + productId + " not found"));

        productService.deleteById(productId);
        return "Product with ID " + productId + " has been deleted.";
    }
}