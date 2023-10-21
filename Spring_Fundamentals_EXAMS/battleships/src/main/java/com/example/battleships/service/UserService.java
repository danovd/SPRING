package com.example.battleships.service;

import com.example.battleships.model.entity.Ship;
import com.example.battleships.model.service.UserServiceModel;

import java.util.Set;

public interface UserService {
    void registerUser(UserServiceModel map);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    void loginUser(String id, String username);

    void logout();


}
