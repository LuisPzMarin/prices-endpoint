package com.redegal.pricesapi.model;

import javax.persistence.*;

@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    public Product(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Product() {

    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
