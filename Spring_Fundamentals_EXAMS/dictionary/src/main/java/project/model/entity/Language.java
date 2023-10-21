package project.model.entity;

import jakarta.persistence.*;
import project.model.entity.enums.LanguageNameEnum;

@Entity
@Table(name = "languages")
public class Language extends BaseEntity{
    private LanguageNameEnum languageName;
    private String description;

    // TODO -> if need double side relation


    public Language() {
    }




    @Enumerated(EnumType.STRING)
    public LanguageNameEnum getLanguageName() {
        return languageName;
    }
    public void setLanguageName(LanguageNameEnum languageName) {
        this.languageName = languageName;
    }

    @Column(nullable = false)
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
