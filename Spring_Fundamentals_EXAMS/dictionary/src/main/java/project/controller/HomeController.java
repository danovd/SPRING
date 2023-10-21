package project.controller;

import project.model.entity.Word;
import project.model.entity.enums.LanguageNameEnum;
import project.service.UserService;
import project.service.WordService;
import project.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Set;

@Controller
public class HomeController {


    private final CurrentUser currentUser;
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final WordService wordService;

    public HomeController(CurrentUser currentUser, UserService userService, ModelMapper modelMapper, WordService wordService) {
        this.currentUser = currentUser;
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.wordService = wordService;
    }


    @GetMapping("/")
    public String index(Model model){
        if(currentUser.getId() == null){
            return "index";
        }
        // Вариант 1
        Set<Word> spanishWords = wordService.getAllByLanguage(LanguageNameEnum.SPANISH);
        Set<Word> germanyWords = wordService.getAllByLanguage(LanguageNameEnum.GERMAN);
        Set<Word> italyWords = wordService.getAllByLanguage(LanguageNameEnum.ITALIAN);
        Set<Word> frenchWords = wordService.getAllByLanguage(LanguageNameEnum.FRENCH);
        int totalWords = spanishWords.size() + germanyWords.size() + italyWords.size() + frenchWords.size();

        // Вариант 2 -> Преточване на всички записи веднъж и филтрация за всеки отделен сет ....



        model.addAttribute("spanishWords", spanishWords);
        model.addAttribute("germanyWords", germanyWords);
        model.addAttribute("italyWords", italyWords);
        model.addAttribute("frenchWords", frenchWords);
        model.addAttribute("totalWords", totalWords);




        return "home";
    }



}
