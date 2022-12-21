package com.example.paymentservice.model;

import com.example.paymentservice.utils.Mode;
import com.example.paymentservice.utils.Period;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class User {

    private Long id;

    private String name;

    private Long tariffId;

    private Period period;

    private Mode mode;

    private String cardNumber;

}
