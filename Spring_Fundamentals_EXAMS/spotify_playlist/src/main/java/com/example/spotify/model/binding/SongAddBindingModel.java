package com.example.spotify.model.binding;

import com.example.spotify.model.entity.Style;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class SongAddBindingModel {

    private String performer;

    private String title;

    private Integer duration;

    private LocalDate releaseDate;

    private String style;


    public SongAddBindingModel() {
    }

    @Size(min = 3, max = 20)
    @NotBlank
    public String getPerformer() {
        return performer;
    }
    public void setPerformer(String performer) {
        this.performer = performer;
    }


    @Size(min = 2, max = 20)
    @NotBlank
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }


    @Positive
    public Integer getDuration() {
        return duration;
    }
    public void setDuration(Integer duration) {
        this.duration = duration;
    }


    @PastOrPresent
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate getReleaseDate() {
        return releaseDate;
    }
    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }


    @NotBlank
    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
}
