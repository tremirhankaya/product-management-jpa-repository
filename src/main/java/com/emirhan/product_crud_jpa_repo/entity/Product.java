package com.emirhan.product_crud_jpa_repo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private
    int id;

    @Column(name = "name")
    private
    String name;

    @Column(name = "price")
    private
    float price;

    @Column(name = "stock")
    private
    int stock;

    public Product( String name, float price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public Product() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
