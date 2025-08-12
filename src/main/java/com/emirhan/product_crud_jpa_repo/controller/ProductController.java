package com.emirhan.product_crud_jpa_repo.controller;

import com.emirhan.product_crud_jpa_repo.entity.Product;
import com.emirhan.product_crud_jpa_repo.exception.ProductErrorResponse;
import com.emirhan.product_crud_jpa_repo.exception.ProductNotFoundException;
import com.emirhan.product_crud_jpa_repo.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping
    public List<Product> findAll() {
        return productService.findAll();
    }

    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product) {

        product.setId(0);
        return productService.save(product);
    }
    @GetMapping("/{productId}")
    public Product getProductById(@PathVariable int productId) {
        return productService.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product with ID " + productId + " not found"));
    }
    @PutMapping("/update")
    public String updateProduct(@RequestBody Product product) {
        if (product.getId() == 0) {
            return "Please provide an ID for the product to update.";
        }

        Optional<Product> productToUpdate = productService.findById(product.getId());
        if (productToUpdate.isPresent()) {
            productService.save(product);
            return "Product with ID " + product.getId() + " has been updated.";
        }
        return "Product with ID " + product.getId() + " not found.";
    }
    @DeleteMapping("/delete/{productId}")
    public String deleteProduct(@PathVariable int productId) {
        Optional<Product> productToDelete = productService.findById(productId);
        if (productToDelete.isPresent()) {
            productService.deleteById(productId);
            return "Product with ID " + productId + " has been deleted.";
        }
        return "Product with ID " + productId + " not found.";
    }


}
