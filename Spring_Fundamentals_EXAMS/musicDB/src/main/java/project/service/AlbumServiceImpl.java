package project.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import project.model.entity.Album;
import project.model.entity.Artist;
import project.model.entity.User;
import project.model.service.AlbumServiceModel;
import project.repository.AlbumRepository;
import project.repository.ArtistRepository;
import project.repository.UserRepository;
import project.util.CurrentUser;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;
    private final ModelMapper modelMapper;
    private final ArtistRepository artistRepository;
    private final UserRepository userRepository;
    private final CurrentUser currentUser;

    public AlbumServiceImpl(AlbumRepository albumRepository, ModelMapper modelMapper, ArtistRepository artistRepository, UserRepository userRepository, CurrentUser currentUser) {
        this.albumRepository = albumRepository;
        this.modelMapper = modelMapper;
        this.artistRepository = artistRepository;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }


    @Override
    public void add(AlbumServiceModel albumServiceModel) {
        Album album = modelMapper.map(albumServiceModel, Album.class);

        System.out.println(albumServiceModel.getArtist()  + "   SERVICE");
        Artist artist = artistRepository.findByName(albumServiceModel.getArtist());
        album.setArtist(artist);

        User creator = userRepository.findById(currentUser.getId()).orElse(null);
        album.setAddedFrom(creator);

        albumRepository.save(album);
    }

    @Override
    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    @Override
    public void deleteById(String id) {
        albumRepository.deleteById(id);
    }

    @Override
    public BigDecimal getNumberOfAllCopies() {
        return albumRepository.findAllCopies();
    }
}
