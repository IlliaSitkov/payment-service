package com.example.paymentservice.validators;

import com.example.paymentservice.exceptions.InvalidUserException;
import com.example.paymentservice.models.User;
import org.springframework.stereotype.Component;

@Component
public class UserValidatorImpl implements UserValidator {

    @Override
    public void validateUser(User user) throws InvalidUserException {
        if (user.isBanned()) {
            throw new InvalidUserException("User is banned. No operations allowed");
        }
    }
}
