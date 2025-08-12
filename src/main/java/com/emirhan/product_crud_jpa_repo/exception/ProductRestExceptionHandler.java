package com.emirhan.product_crud_jpa_repo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class ProductRestExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ProductErrorResponse> handleException(ProductNotFoundException e) {
        ProductErrorResponse errorResponse = new ProductErrorResponse();
        errorResponse.setMessage(e.getMessage());
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setTimestamp(System.currentTimeMillis());

        return new  ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
