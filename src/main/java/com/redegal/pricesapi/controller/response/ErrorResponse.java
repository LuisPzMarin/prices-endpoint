package com.redegal.pricesapi.controller.response;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

public class ErrorResponse {
    private LocalDateTime timestamp;
    private String message;
    private boolean error;


    public ErrorResponse(HttpStatus errorCode) {
        this.timestamp = now();
        this.error =true;
        switch (errorCode){
            case NOT_FOUND:
                this.message = "No existe tarifa para los datos introducidos";
                break;
            case BAD_REQUEST:
                this.message = "La solicitud no cumple el formato adecuado." +
                        "Debe seguir el siguiente formato:" +
                        "{ date: 'yyyy-MM-dd-HH.mm.ss'," +
                        "productId: Long," +
                        "brandId: Long" +
                        "}";
                break;
            default:
                this.message = "Ha ocurrido un error, intentelo de nuevo.";
        }

    }


    public LocalDateTime getTimestamp() {
        return this.timestamp;
    }

    public String getMessage() {
        return this.message;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isError() {
        return this.error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
}
