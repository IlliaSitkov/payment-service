package com.example.paymentservice.controllers;

import com.example.paymentservice.handlers.PaymentHandler;
import com.example.paymentservice.models.Bill;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bills")
public class PaymentController {

    private final PaymentHandler paymentHandler;

    public PaymentController(PaymentHandler paymentHandler) {
        this.paymentHandler = paymentHandler;
    }

    @PutMapping("/bills/{id}")
    public Bill createBill(@PathVariable Long id) throws Exception {
        return paymentHandler.performPayment(id);
    }

}
