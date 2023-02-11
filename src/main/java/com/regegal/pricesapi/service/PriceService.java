package com.regegal.pricesapi.service;

import com.regegal.pricesapi.model.Price;


public interface PriceService {

    Price setPrice(Price price);
    Price getPrice(Long id);
    Price modifyPrice(Long id, Price newPrice);

    boolean deletePrice(Long id);
}
