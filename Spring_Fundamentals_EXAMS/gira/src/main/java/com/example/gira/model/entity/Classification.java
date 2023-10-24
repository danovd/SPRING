package com.example.gira.model.entity;

import com.example.gira.model.entity.enums.ClassificationNameEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "classifications")
public class Classification extends BaseEntity{

    private ClassificationNameEnum classificationName;
    private String description;


    public Classification() {
    }
    @Column(columnDefinition = "VARCHAR(255)")
    @Enumerated(EnumType.STRING)
    public ClassificationNameEnum getClassificationName() {
        return classificationName;
    }

    public void setClassificationName(ClassificationNameEnum classificationName) {
        this.classificationName = classificationName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
