package com.redegal.pricesapi.model;

import javax.persistence.*;

@Entity
@Table
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;


    public Brand(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Brand() {

    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
