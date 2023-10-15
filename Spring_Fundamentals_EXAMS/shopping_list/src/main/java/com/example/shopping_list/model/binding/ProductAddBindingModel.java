package com.example.shopping_list.model.binding;

import com.example.shopping_list.model.entity.enums.CategoryName;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductAddBindingModel {

    private String name;
    private String description;
    private LocalDateTime neededBefore;
    private BigDecimal price;
    private CategoryName category;

    public ProductAddBindingModel() {
    }
    @NotBlank(message = "Cannot be empty")
    @Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Size(min = 5, message = "Description must be at least 5 characters")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @FutureOrPresent(message = "The date cannot be past")
    public LocalDateTime getNeededBefore() {
        return neededBefore;
    }

    public void setNeededBefore(LocalDateTime neededBefore) {
        this.neededBefore = neededBefore;
    }
    @DecimalMin(value = "0", message = "Price must be positive")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    @NotNull(message = "Category is not selected!")
    public CategoryName getCategory() {
        return category;
    }

    public void setCategory(CategoryName category) {
        this.category = category;
    }
}
