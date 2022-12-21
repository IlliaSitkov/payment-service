package com.example.paymentservice.services;

import org.springframework.stereotype.Component;

@Component
public class PaymentServiceImpl implements PaymentService {


    @Override
    public boolean pay(String cardNumber, double cost) {
        // perform the payment and return true if success, or false if failure
        return true;
    }
}
