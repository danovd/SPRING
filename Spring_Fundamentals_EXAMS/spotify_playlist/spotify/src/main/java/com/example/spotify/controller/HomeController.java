package com.example.spotify.controller;

import com.example.spotify.model.entity.Song;
import com.example.spotify.model.entity.User;
import com.example.spotify.model.entity.enums.StyleNameEnum;
import com.example.spotify.service.SongService;
import com.example.spotify.service.UserService;
import com.example.spotify.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final UserService userService;

    private final SongService songService;

    public HomeController(CurrentUser currentUser, UserService userService, SongService songService) {
        this.currentUser = currentUser;
        this.userService = userService;
        this.songService = songService;
    }


    @GetMapping()
    public String index(Model model){
        if(currentUser.getId() == null){
            return "index";
        }
        // The following two rows are because of need any time you press add btn to add a song to your playlist
        // and to see the btn add to disappears. To do so, we need to refresh the page and any time we refresh we need
        // to take renewed data from db, or  we will see the old one!!!
        User user = userService.findUserById(currentUser.getId());
        currentUser.setPlayList(user.getPlaylist());
        //////////////////////////////////////////////////////////////////////////////////////////////////////////



        Set<Song> popSongs = songService.getSongsByStyle(StyleNameEnum.POP);
        Set<Song> rockSongs = songService.getSongsByStyle(StyleNameEnum.ROCK);
        Set<Song> jazzSongs = songService.getSongsByStyle(StyleNameEnum.JAZZ);

        model.addAttribute("popSongs", popSongs);
        model.addAttribute("rockSongs", rockSongs);
        model.addAttribute("jazzSongs", jazzSongs);

        Set<Song> songs = userService.findSongsOfUserByUserId(currentUser.getId());

        model.addAttribute("songs", songs);
        Long duration = songs.stream()
                .mapToLong(Song::getDuration) // Map to long values
                .sum();

        long minutes = duration / 60;
        long secondsLong = duration % 60;
        String seconds = secondsLong < 10 ? "0" + secondsLong : String.valueOf(secondsLong);

        model.addAttribute("minutes", minutes);
        model.addAttribute("seconds", seconds);
        return "home";
    }

    @GetMapping("*")
    public String notFound(){
        return "redirect:/";
    }
}
