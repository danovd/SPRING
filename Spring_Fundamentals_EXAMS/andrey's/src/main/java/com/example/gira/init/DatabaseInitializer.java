package com.example.gira.init;



import com.example.gira.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer implements CommandLineRunner{




    private final CategoryService categoryService;

    public DatabaseInitializer(CategoryService categoryService) {
        this.categoryService = categoryService;
    }



    @Override public void run(String... args) throws Exception {
        categoryService.initCategories();
    }
}

