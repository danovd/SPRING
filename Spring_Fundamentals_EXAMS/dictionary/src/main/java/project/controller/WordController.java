package project.controller;

import jakarta.servlet.http.HttpSession;
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
import project.model.binding.WordAddBindingModel;
import project.model.service.WordServiceModel;
import project.service.WordService;
import project.util.CurrentUser;
@Controller
@RequestMapping("/words")
public class WordController {



    private final CurrentUser currentUser;
    private final WordService wordService;
    private final ModelMapper modelMapper;

    public WordController(CurrentUser currentUser, WordService wordService, ModelMapper modelMapper) {
        this.currentUser = currentUser;
        this.wordService = wordService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/add")
    public String add(Model model, HttpSession httpSession){

        if(currentUser.getId() == null){
            return "redirect:/users/login";
        }

        if(!model.containsAttribute("wordAddBindingModel")){
            model.addAttribute("wordAddBindingModel", new WordAddBindingModel());
        }
        return "word-add";
    }


    @PostMapping("/add")
    public String addConfirm(@Valid WordAddBindingModel wordAddBindingModel,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(currentUser.getId() == null){
            return "redirect:/users/login";
        }

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("wordAddBindingModel", wordAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.wordAddBindingModel", bindingResult);
            return "redirect:/words/add";
        }
        wordService.add(modelMapper.map(wordAddBindingModel, WordServiceModel.class));

        return "redirect:/";
    }


    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable String id){
        wordService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/remove-all")
    public String deleteAll(){
        wordService.deleteAll();
        return "redirect:/";
    }


}
