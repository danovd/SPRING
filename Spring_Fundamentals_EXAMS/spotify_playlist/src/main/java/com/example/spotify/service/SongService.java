package com.example.spotify.service;

import com.example.spotify.model.entity.Song;
import com.example.spotify.model.entity.enums.StyleNameEnum;
import com.example.spotify.model.service.SongServiceModel;

import java.util.Set;

public interface SongService {
    void add(SongServiceModel map);

    Set<Song> getSongsByStyle(StyleNameEnum styleNameEnum);

    void addSong(Long id, Long userId);


}
