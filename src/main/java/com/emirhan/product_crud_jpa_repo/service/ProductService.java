package com.emirhan.product_crud_jpa_repo.service;

import com.emirhan.product_crud_jpa_repo.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product save(Product product);
    Optional<Product> findById(Integer id);
    List<Product> findAll();
    void deleteById(Integer id);

}
