package project.model.entity;

import jakarta.persistence.*;
import project.model.entity.enums.GenreNameEnum;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "albums")
public class Album extends BaseEntity{

    private String name;
    private String imageUrl;
    private String description;
    private Integer copies;
    private BigDecimal price;
    private LocalDate releasedDate;
    private String producer;
    private GenreNameEnum genre;
    private Artist artist;
    private User addedFrom;


    public Album() {
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }



    @Column(nullable = false)
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }



    @Column(nullable = false, columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Column(nullable = false)
    public Integer getCopies() {
        return copies;
    }
    public void setCopies(Integer copies) {
        this.copies = copies;
    }

    @Column(nullable = false)
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    @Column(nullable = false)
    public LocalDate getReleasedDate() {
        return releasedDate;
    }
    public void setReleasedDate(LocalDate releasedDate) {
        this.releasedDate = releasedDate;
    }


    @Column
    public String getProducer() {
        return producer;
    }
    public void setProducer(String producer) {
        this.producer = producer;
    }


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    public GenreNameEnum getGenre() {
        return genre;
    }
    public void setGenre(GenreNameEnum genre) {
        this.genre = genre;
    }


    @ManyToOne
    @JoinColumn(nullable = false)
    public Artist getArtist() {
        return artist;
    }
    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    @ManyToOne
    @JoinColumn(nullable = false)
    public User getAddedFrom() {
        return addedFrom;
    }
    public void setAddedFrom(User addedFrom) {
        this.addedFrom = addedFrom;
    }




































}
