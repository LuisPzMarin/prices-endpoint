package com.regegal.pricesapi.controller.request;

public class rateRequest {
    private String date;
    private Long productId;
    private Long brandId;

    public rateRequest(String date, Long productId, Long brandId) {
        this.date = date;
        this.productId = productId;
        this.brandId = brandId;
    }

    public String getDate() {
        return this.date;
    }

    public Long getProductId() {
        return this.productId;
    }

    public Long getBrandId() {
        return this.brandId;
    }
}

