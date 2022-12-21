package com.example.paymentservice.exceptions;

public class InvalidPaymentModeException extends Exception {

    public InvalidPaymentModeException(String message) {
        super("Invalid payment mode: "+message);
    }
}
