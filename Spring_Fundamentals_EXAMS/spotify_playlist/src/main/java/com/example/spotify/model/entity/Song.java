package com.example.spotify.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "songs")
public class Song extends BaseEntity{

    private String performer;
    private String title;
    private Integer duration;
    private LocalDate releaseDate;
    private Style style;




    public Song() {
    }



    @Column(nullable = false)
    public String getPerformer() {
        return performer;
    }
    public void setPerformer(String performer) {
        this.performer = performer;
    }



    @Column(nullable = false)
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }


    @Column(nullable = false)
    public Integer getDuration() {
        return duration;
    }
    public void setDuration(Integer duration) {
        this.duration = duration;
    }



    public LocalDate getReleaseDate() {
        return releaseDate;
    }
    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }


    @ManyToOne
    @JoinColumn(nullable = false)
    public Style getStyle() {
        return style;
    }
    public void setStyle(Style style) {
        this.style = style;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return Objects.equals(performer, song.performer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(performer);
    }
}
