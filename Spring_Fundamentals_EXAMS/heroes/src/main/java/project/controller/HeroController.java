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
import project.model.binding.HeroAddBindingModel;
import project.model.entity.Hero;
import project.model.service.HeroServiceModel;
import project.service.HeroService;
import project.util.CurrentUser;

@Controller
@RequestMapping("/heroes")
public class HeroController {



    private final CurrentUser currentUser;
    private final HeroService heroService;
    private final ModelMapper modelMapper;


    public HeroController(CurrentUser currentUser, HeroService heroService, ModelMapper modelMapper) {
        this.currentUser = currentUser;
        this.heroService = heroService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/create")
    public String create(Model model){
        // Not logged user cannot access add page
        if(currentUser.getId() == null){
            return "redirect:/users/login";
        }

        if(!model.containsAttribute("heroAddBindingModel")){
            model.addAttribute("heroAddBindingModel", new HeroAddBindingModel());
        }
        return "create-hero";
    }


    @PostMapping("/create")
    public String addConfirm(@Valid HeroAddBindingModel heroAddBindingModel,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(currentUser.getId() == null){
            return "redirect:/users/login";
        }

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("heroAddBindingModel", heroAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.heroAddBindingModel", bindingResult);
            return "redirect:/heroes/create";
        }
        heroService.create(modelMapper.map(heroAddBindingModel, HeroServiceModel.class));


        return "redirect:/";
    }



    @GetMapping("/details/{id}")
    public String details(@PathVariable String id, Model model){
        if(currentUser.getId() == null){
            return "redirect:/";
        }

        Hero hero = heroService.getHeroById(id);
        model.addAttribute("currentHero", hero);

        return "details-hero";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id, Model model){
        if(currentUser.getId() == null){
            return "redirect:/";
        }

        Hero hero = heroService.getHeroById(id);
        model.addAttribute("currentHero", hero);
        return "delete-hero";
    }


    @GetMapping("/deleteHero/{id}")
    public String deleteConfirm(@PathVariable String id){
        if(currentUser.getId() == null){
            return "redirect:/";
        }

        heroService.deleteHeroById(id);
        return "redirect:/";
    }


}
