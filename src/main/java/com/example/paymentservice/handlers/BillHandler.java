package com.example.paymentservice.handlers;

import com.example.paymentservice.models.Bill;

public interface BillHandler {

    Bill processBillRequestForUser(long userId) throws Exception;




}
