package com.a.service.impl;

import com.a.model.entity.Mood;
import com.a.model.entity.enums.MoodName;
import com.a.repository.MoodRepository;
import com.a.service.MoodService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class MoodServiceImpl implements MoodService {

    private final MoodRepository moodRepository;

    public MoodServiceImpl(MoodRepository moodRepository) {
        this.moodRepository = moodRepository;
    }

    @Override
    public void initMoods() {

        if(moodRepository.count() == 0){
            Arrays.stream(MoodName.values())
                    .forEach(moodName -> {
                        Mood mood = new Mood();
                        mood.setMoodName(moodName);
                        moodRepository.save(mood);
                    });
        }
    }

    @Override
    public Mood findByMoodName(MoodName moodName) {
        return moodRepository.findByMoodName(moodName).orElse(null);
    }


}
