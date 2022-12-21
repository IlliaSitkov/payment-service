package com.example.paymentservice.handlers;

import com.example.paymentservice.models.Bill;

public interface PaymentHandler {

    Bill performPayment(long billId) throws Exception;

}
