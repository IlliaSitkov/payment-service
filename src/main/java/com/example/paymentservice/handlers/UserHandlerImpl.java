package com.example.paymentservice.handlers;

import com.example.paymentservice.config.ApplicationProperties;
import com.example.paymentservice.dtos.PaymentModeDto;
import com.example.paymentservice.models.Tariff;
import com.example.paymentservice.models.User;
import com.example.paymentservice.repositories.BillRepository;
import com.example.paymentservice.repositories.TariffRepository;
import com.example.paymentservice.repositories.UserRepository;
import com.example.paymentservice.validators.PaymentModeValidator;
import com.example.paymentservice.validators.UserValidator;
import org.springframework.stereotype.Component;

@Component
public class UserHandlerImpl implements UserHandler {

    private final PaymentModeValidator paymentModeValidator;

    private final UserValidator userValidator;

    private final UserRepository userRepository;

    private final TariffRepository tariffRepository;

    private final BillRepository billRepository;

    private final ApplicationProperties applicationProperties;

    public UserHandlerImpl(PaymentModeValidator paymentModeValidator, UserValidator userValidator, UserRepository userRepository, TariffRepository tariffRepository, BillRepository billRepository, ApplicationProperties applicationProperties) {
        this.paymentModeValidator = paymentModeValidator;
        this.userValidator = userValidator;
        this.userRepository = userRepository;
        this.tariffRepository = tariffRepository;
        this.billRepository = billRepository;
        this.applicationProperties = applicationProperties;
    }

    @Override
    public void setPaymentMode(long userId, PaymentModeDto paymentModeDto) throws Exception {
        paymentModeValidator.validatePaymentMode(paymentModeDto);
        User user = userRepository.getUserById(userId);
        Tariff tariff = tariffRepository.getTariffById(paymentModeDto.getTariffId());
        userValidator.validateUser(user);
        user.setTariff(tariff);
        user.setPeriod(paymentModeDto.getPeriod());
        user.setMode(paymentModeDto.getMode());
        user.setCardNumber(paymentModeDto.getCardNumber());
        userRepository.updateUser(user);
    }

    private boolean userIsToBeBanned(long userId) {
        return billRepository.getUnpaidBillCountForPeriod(userId, applicationProperties.getPeriodDays()) > applicationProperties.getUnpaidBillCountAllowed();
    }

    @Override
    public boolean attemptToBanUser(long userId) throws Exception {
        User user = userRepository.getUserById(userId);
        userValidator.validateUser(user);
        if (userIsToBeBanned(userId)) {
            user.setBanned(true);
            userRepository.updateUser(user);
            return true;
        }
        return false;
    }
}
