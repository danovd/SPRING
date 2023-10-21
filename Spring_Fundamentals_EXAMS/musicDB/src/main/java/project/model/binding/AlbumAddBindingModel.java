package project.model.binding;

import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;
import project.model.entity.Artist;
import project.model.entity.User;
import project.model.entity.enums.GenreNameEnum;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AlbumAddBindingModel {
    private String name;
    private String imageUrl;
    private BigDecimal price;
    private Integer copies;
    private LocalDate releasedDate;
    private String producer;
    private String artist;
    private String genre;
    private String description;


    public AlbumAddBindingModel() {
    }

    @NotBlank
    @Size(min = 3, max = 20)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @NotBlank
    @Size(min = 5)
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    @NotNull
    @Positive
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    @Min(value = 10)
    @NotNull
    public Integer getCopies() {
        return copies;
    }
    public void setCopies(Integer copies) {
        this.copies = copies;
    }



    @NotNull
    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate getReleasedDate() {
        return releasedDate;
    }
    public void setReleasedDate(LocalDate releasedDate) {
        this.releasedDate = releasedDate;
    }



    public String getProducer() {
        return producer;
    }
    public void setProducer(String producer) {
        this.producer = producer;
    }




    @NotBlank
    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }


    @NotBlank
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }



    @NotBlank
    @Size(min = 5)
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }





































}
