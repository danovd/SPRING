package com.example.gira.controller;

import com.example.gira.model.entity.Item;
import com.example.gira.service.ItemService;
import com.example.gira.service.UserService;
import com.example.gira.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {


    private final CurrentUser currentUser;
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final ItemService itemService;

    public HomeController(CurrentUser currentUser, UserService userService, ModelMapper modelMapper, ItemService itemService) {
        this.currentUser = currentUser;
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.itemService = itemService;
    }


    @GetMapping("/")
    public String index(Model model){
        if(currentUser.getId() == null){
            return "index";
        }
        List<Item> allItems = itemService.getAllItems();
        model.addAttribute("allItems", allItems);

        // TODO

        return "home";
    }



}
