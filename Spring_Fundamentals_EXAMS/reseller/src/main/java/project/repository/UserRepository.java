package project.repository;

import org.springframework.data.jpa.repository.Query;
import project.model.entity.Offer;
import project.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUsernameAndPassword(String username, String password);
    @Query("SELECT u.offers FROM User u WHERE u.id = :id")
    Set<Offer> findAllByUserId(String id);


    List<User> findAllByIdIsNot(String id);

    Optional<User> findUserByOffers_Id(String offerId);
}
