package com.example.spotify.service.impl;

import com.example.spotify.model.entity.Song;
import com.example.spotify.model.entity.User;
import com.example.spotify.model.entity.enums.StyleNameEnum;
import com.example.spotify.model.service.SongServiceModel;
import com.example.spotify.repository.SongRepository;
import com.example.spotify.repository.StyleRepository;
import com.example.spotify.repository.UserRepository;
import com.example.spotify.service.SongService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;
    private final ModelMapper modelMapper;
    private final StyleRepository styleRepository;
    private final UserRepository userRepository;

    public SongServiceImpl(SongRepository songRepository, ModelMapper modelMapper, StyleRepository styleRepository, UserRepository userRepository) {
        this.songRepository = songRepository;
        this.modelMapper = modelMapper;
        this.styleRepository = styleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void add(SongServiceModel songServiceModel) {
        Song song = modelMapper.map(songServiceModel, Song.class);
        song.setStyle(styleRepository.findByStyleName(songServiceModel.getStyle()));
        songRepository.save(song);
    }

    @Override
    public Set<Song> getSongsByStyle(StyleNameEnum styleNameEnum) {
        return songRepository.findAllByStyle_StyleName(styleNameEnum);
    }

    @Override
    public void addSong(Long songId, Long userId) {
        Song song = songRepository.findById(songId).orElse(null);
        User user = userRepository.findById(userId).orElse(null);

        if(song != null && user != null){
            user.addSong(song);
            userRepository.save(user);
        }
    }


}
