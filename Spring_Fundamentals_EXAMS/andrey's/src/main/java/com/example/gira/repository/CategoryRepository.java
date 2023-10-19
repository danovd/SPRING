package com.example.gira.repository;

import com.example.gira.model.entity.Category;
import com.example.gira.model.entity.enums.CategoryNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {
    Category findByName(CategoryNameEnum name);
}
