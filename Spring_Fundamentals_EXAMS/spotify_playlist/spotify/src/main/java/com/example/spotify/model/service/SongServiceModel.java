package com.example.spotify.model.service;

import com.example.spotify.model.entity.Style;
import com.example.spotify.model.entity.enums.StyleNameEnum;

import java.time.LocalDate;

public class SongServiceModel {

    private Long id;

    private String performer;
    private String title;
    private Integer duration;
    private LocalDate releaseDate;
    private StyleNameEnum style;

    public SongServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

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

    public StyleNameEnum getStyle() {
        return style;
    }

    public void setStyle(StyleNameEnum style) {
        this.style = style;
    }
}
