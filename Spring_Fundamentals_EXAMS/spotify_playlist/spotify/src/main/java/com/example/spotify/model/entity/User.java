package com.example.spotify.model.entity;

import jakarta.persistence.*;


import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity{


    private String username;
    private String password;
    private String email;
    private Set<Song> playlist;



    public User() {
    }


    @Column(unique = true, nullable = false)
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }



    @Column(nullable = false)
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }



    @Column(unique = true, nullable = false)
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }



    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    @JoinTable(name = "users_songs")
    public Set<Song> getPlaylist() {
        return playlist;
    }
    public void setPlaylist(Set<Song> playlist) {
        this.playlist = playlist;
    }

/*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, email);
    }
*/


    public void addSong(Song song){
        this.playlist.add(song);
    }
}
