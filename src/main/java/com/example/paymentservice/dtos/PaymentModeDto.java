package com.example.paymentservice.dtos;

import com.example.paymentservice.utils.Mode;
import com.example.paymentservice.utils.Period;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PaymentModeDto {

    private Long tariffId;

    private Period period;

    private Mode mode;

    private String cardNumber;

}
