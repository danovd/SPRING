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
import project.model.binding.AlbumAddBindingModel;
import project.model.service.AlbumServiceModel;
import project.service.AlbumService;
import project.util.CurrentUser;

@Controller
@RequestMapping("/albums")
public class AlbumController {


    private final CurrentUser currentUser;
    private final AlbumService albumService;
    private final ModelMapper modelMapper;

    public AlbumController(CurrentUser currentUser, AlbumService albumService, ModelMapper modelMapper) {
        this.currentUser = currentUser;
        this.albumService = albumService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String add(Model model){
        // Not logged user cannot access add page
        if(currentUser.getId() == null){
            return "redirect:/users/login";
        }

        if(!model.containsAttribute("albumAddBindingModel")){
            model.addAttribute("albumAddBindingModel", new AlbumAddBindingModel());
        }
        return "add-album";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid AlbumAddBindingModel albumAddBindingModel,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(currentUser.getId() == null){
            return "redirect:/users/login";
        }

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("albumAddBindingModel", albumAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.albumAddBindingModel", bindingResult);
            return "redirect:/albums/add";
        }

        System.out.println(albumAddBindingModel.getArtist() + "   BINDING");
        albumService.add(modelMapper.map(albumAddBindingModel, AlbumServiceModel.class));

        return "redirect:/";
    }


    @GetMapping("/delete/{id}")
    public String buyById(@PathVariable String id){
        albumService.deleteById(id);
        return "redirect:/";
    }

}
