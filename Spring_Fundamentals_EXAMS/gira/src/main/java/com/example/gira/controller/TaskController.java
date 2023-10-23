package com.example.gira.controller;

import com.example.gira.model.binding.TaskAddBindingModel;
import com.example.gira.model.service.TaskServiceModel;
import com.example.gira.service.TaskService;
import com.example.gira.util.CurrentUser;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/tasks")
public class TaskController {



    private final CurrentUser currentUser;
    private final TaskService taskService;
    private final ModelMapper modelMapper;

    public TaskController(CurrentUser currentUser, TaskService taskService, ModelMapper modelMapper) {
        this.currentUser = currentUser;
        this.taskService = taskService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/add")
    public String add(Model model){
        // Not logged user cannot access add page
        if(currentUser.getId() == null){
            return "redirect:/users/login";
        }

        if(!model.containsAttribute("taskAddBindingModel")){
            model.addAttribute("taskAddBindingModel", new TaskAddBindingModel());
        }
        return "add-task";
    }


    @PostMapping("/add")
    public String addConfirm(@Valid TaskAddBindingModel taskAddBindingModel,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(currentUser.getId() == null){
            return "redirect:/users/login";
        }

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("taskAddBindingModel", taskAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.taskAddBindingModel", bindingResult);
            return "redirect:/tasks/add";
        }
        taskService.add(modelMapper.map(taskAddBindingModel, TaskServiceModel.class));

        return "redirect:/";
    }


    @PostMapping("/progress/{id}")
    public String progressById(@PathVariable String id){
        taskService.makeProgressById(id);
        return "redirect:/";
    }



}
