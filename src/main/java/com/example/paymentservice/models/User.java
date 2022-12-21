package com.example.paymentservice.models;

import com.example.paymentservice.utils.Mode;
import com.example.paymentservice.utils.Period;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User {

    private Long id;

    private String name;

    private Tariff tariff;

    private Period period;

    private Mode mode;

    private String cardNumber;

    private boolean isBanned;

}
