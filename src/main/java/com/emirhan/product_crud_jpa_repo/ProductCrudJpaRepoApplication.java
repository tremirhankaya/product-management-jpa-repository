package com.emirhan.product_crud_jpa_repo;

import com.emirhan.product_crud_jpa_repo.dao.ProductRepository;
import com.emirhan.product_crud_jpa_repo.entity.Product;
import com.emirhan.product_crud_jpa_repo.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;
import java.util.Optional;
@SpringBootApplication
public class ProductCrudJpaRepoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductCrudJpaRepoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ProductService productService) {
        return runner -> {
            // Create a new product
          //  Product newProduct = new Product("Smart Watch", 12500, 75);
//            productService.save(newProduct);

            // Find a product by ID
//            productService.findById(1);
//
//            // List all products
//            productService.findAll();
//
//            // Update a product
//            Optional<Product> productToUpdate = productService.findById(2);
//            productToUpdate.ifPresent(product -> {
//                product.setPrice(product.getPrice() + 500);
//                productService.save(product);
//            });
//
//            // Delete a product
//            productService.deleteById(3);
//
//            // List all products again
//            productService.findAll();


        };
    }


}