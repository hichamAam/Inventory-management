package com.example.demo.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column (name = "name")
    private String name;
    @Column(name = "category")
    private String category ;
    @Column(name = "price")
    private double price ;
    @Column(name = "stock_qte")
    private Integer stock_qte ;

    public Product(Long id, String name, String category, double price, Integer stock_qte) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock_qte = stock_qte;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getStock_qte() {
        return stock_qte;
    }

    public void setStock_qte(Integer stock_qte) {
        this.stock_qte = stock_qte;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", stock_qte=" + stock_qte +
                '}';
    }
}

