package com.example.gira.model.entity;

import com.example.gira.model.entity.enums.CategoryNameEnum;
import jakarta.persistence.*;

@Entity
@Table(name="categories")
public class Category extends BaseEntity{
    private CategoryNameEnum name;
    private String description;


    public Category() {
    }

    @Enumerated(EnumType.STRING)
    public CategoryNameEnum getName() {
        return name;
    }

    public void setName(CategoryNameEnum name) {
        this.name = name;
    }
    @Column(name="description", columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
