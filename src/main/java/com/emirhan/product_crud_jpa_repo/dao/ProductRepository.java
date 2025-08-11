package com.emirhan.product_crud_jpa_repo.dao;

import com.emirhan.product_crud_jpa_repo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {

}
