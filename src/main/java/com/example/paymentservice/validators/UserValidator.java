package com.example.paymentservice.validators;

import com.example.paymentservice.exceptions.InvalidUserException;
import com.example.paymentservice.models.User;

public interface UserValidator {

    void validateUser(User user) throws InvalidUserException;

}
