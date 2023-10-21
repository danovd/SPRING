package com.example.battleships.service;

import com.example.battleships.model.entity.Category;
import com.example.battleships.model.entity.enums.CategoryNameEnum;
import com.example.battleships.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initMoods() {
        if(categoryRepository.count() != 0){
            return;
        }
        Arrays.stream(CategoryNameEnum.values())
                .forEach(categoryNameEnum -> {
                    Category category = new Category();
                    category.setName(categoryNameEnum);
                    category.setDescription("Description for " + categoryNameEnum);
                    categoryRepository.save(category);
                });
    }
}
