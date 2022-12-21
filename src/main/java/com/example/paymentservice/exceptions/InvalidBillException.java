package com.example.paymentservice.exceptions;

public class InvalidTariffException extends Exception {

    public InvalidTariffException(String message) {
        super("Invalid tariff: "+message);
    }
}
