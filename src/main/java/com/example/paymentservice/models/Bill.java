package com.example.paymentservice.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@RequiredArgsConstructor
@Getter
@Setter
public class Bill {

    private Long id;

    private User user;

    private boolean isPaid;

    private double cost;

    private Date date;

    public Bill(User user, boolean isPaid, double cost) {
        this.user = user;
        this.isPaid = isPaid;
        this.cost = cost;
        this.date = new Date();
    }
}
