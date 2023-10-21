package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.model.entity.Album;

import java.math.BigDecimal;

@Repository
public interface AlbumRepository extends JpaRepository<Album, String> {

    @Query("SELECT SUM(a.copies) FROM Album a")
    BigDecimal findAllCopies();
}
