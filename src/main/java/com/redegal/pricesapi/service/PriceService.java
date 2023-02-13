package com.redegal.pricesapi.service;
import com.redegal.pricesapi.model.Price;

import java.time.LocalDateTime;
import java.util.List;


public interface PriceService {
    /** Métodos CRUD no requeridos por el ejercicio, pero posiblemente necesarios en un uso real **/
    Price setPrice(Price price);
    Price getPrice(Long id);
    Price modifyPrice(Long id, Price newPrice);
    boolean deletePrice(Long id);

    /** Servicio usado en el ejercicio**/
    List<Price> findRate(LocalDateTime date, Long idProduct, Long idBrand);
}
