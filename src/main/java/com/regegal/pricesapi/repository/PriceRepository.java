package com.regegal.pricesapi.repository;

import com.regegal.pricesapi.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository <Price, Long> {
}
