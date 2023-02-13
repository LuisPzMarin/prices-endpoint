package com.redegal.pricesapi;

import com.redegal.pricesapi.controller.PriceController;
import com.redegal.pricesapi.controller.request.RateRequest;
import com.redegal.pricesapi.controller.response.RateResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
class PricesApiApplicationTests {

	@Autowired
	private PriceController priceController;


	@ParameterizedTest
	@CsvFileSource(resources = "/testData.csv", numLinesToSkip = 1)
	void restIntegrationTest(ArgumentsAccessor argumentsAccessor) throws Exception {
		//Se crea el request con los datos del CSV
		RateRequest rateRequest = new RateRequest(argumentsAccessor.getString(1),
				argumentsAccessor.getLong(2), argumentsAccessor.getLong(3));
		//Se simula la llamada
		ResponseEntity<RateResponse> rateResponse = priceController.findRate(rateRequest);
		//Se revisa si la llamada ha sido la esperada
		if (rateResponse.getStatusCode() == HttpStatus.OK) {
			RateResponse price = rateResponse.getBody();
			if (price != null) {
				//Se revisa si el resultado devuelto es el esperado
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");

				assertEquals(price.getProductId(),
						argumentsAccessor.getLong(2)); // PRODUCT_ID
				assertEquals(price.getBrandId(),
						argumentsAccessor.getLong(3));	// BRAND_ID
				assertEquals(price.getPriceList(),
						argumentsAccessor.getLong(4)); // PRICE_LIS_RES
				assertEquals(price.getStartDateRate(),
						LocalDateTime.parse(argumentsAccessor.getString(5), formatter)); // START_DATE_RES
				assertEquals(price.getEndDateRate(),
						LocalDateTime.parse(argumentsAccessor.getString(6), formatter)); // END_DATE_RES
				assertEquals(price.getPrice(),
						argumentsAccessor.getDouble(7)); // PRICE_RES
			}
		} else {
			// Se revisa si el test esperaba devolver NOT_FOUND
			if (argumentsAccessor.getBoolean(0)){
				System.err.println(rateResponse.getStatusCode());
				fail("El test debería haber encontrado la tarifa");
			}
		}
	}


}
