package com.assignment.warehouse.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.time.ZoneId;

@RestControllerAdvice
public class RestResponseEntityExceptionHandler 
  extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value
      = { ProductUnavailableException.class })
    protected ResponseEntity<Object> productUnavailableExceptionHandler(ProductUnavailableException ex) {
        return new ResponseEntity(WareHouseErrorMessage.builder()
                .errorCode(1001).message(ex.getMessage()).timestamp(LocalDateTime.now(ZoneId.of("UTC"))).build(), HttpStatus.NOT_FOUND);
    }
}