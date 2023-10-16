package com.example.shopping_list.service;

import com.example.shopping_list.model.entity.Category;
import com.example.shopping_list.model.entity.enums.CategoryName;

public interface CategoryService {
    void initCategories();

    Category findByName(CategoryName categoryName);
}
