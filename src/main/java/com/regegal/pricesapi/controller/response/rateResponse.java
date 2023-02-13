package com.regegal.pricesapi.controller.response;

import java.time.LocalDateTime;

public class rateResponse {

    private Double price;
    private Long brandId;
    private Long productId;
    private LocalDateTime requestDateRate;
    private LocalDateTime endDateRate;
    private int priceList;


    public rateResponse(Double price, Long brandId, Long productId, LocalDateTime requestDateRate, LocalDateTime endDateRate, int priceList) {
        this.price = price;
        this.brandId = brandId;
        this.productId = productId;
        this.requestDateRate = requestDateRate;
        this.endDateRate = endDateRate;
        this.priceList = priceList;
    }
}
