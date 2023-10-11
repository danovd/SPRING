package com.example.coffee_shop.service;

import com.example.coffee_shop.model.service.OrderServiceModel;
import com.example.coffee_shop.model.view.OrderViewModel;

import java.util.List;

public interface OrderService {

    void addOrder(OrderServiceModel map);

    List<OrderViewModel> findAllOrderByPriceDesc();

    void readyOrder(Long id);
}
