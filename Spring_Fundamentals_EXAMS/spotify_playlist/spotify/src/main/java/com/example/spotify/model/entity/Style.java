package com.example.spotify.model.entity;

import com.example.spotify.model.entity.enums.StyleNameEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "styles")
public class Style extends BaseEntity{


    private StyleNameEnum styleName;
    private String description;




    public Style() {
    }


    @Enumerated(EnumType.STRING)
    public StyleNameEnum getStyleName() {
        return styleName;
    }
    public void setStyleName(StyleNameEnum styleName) {
        this.styleName = styleName;
    }



    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
