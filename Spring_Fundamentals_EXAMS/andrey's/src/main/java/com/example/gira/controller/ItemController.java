package com.example.gira.controller;

import com.example.gira.model.binding.ItemAddBindingModel;
import com.example.gira.model.entity.Item;
import com.example.gira.model.service.ItemServiceModel;
import com.example.gira.service.ItemService;
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
@RequestMapping("/items")
public class ItemController {

    private final CurrentUser currentUser;
    private final ItemService itemService;
    private final ModelMapper modelMapper;

    public ItemController(CurrentUser currentUser, ItemService itemService, ModelMapper modelMapper) {
        this.currentUser = currentUser;
        this.itemService = itemService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/add")
    public String add(Model model){
        // Not logged user cannot access add page
        if(currentUser.getId() == null){
            return "redirect:/users/login";
        }

        if(!model.containsAttribute("itemAddBindingModel")){
            model.addAttribute("itemAddBindingModel", new ItemAddBindingModel());
        }
        return "add-product";
    }



    @PostMapping("/add")
    public String addConfirm(@Valid ItemAddBindingModel itemAddBindingModel,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(currentUser.getId() == null){
            return "redirect:/users/login";
        }

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("itemAddBindingModel", itemAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.itemAddBindingModel", bindingResult);
            return "redirect:/items/add";
        }

        // TESTING
       // System.out.println(itemAddBindingModel.getCategory() + "  BINDING");
      //  ItemServiceModel s = modelMapper.map(itemAddBindingModel, ItemServiceModel.class);
      //  System.out.println(s.getCategory() + "  SERVICE");


        itemService.add(modelMapper.map(itemAddBindingModel, ItemServiceModel.class));


        return "redirect:/";
    }

    @GetMapping("/details/{name}")
    public String buyById(@PathVariable String name, Model model){
       Item item =  itemService.findItemByName(name);
       model.addAttribute("currentItem", item);
        return "details-product";
    }

    @GetMapping("/delete/{id}")
    public String buyById(@PathVariable String id){
        // If user is not logged, not allowed to delete
        if(currentUser.getId() == null){
            return "redirect:/";
        }

        itemService.deleteById(id);
        return "redirect:/";
    }

}
