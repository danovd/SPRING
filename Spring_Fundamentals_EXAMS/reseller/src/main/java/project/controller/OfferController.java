package project.controller;

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
import project.model.binding.OfferAddBindingModel;
import project.model.entity.Offer;
import project.model.entity.User;
import project.model.service.OfferServiceModel;
import project.service.OfferService;
import project.service.UserService;
import project.util.CurrentUser;

@Controller
@RequestMapping("/offers")
public class OfferController {

    private final CurrentUser currentUser;
    private final OfferService offerService;
    private final ModelMapper modelMapper;
    private final UserService userService;

    public OfferController(CurrentUser currentUser, OfferService offerService, ModelMapper modelMapper, UserService userService) {
        this.currentUser = currentUser;
        this.offerService = offerService;
        this.modelMapper = modelMapper;
        this.userService = userService;
    }


    @GetMapping("/add")
    public String add(Model model){

        if(currentUser.getId() == null){
            return "redirect:/users/login";
        }

        if(!model.containsAttribute("offerAddBindingModel")){
            model.addAttribute("offerAddBindingModel", new OfferAddBindingModel());
        }
        return "offer-add";
    }


    @PostMapping("/add")
    public String addConfirm(@Valid OfferAddBindingModel offerAddBindingModel,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("offerAddBindingModel", offerAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.offerAddBindingModel", bindingResult);
            return "redirect:add";
        }
        offerService.add(modelMapper.map(offerAddBindingModel, OfferServiceModel.class));

        return "redirect:/";
    }

    @GetMapping("/remove/{id}")
    public String removeById(@PathVariable String id){
        offerService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/buy/{id}")
    public String buyById(@PathVariable String id){
        offerService.buyOfferWithId(id, currentUser.getId());
        return "redirect:/";
    }

}
