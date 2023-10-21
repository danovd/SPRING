package project.controller;

import project.model.entity.Offer;
import project.model.entity.User;
import project.service.OfferService;
import project.service.UserService;
import project.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class HomeController {


    private final CurrentUser currentUser;
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final OfferService offerService;

    public HomeController(CurrentUser currentUser, UserService userService, ModelMapper modelMapper, OfferService offerService) {
        this.currentUser = currentUser;
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.offerService = offerService;
    }


    @GetMapping("/")
    public String index(Model model){
        if(currentUser.getId() == null){
            return "index";
        }

        List<User> allUsers = userService.getAllOtherUsers();
        model.addAttribute("allOtherUsers", allUsers);

        //  List<Integer> sizes = allUsers.stream().map(user -> user.getOffers().size()).collect(Collectors.toList());
        int totalSize = allUsers.stream()
                .collect(Collectors.summingInt(user -> user.getOffers().size()));
        model.addAttribute("total", totalSize);


   //     List<Offer> allOffers = offerService.getAllOffers();
   //     model.addAttribute("allOffers", allOffers);

        Set<Offer> ownOffers = offerService.getOwnOffers();
      //  Set<Offer> ownOffers = allOffers.stream().filter(o -> o.getUser().getId().equals(currentUser.getId())).collect(Collectors.toSet());
        model.addAttribute("ownOffers", ownOffers);

        Set<Offer> boughtOffers = offerService.getBoughtOffers();
        model.addAttribute("boughtOffers", boughtOffers);




        return "home";
    }



}
