package com.example.battleships.controller;

import com.example.battleships.model.binding.ShipAddBindingModel;
import com.example.battleships.model.entity.Ship;
import com.example.battleships.model.service.ShipServiceModel;
import com.example.battleships.service.ShipService;
import com.example.battleships.util.CurrentUser;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Objects;

@Controller
@RequestMapping("/ships")
public class ShipController {
    private final CurrentUser currentUser;
    private final ShipService shipService;
    private final ModelMapper modelMapper;


    public ShipController(CurrentUser currentUser, ShipService shipService, ModelMapper modelMapper) {
        this.currentUser = currentUser;
        this.shipService = shipService;
        this.modelMapper = modelMapper;
    }



    @GetMapping("/add")
    public String add(Model model){
        // Not logged user cannot access add page
        if(currentUser.getId() == null){
            return "redirect:/users/login";
        }

        if(!model.containsAttribute("shipAddBindingModel")){
            model.addAttribute("shipAddBindingModel", new ShipAddBindingModel());
        }
        return "ship-add";
    }


    @PostMapping("/add")
    public String addConfirm(@Valid ShipAddBindingModel shipAddBindingModel,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(currentUser.getId() == null){
            return "redirect:/users/login";
        }

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("shipAddBindingModel", shipAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.shipAddBindingModel", bindingResult);
            return "redirect:/ships/add";
        }
        shipService.add(modelMapper.map(shipAddBindingModel, ShipServiceModel.class));


        return "redirect:/";
    }

    @PostMapping("/fire")
    public String fire(@RequestParam("attacker") String attacker, @RequestParam("defender") String defender){

        System.out.println("Attacker: " + attacker);
        System.out.println("Defender: " + defender);

        if(attacker.equals("") || defender.equals("")  ){
            return "redirect:/";
        }


        Ship attackShip = shipService.findByName(attacker);
        Ship defendShip = shipService.findByName(defender);
        if(attackShip == null || defendShip == null){
            return "redirect:/";
        }
        shipService.attack(attackShip, defendShip);



        return "redirect:/";
    }

}
