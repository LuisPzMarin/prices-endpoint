package com.regegal.pricesapi.controller;
import com.regegal.pricesapi.model.Price;
import com.regegal.pricesapi.service.PriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

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

    @PostMapping("/consult")
    public ResponseEntity consultPrice(@RequestBody Consult json) throws Exception {

        try {
            //Se parsea la fecha con el formato del enunciado
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");
            LocalDateTime timestamp = LocalDateTime.parse(json.getDate(), formatter);
            List <Price> Lprice= priceService.consultPrice(timestamp , json.getProductId(), json.getBrandId());

            //Se revisa si la consulta no trajo resultados
            if(Lprice.isEmpty()){
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }else{
                return new ResponseEntity(Lprice.get(0), HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

    }

    //Se crea el objeto consulta para parsear el body recibido
    public static class Consult {
        private String date;
        private Long productId;
        private Long brandId;

        public Consult(){};

        public String getDate(){
            return date;
        }

        public Long getBrandId() {
            return brandId;
        }

        public Long getProductId() {
            return productId;
        }
    }



}
