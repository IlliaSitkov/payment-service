package com.example.paymentservice.validators;

import com.example.paymentservice.dtos.PaymentModeDto;
import com.example.paymentservice.exceptions.InvalidPaymentModeException;
import com.example.paymentservice.utils.Mode;
import org.springframework.stereotype.Component;

@Component
public class PaymentModeValidatorImpl implements PaymentModeValidator {

    @Override
    public void validatePaymentMode(PaymentModeDto paymentModeDto) throws InvalidPaymentModeException {
        if (paymentModeDto.getMode() == Mode.AUTOMATIC && paymentModeDto.getCardNumber() == null) {
            throw new InvalidPaymentModeException("Card number is not specified");
        }
    }
}
