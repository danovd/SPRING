package com.a.controller;

import com.a.model.entity.Post;
import com.a.model.entity.User;
import com.a.model.service.PostServiceModel;
import com.a.model.service.UserServiceModel;
import com.a.service.PostService;
import com.a.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    private final PostService postService;
    private final UserService userService;

    private final ModelMapper modelMapper;

    public HomeController(PostService postService, UserService userService, ModelMapper modelMapper) {
        this.postService = postService;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/")
    public String index(HttpSession httpSession, Model model) {


        if(httpSession.getAttribute("user") == null){
            return "index";
        }

        String userId = ((UserServiceModel)httpSession.getAttribute("user")).getId();

        User user = userService.findById(userId);

        List<Post> myPosts = postService.findMyPosts(userId);

 //       List<PostServiceModel> myPosts_ = myPosts.stream()
  //              .map(e -> modelMapper.map(e, PostServiceModel.class))
 //               .toList();

        model.addAttribute("myPosts", myPosts);

        model.addAttribute("userInfo", user);


        List<Post> otherPosts = postService.findOtherPosts(userId);
   //     List<PostServiceModel> otherPosts_ = otherPosts.stream()
    //            .map(e -> modelMapper.map(e, PostServiceModel.class))
   //             .toList();
        model.addAttribute("otherPosts", otherPosts);



        return "home";
    }




}
