package com.redegal.pricesapi.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @Column(nullable = false,columnDefinition = "TIMESTAMP")
    private LocalDateTime startDate;

    @Column(nullable = false,columnDefinition = "TIMESTAMP")
    private LocalDateTime endDate;

    @Column(nullable = false)
    private int priceList;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;


    private int priority;

    @Column(nullable = false)
    private Double price;
    @Enumerated(EnumType.STRING)
    private Currency curr;


    public Price(Long id, Brand brand, LocalDateTime startDate, LocalDateTime endDate, int priceList, Product product, int priority, Double price, Currency curr) {
        this.id = id;
        this.brand = brand;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priceList = priceList;
        this.product = product;
        this.priority = priority;
        this.price = price;
        this.curr = curr;
    }

    public Price() {
    }

    public Long getId() {
        return this.id;
    }

    public Brand getBrand() {
        return this.brand;
    }

    public LocalDateTime getStartDate() {
        return this.startDate;
    }

    public LocalDateTime getEndDate() {
        return this.endDate;
    }

    public int getPriceList() {
        return this.priceList;
    }

    public Product getProduct() {
        return this.product;
    }

    public int getPriority() {
        return this.priority;
    }

    public Double getPrice() {
        return this.price;
    }

    public Currency getCurr() {
        return this.curr;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public void setPriceList(int priceList) {
        this.priceList = priceList;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setCurr(Currency curr) {
        this.curr = curr;
    }
}
