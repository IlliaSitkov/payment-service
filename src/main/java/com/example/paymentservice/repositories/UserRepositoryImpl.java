package com.example.paymentservice.repositories;

import com.example.paymentservice.exceptions.InvalidUserException;
import com.example.paymentservice.models.User;
import org.springframework.stereotype.Component;

@Component
public class UserRepositoryImpl implements UserRepository {


    @Override
    public User getUserById(long id) throws InvalidUserException {
        // connect to db and find user by id
        // throw exception if user not found
        // return the user
        return null;
    }

    @Override
    public User updateUser(User user) throws InvalidUserException {
        // connect to db and update user by id
        // throw exception if user not found
        // return the updated user
        return null;
    }
}
