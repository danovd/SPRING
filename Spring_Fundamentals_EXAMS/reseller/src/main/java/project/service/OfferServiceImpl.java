package project.service;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import project.model.entity.Offer;
import project.model.entity.User;
import project.model.service.OfferServiceModel;
import project.repository.ConditionRepository;
import project.repository.OfferRepository;
import project.repository.UserRepository;
import project.util.CurrentUser;

import java.util.List;
import java.util.Set;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;
    private final ConditionRepository conditionRepository;
    private final UserRepository userRepository;
    private CurrentUser currentUser;

    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper, ConditionRepository conditionRepository, UserRepository userRepository, CurrentUser currentUser) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
        this.conditionRepository = conditionRepository;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }


    @Override
    @Transactional
    public void add(OfferServiceModel offerServiceModel) {
        Offer offer = modelMapper.map(offerServiceModel, Offer.class);
        offer.setCondition(conditionRepository.findByConditionName(offerServiceModel.getCondition()));

        String id = currentUser.getId();
        User currentUser = userRepository.findById(id).orElse(null);

        offerRepository.save(offer);
        currentUser.getOffers().add(offer);
        userRepository.save(currentUser);

 //       offer.setUser(currentUser);
 //       offerRepository.save(offer);
    }

    @Override
    public List<Offer> getAllOffers() {
        return offerRepository.findAll();
    }

    @Override
    public Set<Offer> getOwnOffers() {
        String id = currentUser.getId();

        return userRepository.findAllByUserId(id);
    }

    @Override
    public void deleteById(String id) {
        offerRepository.deleteById(id);
    }

    @Override
    public Set<Offer> getBoughtOffers() {
        String id = currentUser.getId();
        User currentUser = userRepository.findById(id).orElse(null);
        return currentUser.getBoughtOffers();
    }

    @Override
    public Offer findById(String id) {

        return offerRepository.findById(id).orElse(null);
    }

    @Override
    public void buyOfferWithId(String offerId, String userBuyerId) {

        User userBuyer = userRepository.findById(userBuyerId).orElse(null);
        User seller = userRepository.findUserByOffers_Id(offerId).orElse(null);

        Offer offerItem = seller.getOffers().stream().filter(e -> e.getId().equals(offerId)).findFirst().orElse(null);
        boolean remove = seller.getOffers().remove(offerItem);

        boolean add = userBuyer.getBoughtOffers().add(offerItem);

        userRepository.save(seller);
        userRepository.save(userBuyer);
    }


}
