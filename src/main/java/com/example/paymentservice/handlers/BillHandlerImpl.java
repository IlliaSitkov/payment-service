package com.example.paymentservice.handlers;

import com.example.paymentservice.models.Bill;
import com.example.paymentservice.models.User;
import com.example.paymentservice.repositories.BillRepository;
import com.example.paymentservice.repositories.UserRepository;
import com.example.paymentservice.utils.Mode;
import com.example.paymentservice.validators.UserValidator;
import org.springframework.stereotype.Component;

@Component
public class BillHandlerImpl implements BillHandler {

    private final UserValidator userValidator;

    private final UserRepository userRepository;

    private final BillRepository billRepository;

    private final PaymentHandler paymentHandler;

    public BillHandlerImpl(UserValidator userValidator, UserRepository userRepository, BillRepository billRepository, PaymentHandler paymentHandler) {
        this.userValidator = userValidator;
        this.userRepository = userRepository;
        this.billRepository = billRepository;
        this.paymentHandler = paymentHandler;
    }

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
