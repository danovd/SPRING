package project.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "words")
public class Word extends BaseEntity{

    private String term;
    private String translation;
    private String example;
    private LocalDate date;
    private Language language;
    private User addedBy;


    public Word() {
    }

    @Column(nullable = false)
    public String getTerm() {
        return term;
    }
    public void setTerm(String term) {
        this.term = term;
    }

    @Column(nullable = false)
    public String getTranslation() {
        return translation;
    }
    public void setTranslation(String translation) {
        this.translation = translation;
    }


    public String getExample() {
        return example;
    }
    public void setExample(String example) {
        this.example = example;
    }


    @Column(nullable = false)
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }



    @ManyToOne(optional = false)
    public Language getLanguage() {
        return language;
    }
    public void setLanguage(Language language) {
        this.language = language;
    }


    @ManyToOne(optional = false)
    public User getAddedBy() {
        return addedBy;
    }
    public void setAddedBy(User addedBy) {
        this.addedBy = addedBy;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return Objects.equals(term, word.term) && Objects.equals(translation, word.translation) && Objects.equals(example, word.example) && Objects.equals(date, word.date) && Objects.equals(language, word.language) && Objects.equals(addedBy, word.addedBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(term, translation, example, date, language, addedBy);
    }
}
