package com.a.init;

import com.a.service.MoodService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer implements CommandLineRunner{


    private final MoodService moodService;


    public DatabaseInitializer(MoodService moodService) {
        this.moodService = moodService;

    }

    @Override public void run(String... args) throws Exception {
       moodService.initMoods();
    }

}

