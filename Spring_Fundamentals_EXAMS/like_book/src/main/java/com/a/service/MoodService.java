package com.a.service;

import com.a.model.entity.Mood;
import com.a.model.entity.enums.MoodName;
import org.springframework.stereotype.Service;


public interface MoodService {


    void initMoods();


    Mood findByMoodName(MoodName moodName);

}
