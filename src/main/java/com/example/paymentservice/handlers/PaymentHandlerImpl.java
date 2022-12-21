package com.example.paymentservice.handlers;

import com.example.paymentservice.models.Bill;
import com.example.paymentservice.repositories.BillRepository;
import com.example.paymentservice.services.PaymentService;
import com.example.paymentservice.validators.UserValidator;
import org.springframework.stereotype.Component;

@Component
public class PaymentHandlerImpl implements PaymentHandler {

    private final BillRepository billRepository;

    private final UserValidator userValidator;

    private final PaymentService paymentService;

    public PaymentHandlerImpl(BillRepository billRepository, UserValidator userValidator, PaymentService paymentService) {
        this.billRepository = billRepository;
        this.userValidator = userValidator;
        this.paymentService = paymentService;
    }

    @Override
    public Bill performPayment(long billId) throws Exception {
        Bill bill = billRepository.getById(billId);
        userValidator.validateUser(bill.getUser());
        boolean paymentSuccessful = paymentService.pay(bill.getUser().getCardNumber(), bill.getCost());
        bill.setPaid(paymentSuccessful);
        return billRepository.updateBill(bill);
    }
}
