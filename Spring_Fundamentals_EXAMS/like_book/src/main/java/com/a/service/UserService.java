package com.a.service;

import com.a.model.entity.User;
import com.a.model.service.UserServiceModel;

public interface UserService {
    void registerUser(UserServiceModel map);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    User findById(String userId);
}
