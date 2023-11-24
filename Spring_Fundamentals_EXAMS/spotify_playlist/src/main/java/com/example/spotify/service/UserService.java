package com.example.spotify.service;

import com.example.spotify.model.entity.Song;
import com.example.spotify.model.entity.User;
import com.example.spotify.model.service.UserServiceModel;

import java.util.Set;

public interface UserService {
    void registerUser(UserServiceModel map);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);

    void logout();

    Set<Song> findSongsOfUserByUserId(Long id);

    User findUserById(Long id);

    void removeSongs();
}
