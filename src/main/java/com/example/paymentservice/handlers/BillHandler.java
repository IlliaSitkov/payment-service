package com.example.paymentservice.handlers;

import com.example.paymentservice.models.Bill;

public interface BillHandler {

    Bill processBillRequest(long userId) throws Exception;




}
