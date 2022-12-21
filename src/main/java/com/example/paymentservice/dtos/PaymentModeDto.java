package com.example.paymentservice.dto;

import com.example.paymentservice.utils.Mode;
import com.example.paymentservice.utils.Period;
import lombok.Getter;

@Getter
public class PaymentModeDto {

    private Long tariffId;

    private Period period;

    private Mode mode;

    private String cardNumber;


}
