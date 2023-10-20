package com.example.battleships.controller;

import com.example.battleships.model.entity.Ship;
import com.example.battleships.service.ShipService;
import com.example.battleships.service.UserService;
import com.example.battleships.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;
import java.util.Set;

@Controller
public class HomeController {
    private final ShipService shipService;
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;


    public HomeController(ShipService shipService, UserService userService, ModelMapper modelMapper, CurrentUser currentUser) {
        this.shipService = shipService;
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @GetMapping("/")
    public String index(Model model){
        if(currentUser.getId() == null){
            return "index";
        }
        // Instead of 3 queries to DB it can happen with one query - take all and later filter
        Set<Ship> ownShips = shipService.getAllShipsOwnedByUserId(currentUser.getId());
        Set<Ship> otherShips = shipService.getAllOtherShipsNotOwnedByUserId(currentUser.getId());
        List<Ship> allShips = shipService.getAllShips();
        model.addAttribute("ownShips", ownShips);
        model.addAttribute("otherShips", otherShips);
        model.addAttribute("allShips", allShips);

        return "home";
    }


    @GetMapping("*")
    public String notFound(){
        return "redirect:/";
    }


}
