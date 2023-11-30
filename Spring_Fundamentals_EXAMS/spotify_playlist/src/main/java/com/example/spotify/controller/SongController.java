package com.example.spotify.controller;

import com.example.spotify.model.binding.SongAddBindingModel;
import com.example.spotify.model.service.SongServiceModel;
import com.example.spotify.service.SongService;
import com.example.spotify.util.CurrentUser;
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

@Controller
@RequestMapping("/songs")
public class SongController {

    private final CurrentUser currentUser;
    private final SongService songService;

    private final ModelMapper modelMapper;

    public SongController(CurrentUser currentUser, SongService songService, ModelMapper modelMapper) {
        this.currentUser = currentUser;
        this.songService = songService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String add(Model model, HttpSession httpSession){

        if(currentUser.getId() == null){
            return "redirect:/users/login";
        }

        if(!model.containsAttribute("songAddBindingModel")){
            model.addAttribute("songAddBindingModel", new SongAddBindingModel());
        }
        return "song-add";
    }


    @PostMapping("/add")
    public String addConfirm(@Valid SongAddBindingModel postAddBindingModel,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(currentUser.getId() == null){
            return "redirect:/users/login";
        }

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("songAddBindingModel", postAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.songAddBindingModel", bindingResult);
            return "redirect:/songs/add";
        }
        songService.add(modelMapper.map(postAddBindingModel, SongServiceModel.class));

        return "redirect:/";
    }


    @GetMapping("/add/{id}")
    String likePost(@PathVariable Long id){

        if(currentUser.getId() == null){
            return "redirect:/users/login";
        }

        Long userId = currentUser.getId();

        songService.addSong(id, userId);
        return "redirect:/";
    }
    @GetMapping("*")
    public String notFound(){
        return "redirect:/";
    }

}
