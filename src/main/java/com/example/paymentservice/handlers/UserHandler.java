package com.example.paymentservice.handlers;

import com.example.paymentservice.dtos.PaymentModeDto;

public interface UserHandler {

    void setPaymentMode(long userId, PaymentModeDto paymentModeDto) throws Exception;

    void banUser(long userId, int unpaidBillCountAllowed) throws Exception;
}
