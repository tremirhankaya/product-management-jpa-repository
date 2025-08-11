package com.emirhan.product_crud_jpa_repo.service;

import com.emirhan.product_crud_jpa_repo.dao.ProductRepository;
import com.emirhan.product_crud_jpa_repo.entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository  productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @Transactional
    public Product save(Product product) {
        System.out.println(">> Saving product: " + product.getName());
        if(product.getPrice()<=0){
            throw new IllegalArgumentException("Price must be greater than 0");
        }
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> findById(Integer id) {
        System.out.println(">> Finding product with ID: " + id);
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()){
            return product;
        }else {
            throw new IllegalArgumentException("Product with ID: " + id + " not found");
        }
    }

    @Override
    public List<Product> findAll() {
        System.out.println(">> Retrieving all products...");

        return productRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        System.out.println(">> Deleting product with ID: " + id);
        productRepository.deleteById(id);
        System.out.println(">> Product with ID " + id + " has been deleted.");

    }
}
