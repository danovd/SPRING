package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.model.entity.Offer;

@Repository
public interface OfferRepository extends JpaRepository<Offer, String> {
}
