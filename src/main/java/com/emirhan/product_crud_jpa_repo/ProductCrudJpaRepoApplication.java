package com.emirhan.product_crud_jpa_repo;

import com.emirhan.product_crud_jpa_repo.dao.ProductRepository;
import com.emirhan.product_crud_jpa_repo.entity.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class ProductCrudJpaRepoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductCrudJpaRepoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ProductRepository productRepository) {
        return runner -> {
            // createProduct(productRepository);
            // findProduct(productRepository);
            // queryForProducts(productRepository);
            // updateProduct(productRepository);
            // deleteProduct(productRepository);
             queryForProducts(productRepository);
        };
    }

    private void createProduct(ProductRepository productRepository) {
        System.out.println("Creating product");
        Product product = new Product("Iphone 15 Pro Max", 57800, 5000);
        productRepository.save(product);
        System.out.println("Created product at id: " + product.getId());
    }

    private void findProduct(ProductRepository productRepository) {
        System.out.println("Finding product");
        int id = 1;
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isPresent()) {
            System.out.println("Found product: " + optionalProduct.get());
        } else {
            System.out.println("Product not found");
        }
    }

    private void queryForProducts(ProductRepository productRepository) {
        System.out.println("Querying for products");
        List<Product> products = productRepository.findAll();
        for (Product product : products) {
            System.out.println(product);
        }
    }

    private void updateProduct(ProductRepository productRepository) {
        System.out.println("Updating product");
        Optional<Product> optionalProduct = productRepository.findById(2);

        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setPrice(25700);
            productRepository.save(product);
            System.out.println("Updated product: " + product);
        }
    }

    private void deleteProduct(ProductRepository productRepository) {
        System.out.println("Deleting product");
        Optional<Product> optionalProduct = productRepository.findById(2);

        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            productRepository.delete(product);
        }
    }
}