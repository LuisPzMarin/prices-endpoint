package com.regegal.pricesapi.repository;

import com.regegal.pricesapi.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.*;

@Repository
public interface PriceRepository extends JpaRepository <Price, Long> {

    /** Query que devuelve los datos filtrados y ordenados por prioridad **/
    @Query("SELECT t FROM Price t WHERE t.startDate <= :date AND t.endDate >= :date  " +
            "AND t.brandId = :brandId  AND t.productId = :productId ORDER BY t.priority DESC")
    List<Price> consultPrice(LocalDateTime date, Long productId, Long brandId );




}
