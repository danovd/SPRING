package com.example.spotify.repository;

import com.example.spotify.model.entity.Song;
import com.example.spotify.model.entity.enums.StyleNameEnum;
import com.example.spotify.model.service.SongServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
    Set<Song> findAllByStyle_StyleName(StyleNameEnum s);


}
