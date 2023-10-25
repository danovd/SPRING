package com.example.gira.service;

import com.example.gira.model.entity.Classification;
import com.example.gira.model.entity.enums.ClassificationNameEnum;
import com.example.gira.repository.ClassificationRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ClassificationServiceImpl implements ClassificationService {

    private final ClassificationRepository classificationRepository;

    public ClassificationServiceImpl(ClassificationRepository classificationRepository) {
        this.classificationRepository = classificationRepository;
    }

    @Override
    public void initMoods() {
        if(classificationRepository.count() != 0){
            return;
        }
        Arrays.stream(ClassificationNameEnum.values())
                .forEach(c -> {
                    Classification classification = new Classification();
                    classification.setClassificationName(c);
                    classification.setDescription("Description for " + c);

                    classificationRepository.save(classification);
                });
    }
}
