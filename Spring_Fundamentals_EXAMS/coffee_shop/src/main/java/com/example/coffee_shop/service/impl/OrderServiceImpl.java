package com.example.coffee_shop.service.impl;

import com.example.coffee_shop.model.entity.Order;
import com.example.coffee_shop.model.service.OrderServiceModel;
import com.example.coffee_shop.model.view.OrderViewModel;
import com.example.coffee_shop.repository.OrderRepository;
import com.example.coffee_shop.sec.CurrentUser;
import com.example.coffee_shop.service.CategoryService;
import com.example.coffee_shop.service.OrderService;
import com.example.coffee_shop.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final UserService userService;
    private final CategoryService categoryService;

    public OrderServiceImpl(OrderRepository orderRepository, ModelMapper modelMapper, CurrentUser currentUser, UserService userService, CategoryService categoryService) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public void addOrder(OrderServiceModel orderServiceModel) {
        Order order = modelMapper.map(orderServiceModel, Order.class);
        order.setEmployee(userService.findById(currentUser.getId()));
        order.setCategory(categoryService.findByCategoryNameEnum(orderServiceModel.getCategory()));

        orderRepository.save(order);
    }

    @Override
    public List<OrderViewModel> findAllOrderByPriceDesc() {
        return orderRepository.findAllByOrderByPriceDesc().stream()
                .map(order -> modelMapper.map(order, OrderViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void readyOrder(Long id) {
        orderRepository.deleteById(id);
    }


}
