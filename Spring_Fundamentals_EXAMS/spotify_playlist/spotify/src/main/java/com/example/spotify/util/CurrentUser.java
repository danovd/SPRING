package com.example.spotify.util;

import com.example.spotify.model.entity.Song;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Set;

@Component
@SessionScope
public class CurrentUser {
    private Long id;
    private String username;

    private Set<Song> playList;

    public CurrentUser() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Song> getPlayList() {
        return playList;
    }

    public void setPlayList(Set<Song> playList) {
        this.playList = playList;
    }
}
