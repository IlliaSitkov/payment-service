package com.example.paymentservice.exceptions;

public class InvalidUserException extends Exception {

    public InvalidUserException(String message) {
        super("Invalid user: "+message);
    }
}
