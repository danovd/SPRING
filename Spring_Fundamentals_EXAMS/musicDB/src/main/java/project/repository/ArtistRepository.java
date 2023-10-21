package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.model.entity.Artist;
import project.model.entity.enums.ArtistNameEnum;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, String> {
    Artist findByName(ArtistNameEnum artist);
}
