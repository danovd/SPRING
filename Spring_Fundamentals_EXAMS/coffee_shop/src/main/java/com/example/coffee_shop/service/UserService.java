package com.example.coffee_shop.service;

import com.example.coffee_shop.model.entity.User;
import com.example.coffee_shop.model.service.UserServiceModel;
import com.example.coffee_shop.model.view.UserViewModel;

import java.util.List;

public interface UserService {


    UserServiceModel registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);

    User findById(Long id);

    List<UserViewModel> findAllUserAndCountOfOrdersOrderByCountDesc();
}
