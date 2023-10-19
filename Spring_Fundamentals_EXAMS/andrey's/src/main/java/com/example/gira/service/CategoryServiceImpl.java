package com.example.gira.service;

import com.example.gira.model.entity.Category;
import com.example.gira.model.entity.enums.CategoryNameEnum;
import com.example.gira.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {
        if(categoryRepository.count() != 0){
            return;
        }
        Arrays.stream(CategoryNameEnum.values())
                .forEach(c -> {
                    Category category = new Category();

                    category.setName(c);
                    category.setDescription("Description for " + c);
                    categoryRepository.save(category);
                });
    }
}
