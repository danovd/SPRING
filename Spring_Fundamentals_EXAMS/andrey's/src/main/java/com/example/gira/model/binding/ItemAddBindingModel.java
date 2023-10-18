package com.example.gira.model.binding;


import com.example.gira.model.entity.enums.CategoryNameEnum;
import com.example.gira.model.entity.enums.GenderEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class ItemAddBindingModel {

    private String name;
    private String description;
    private BigDecimal price;
    private String category;
    private String gender;






    public ItemAddBindingModel() {
    }

    @Size(min= 3)
    @NotBlank
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    @Size(min = 4)
    @NotBlank
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }



    @Positive
    @NotNull
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }



    @NotBlank
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }


    @NotBlank
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
}
