package project.controller;

import project.model.entity.Hero;
import project.service.HeroService;
import project.service.UserService;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import project.util.CurrentUser;

import java.util.List;
import java.util.Set;


@Controller
public class HomeController {


    private final CurrentUser currentUser;
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final HeroService heroService;

    public HomeController(CurrentUser currentUser, UserService userService, ModelMapper modelMapper, HeroService heroService) {
        this.currentUser = currentUser;
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.heroService = heroService;
    }


    @GetMapping("/")
    public String index(Model model){
        if(currentUser.getId() == null){
            return "index";
        }


        List <Hero> heroSet = heroService.getAllHeroes();
        model.addAttribute("heroSet", heroSet );



        return "home";
    }



}
