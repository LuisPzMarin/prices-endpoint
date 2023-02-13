package com.regegal.pricesapi.controller.response;

import java.time.LocalDateTime;

public class RateResponse {

    private Double price;
    private Long brandId;
    private Long productId;
    private LocalDateTime startDateRate;
    private LocalDateTime requestDateRate;
    private LocalDateTime endDateRate;
    private int priceList;


    public RateResponse(Double price, Long brandId, Long productId, LocalDateTime startDateRate, LocalDateTime requestDateRate, LocalDateTime endDateRate, int priceList) {
        this.price = price;
        this.brandId = brandId;
        this.productId = productId;
        this.startDateRate = startDateRate;
        this.requestDateRate = requestDateRate;
        this.endDateRate = endDateRate;
        this.priceList = priceList;
    }

    public RateResponse() {
    }

    public Double getPrice() {
        return this.price;
    }

    public Long getBrandId() {
        return this.brandId;
    }

    public Long getProductId() {
        return this.productId;
    }

    public LocalDateTime getStartDateRate() {
        return this.startDateRate;
    }

    public LocalDateTime getRequestDateRate() {
        return this.requestDateRate;
    }

    public LocalDateTime getEndDateRate() {
        return this.endDateRate;
    }

    public int getPriceList() {
        return this.priceList;
    }
}
