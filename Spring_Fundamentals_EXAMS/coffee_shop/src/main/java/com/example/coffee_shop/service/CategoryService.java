package com.example.coffee_shop.service;

import com.example.coffee_shop.model.entity.Category;
import com.example.coffee_shop.model.entity.CategoryNameEnum;

public interface CategoryService {
    void initCategories();

    Category findByCategoryNameEnum(CategoryNameEnum category);
}
