package com.example.shopping_list.controller;

import com.example.shopping_list.model.binding.ProductAddBindingModel;
import com.example.shopping_list.model.service.ProductServiceModel;
import com.example.shopping_list.service.ProductService;
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
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final ModelMapper modelMapper;

    public ProductController(ProductService productService, ModelMapper modelMapper) {
        this.productService = productService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String add(Model model, HttpSession httpSession){
        if(httpSession.getAttribute("user") == null){
            return "redirect:/login";
        }

        if(!model.containsAttribute("productAddBindingModel")){
            model.addAttribute("productAddBindingModel", new ProductAddBindingModel());
        }
        return "product-add";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid ProductAddBindingModel productAddBindingModel,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("productAddBindingModel", productAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.productAddBindingModel", bindingResult);
            return "redirect:add";
        }
        productService.add(modelMapper.map(productAddBindingModel, ProductServiceModel.class));

        return "redirect:/";
    }



    @GetMapping("/buy/{id}")
    public String buyById(@PathVariable String id){
        productService.buyById(id);
        return "redirect:/";
    }

    @GetMapping("/buy/all")
    public String buyAll(){
        productService.buyAll();
        return "redirect:/";
    }
}
