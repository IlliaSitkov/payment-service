package com.example.paymentservice.repositories;

import com.example.paymentservice.exceptions.InvalidUserException;
import com.example.paymentservice.models.User;

public interface UserRepository {


    User getUserById(long id) throws InvalidUserException;

    User updateUser(User user) throws InvalidUserException;

}
