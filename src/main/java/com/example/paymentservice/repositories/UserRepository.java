package com.example.paymentservice.services;

import com.example.paymentservice.models.User;

public interface UserService {


    User getUserById(long id);

    User updateUser(User user);


}
