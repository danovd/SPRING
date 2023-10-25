package com.example.gira.service;

import com.example.gira.model.entity.User;
import com.example.gira.model.service.UserServiceModel;

public interface UserService {
    void registerUser(UserServiceModel map);

    UserServiceModel findByEmaileAndPassword(String username, String password);

    void loginUser(String id, String username);

    void logout();

    User findById(String id);
}
