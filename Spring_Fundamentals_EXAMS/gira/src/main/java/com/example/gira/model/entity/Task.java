package com.example.gira.model.entity;

import com.example.gira.model.entity.enums.ProgressEnum;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tasks")
public class Task extends BaseEntity{

    private String name;
    private String description;
    private ProgressEnum progress;
    private LocalDate dueDate;
    private Classification classification;
    private User user;




    public Task() {
    }



    @Column(unique = true, nullable = false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }


    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    public ProgressEnum getProgress() {
        return progress;
    }
    public void setProgress(ProgressEnum progress) {
        this.progress = progress;
    }

    @Column(nullable = false)
    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
    @ManyToOne
    @JoinColumn(nullable = false)
    public Classification getClassification() {
        return classification;
    }
    public void setClassification(Classification classification) {
        this.classification = classification;
    }

    @ManyToOne
    @JoinColumn(nullable = false)
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}
