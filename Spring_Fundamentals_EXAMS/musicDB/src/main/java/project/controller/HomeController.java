package project.controller;

import org.springframework.web.bind.annotation.PathVariable;
import project.model.entity.Album;
import project.service.AlbumService;
import project.service.UserService;
import project.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class HomeController {


    private final CurrentUser currentUser;
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final AlbumService albumService;

    public HomeController(CurrentUser currentUser, UserService userService, ModelMapper modelMapper, AlbumService albumService) {
        this.currentUser = currentUser;
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.albumService = albumService;
    }


    @GetMapping("/")
    public String index(Model model){
        if(currentUser.getId() == null){
            return "index";
        }
        List<Album> allAlbums = albumService.getAllAlbums();
        model.addAttribute("allAlbums", allAlbums);

        BigDecimal totalCopies = albumService.getNumberOfAllCopies();
        model.addAttribute("totalCopies", totalCopies);
        return "home";
    }



}
