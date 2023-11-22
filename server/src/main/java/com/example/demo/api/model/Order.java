package com.example.demo.api.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@EntityScan
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(name = "client", nullable = true)
    private Integer client;
    @Column(name = "prix", nullable = true)
    private double prix;
    @Column(name = "date", nullable = true)
    private String date;

    public Integer getId() {
        return this.Id;
    }

    public void setId(Integer id) {
        this.Id = id;
    }

    public Integer getClient() {
        return this.client;
    }

    public void setClient(Integer client) {
        this.client = client;
    }

    public double getPrix() {
        return this.prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
