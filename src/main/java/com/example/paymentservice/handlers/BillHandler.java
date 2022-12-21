package com.example.paymentservice.handlers;

import com.example.paymentservice.models.Bill;
import com.example.paymentservice.models.User;
import com.example.paymentservice.repositories.BillRepository;
import com.example.paymentservice.repositories.UserRepository;
import com.example.paymentservice.utils.Mode;
import com.example.paymentservice.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BillHandlerImpl {

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private PaymentHandler paymentHandler;

    public Bill processBillRequest(long userId) throws Exception {
        User user = userRepository.getUserById(userId);
        userValidator.validateUser(user);
        Bill bill = new Bill(user, false, user.getTariff().getCost());
        billRepository.saveBill(bill);
        if (user.getMode() == Mode.AUTOMATIC) {
            return paymentHandler.performPayment(bill.getId());
        }
        return bill;
    }




}
