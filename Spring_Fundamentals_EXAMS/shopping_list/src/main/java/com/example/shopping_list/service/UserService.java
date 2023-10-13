package com.example.shopping_list.service;

import com.example.shopping_list.model.service.UserServiceModel;

public interface UserService {
    void registerUser(UserServiceModel map);

    UserServiceModel findByUsernameAndPassword(String username, String password);
}
