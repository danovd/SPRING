package com.a.model.service;

import com.a.model.entity.User;
import com.a.model.entity.enums.MoodName;

import java.util.List;

public class PostServiceModel {

    private String id;

    private String content;

    private MoodName mood;

    private String user;

    private List<User> userLikes;


    public PostServiceModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MoodName getMood() {
        return mood;
    }

    public void setMood(MoodName mood) {
        this.mood = mood;
    }

    public String getUserId() {
        return user;
    }

    public void setUserId(String user) {
        this.user = user;
    }


    public List<User> getUserLikes() {
        return userLikes;
    }

    public void setUserLikes(List<User> userLikes) {
        this.userLikes = userLikes;
    }



}
