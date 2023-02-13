package com.regegal.pricesapi.controller;
import com.regegal.pricesapi.controller.request.RateRequest;
import com.regegal.pricesapi.controller.response.RateResponse;
import com.regegal.pricesapi.controller.response.ErrorResponse;
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
public class PriceController {

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

    @PostMapping("/rate")
    public ResponseEntity findRate(@RequestBody RateRequest json) throws Exception {

        try {
            //Se parsea la fecha con el formato del enunciado
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");
            LocalDateTime timestamp = LocalDateTime.parse(json.getDate(), formatter);
            List <Price> Lprice= priceService.findRate(timestamp , json.getProductId(), json.getBrandId());

            //Se revisa si la consulta no trajo resultados
            if(Lprice.isEmpty()){
                return new ResponseEntity(new ErrorResponse(HttpStatus.NOT_FOUND),HttpStatus.NOT_FOUND);
            }else{
                Price rPrice = Lprice.get(0);
                return new ResponseEntity( new RateResponse(rPrice.getPrice(), rPrice.getBrand().getId(),
                        rPrice.getProduct().getId(), rPrice.getStartDate(), timestamp, rPrice.getEndDate(),
                        rPrice.getPriceList()), HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity(new ErrorResponse(HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
        }

    }



}
