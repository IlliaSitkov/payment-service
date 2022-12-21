package com.example.paymentservice.exceptions;

public class InvalidBillException extends Exception {

    public InvalidBillException(String message) {
        super("Invalid bill: "+message);
    }
}
