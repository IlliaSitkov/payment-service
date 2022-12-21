package com.example.paymentservice.validators;

import com.example.paymentservice.dtos.PaymentModeDto;
import com.example.paymentservice.exceptions.InvalidPaymentModeException;

public interface PaymentModeValidator {


    void validatePaymentMode(PaymentModeDto paymentModeDto) throws InvalidPaymentModeException;


}
