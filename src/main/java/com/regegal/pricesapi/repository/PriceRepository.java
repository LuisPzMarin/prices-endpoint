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
    @Query("SELECT p FROM Price p " +
            "JOIN p.brand b " +
            "JOIN p.product pr " +
            "WHERE b.id = :brandId " +
            "AND pr.id = :productId " +
            "AND (:date BETWEEN p.startDate AND p.endDate)" +
            "ORDER BY p.priority DESC")
    List<Price> findByBrandAndProductAndDates(
            LocalDateTime date,
            Long productId,
            Long brandId);




}
