package com.example.battleships.service;

import com.example.battleships.model.entity.Ship;
import com.example.battleships.model.service.ShipServiceModel;

import java.util.List;
import java.util.Set;

public interface ShipService {
    void add(ShipServiceModel map);

    Set<Ship> getAllShipsOwnedByUserId(String id);

    Set<Ship> getAllOtherShipsNotOwnedByUserId(String id);

    List<Ship> getAllShips();

    Ship findByName(String name);

    void deleteById(String id);

    void attack(Ship attackShip, Ship defendShip);
}
