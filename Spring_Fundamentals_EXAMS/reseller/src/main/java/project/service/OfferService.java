package project.service;

import project.model.entity.Offer;
import project.model.service.OfferServiceModel;

import java.util.List;
import java.util.Set;

public interface OfferService {
    void add(OfferServiceModel map);

    List<Offer> getAllOffers();

    Set<Offer> getOwnOffers();

    void deleteById(String id);

    Set<Offer> getBoughtOffers();

    Offer findById(String id);


    void buyOfferWithId(String id, String id1);
}
