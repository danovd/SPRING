package com.example.spotify.repository;

import com.example.spotify.model.entity.Song;
import com.example.spotify.model.entity.Style;
import com.example.spotify.model.entity.enums.StyleNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface StyleRepository extends JpaRepository<Style, Long > {

    Style findByStyleName(StyleNameEnum style);


}
