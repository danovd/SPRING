package com.example.coffee_shop.repository;

import com.example.coffee_shop.model.entity.Category;
import com.example.coffee_shop.model.entity.CategoryNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(CategoryNameEnum name);

}
