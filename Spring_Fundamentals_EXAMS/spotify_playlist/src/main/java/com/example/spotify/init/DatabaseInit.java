package com.example.spotify.init;


import com.example.spotify.service.StyleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInit implements CommandLineRunner {

    private final StyleService styleService;

    public DatabaseInit(StyleService styleService) {
        this.styleService = styleService;
    }

    @Override
    public void run(String... args) throws Exception {

        this.styleService.initStyles();


    }
}
