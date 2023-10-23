package com.example.gira.controller;

import com.example.gira.model.entity.Task;
import com.example.gira.service.TaskService;
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
    private final TaskService taskService;

    public HomeController(CurrentUser currentUser, UserService userService, ModelMapper modelMapper, TaskService taskService) {
        this.currentUser = currentUser;
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.taskService = taskService;
    }


    @GetMapping("/")
    public String index(Model model){
        if(currentUser.getId() == null){
            return "index";
        }


        List<Task> allTasks = taskService.getAllTasks();
        model.addAttribute("allTasks", allTasks);



        return "home";
    }



}
