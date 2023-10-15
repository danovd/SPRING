package com.a.controller;

import com.a.model.binding.PostAddBindingModel;
import com.a.model.service.PostServiceModel;
import com.a.model.service.UserServiceModel;
import com.a.service.PostService;
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
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;
    private final ModelMapper modelMapper;
    private final HttpSession httpSession;

    public PostController(PostService postService, ModelMapper modelMapper, HttpSession httpSession) {
        this.postService = postService;
        this.modelMapper = modelMapper;
        this.httpSession = httpSession;
    }

    @GetMapping("/add")
    public String add(Model model, HttpSession httpSession){
        if(httpSession.getAttribute("user") == null){
            return "redirect:/users/login";
        }

        if(!model.containsAttribute("postAddBindingModel")){
            model.addAttribute("postAddBindingModel", new PostAddBindingModel());
        }
        return "post-add";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid PostAddBindingModel postAddBindingModel,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("postAddBindingModel", postAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.postAddBindingModel", bindingResult);
            return "redirect:/posts/add";
        }

        postService.add(modelMapper.map(postAddBindingModel, PostServiceModel.class));

        return "redirect:/";
    }
    @GetMapping("/remove/{id}")
    String removePost(@PathVariable String id){
        postService.removePostById(id);

        return "redirect:/";
    }

    @GetMapping("/like/{id}")
    String likePost(@PathVariable String id){
        String userId = ((UserServiceModel)httpSession.getAttribute("user")).getId();
        postService.likePost(id, userId);
        return "redirect:/";
    }


}
