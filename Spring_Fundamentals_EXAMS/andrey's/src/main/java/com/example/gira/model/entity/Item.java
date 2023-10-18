package com.example.gira.model.entity;

import com.example.gira.model.entity.enums.CategoryNameEnum;
import com.example.gira.model.entity.enums.GenderEnum;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name="items")
public class Item extends BaseEntity{

    private String name;
    private String description;
    private BigDecimal price;
    private Category category;
    private GenderEnum gender;




















    public Item() {
    }

    @Column(unique = true, nullable = false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }



    @Column(nullable = false)
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }



    @Column(nullable = false)
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    @ManyToOne
    @JoinColumn(nullable = false)
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }


    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    public GenderEnum getGender() {
        return gender;
    }
    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }
}
