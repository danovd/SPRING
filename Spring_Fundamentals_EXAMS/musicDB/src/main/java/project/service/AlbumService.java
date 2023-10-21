package project.service;

import project.model.entity.Album;
import project.model.service.AlbumServiceModel;

import java.math.BigDecimal;
import java.util.List;

public interface AlbumService {
    void add(AlbumServiceModel map);

    List<Album> getAllAlbums();

    void deleteById(String id);

    BigDecimal getNumberOfAllCopies();
}
