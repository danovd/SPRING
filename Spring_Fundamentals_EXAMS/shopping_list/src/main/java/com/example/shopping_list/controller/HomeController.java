package com.example.shopping_list.controller;

import com.example.shopping_list.model.entity.enums.CategoryName;
import com.example.shopping_list.service.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final ProductService productService;

    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String index(HttpSession httpSession, Model model) {


        if(httpSession.getAttribute("user") == null){
            return "index";
        }

        model.addAttribute("totalSum", productService.getTotalSum());

        model.addAttribute("drinks", productService
                .findAllProductsByCategoryName(CategoryName.DRINK));
        model.addAttribute("food", productService
                .findAllProductsByCategoryName(CategoryName.FOOD));
        model.addAttribute("households", productService
                .findAllProductsByCategoryName(CategoryName.HOUSEHOLD));
        model.addAttribute("others", productService
                .findAllProductsByCategoryName(CategoryName.OTHER));
        return "home";
    }
}
