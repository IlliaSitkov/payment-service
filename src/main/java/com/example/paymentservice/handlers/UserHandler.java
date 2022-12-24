package com.example.paymentservice.handlers;

import com.example.paymentservice.dtos.PaymentModeDto;

public interface UserHandler {

    void setPaymentMode(long userId, PaymentModeDto paymentModeDto) throws Exception;

    boolean attemptToBanUser(long userId) throws Exception;
}
