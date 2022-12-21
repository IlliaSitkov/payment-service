package com.example.paymentservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(value = {InvalidBillException.class, InvalidPaymentModeException.class, InvalidUserException.class, InvalidTariffException.class})
    public ResponseEntity<Map<String,String>> handleBadRequestExceptions(Exception e) {
        return makeExceptionResponseEntity(e, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Map<String,String>> catchOtherExceptions(Exception e) {
        return makeExceptionResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<Map<String,String>> makeExceptionResponseEntity(Exception e, HttpStatus httpStatus) {
        return new ResponseEntity<>(makeSimpleExceptionResponse(e), httpStatus);
    }

    private Map<String, String> makeSimpleExceptionResponse(Exception e) {
        Map<String, String> map = new HashMap<>();
        map.put("success", "false");
        map.put("error", e.getMessage());
        return map;
    }


}
