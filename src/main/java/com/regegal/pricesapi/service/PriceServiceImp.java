package com.regegal.pricesapi.service;

import com.regegal.pricesapi.model.Price;
import com.regegal.pricesapi.repository.PriceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        Price originalPrice = priceRepository.findById(id).get();
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
}
