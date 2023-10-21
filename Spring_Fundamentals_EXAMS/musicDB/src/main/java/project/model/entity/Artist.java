package project.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import project.model.entity.enums.ArtistNameEnum;

@Entity
@Table(name = "artists")
public class Artist extends BaseEntity {

    private ArtistNameEnum name;
    private String careerInformation;

    public Artist() {
    }

    @Enumerated(EnumType.STRING)
    public ArtistNameEnum getName() {
        return name;
    }
    public void setName(ArtistNameEnum name) {
        this.name = name;
    }

    @Column(name="career_information", columnDefinition = "TEXT")
    public String getCareerInformation() {
        return careerInformation;
    }
    public void setCareerInformation(String careerInformation) {
        this.careerInformation = careerInformation;
    }





































}
