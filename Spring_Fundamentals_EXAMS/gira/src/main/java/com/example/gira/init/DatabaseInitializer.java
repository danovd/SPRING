package com.example.gira.init;



import com.example.gira.service.ClassificationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer implements CommandLineRunner{

    private final ClassificationService classificationService;

    public DatabaseInitializer(ClassificationService classificationService) {
        this.classificationService = classificationService;
    }


    @Override public void run(String... args) throws Exception {
       classificationService.initMoods();
    }
}

