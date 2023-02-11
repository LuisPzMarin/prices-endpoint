package com.regegal.pricesapi.controller;

import com.regegal.pricesapi.model.Price;
import com.regegal.pricesapi.service.PriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prices")
@RequiredArgsConstructor
public class priceController {

    private final PriceService priceService;

    @PostMapping
    public ResponseEntity setPrice(@RequestBody Price price){
        return new ResponseEntity(priceService.setPrice(price), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity getPrice(@PathVariable("id") Long id){
        return new ResponseEntity(priceService.getPrice(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity modifyPrice(@PathVariable("id") Long id, @RequestBody Price price){
        return new ResponseEntity(priceService.modifyPrice(id, price), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePrice(@PathVariable("id") Long id){
        boolean answer = priceService.deletePrice(id);
        if (answer) {
            return new ResponseEntity(HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
