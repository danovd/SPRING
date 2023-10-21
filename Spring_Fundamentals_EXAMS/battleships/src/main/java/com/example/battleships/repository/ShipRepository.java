package com.example.battleships.repository;

import com.example.battleships.model.entity.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface ShipRepository extends JpaRepository<Ship, String> {
    @Query("SELECT s FROM Ship s WHERE s.user.id = :id")
    Set<Ship> getAllOwnShips(String id);

    @Query("SELECT s FROM Ship s WHERE s.user.id <> :id")
    Set<Ship> getAllOtherShips(String id);

    @Query("SELECT s FROM Ship s ORDER BY s.name, s.health, s.power")
    List<Ship> findAllOrderByNameAndHealthAndPower();

    Optional<Ship> findByName(String name);
}
