package com.a.model.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post extends BaseEntity{

    private String content;
    private User user;
    private Mood mood;
    private List<User> userLikes;



    public Post() {
        this.userLikes = new ArrayList<>();
    }


    @Column(name = "content", nullable = false)
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }



    @ManyToOne
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }



    @ManyToOne
    @JoinColumn( nullable = false)
    public Mood getMood() {
        return mood;
    }
    public void setMood(Mood mood) {
        this.mood = mood;
    }




    @ManyToMany(fetch = FetchType.EAGER)
    public List<User> getUserLikes() {
        return userLikes;
    }
    public void setUserLikes(List<User> userLikes) {
        this.userLikes = userLikes;
    }


    public void addUser(User user){
        this.userLikes.add(user);
    }

    public boolean isLikedByUserByUserId(String userId){
        return userLikes.stream().anyMatch(u -> u.getId().equals(userId));
    }

}
