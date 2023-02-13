package com.redegal.pricesapi.service;

import com.redegal.pricesapi.repository.PriceRepository;
import com.redegal.pricesapi.model.Price;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class PriceServiceImp implements PriceService{

    private final PriceRepository priceRepository;

    @Override
    public Price setPrice(Price price) {
        return priceRepository.save(price);
    }

    @Override
    public Price getPrice(Long id) {
        return priceRepository.findById(id).orElseThrow(() -> {throw new RuntimeException();});
    }

    @Override
    public Price modifyPrice(Long id, Price newPrice) {
        return priceRepository.save(newPrice);
    }

    @Override
    public boolean deletePrice(Long id) {
        try {
            priceRepository.deleteById(id);
        } catch (Exception e){
        return false;
        }
        return true;
    }

    @Override
    public List<Price> findRate(LocalDateTime date, Long productId, Long brandId){
        return priceRepository.findByBrandAndProductAndDates(date, productId, brandId);
    }
}
