package project.model.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="users")
public class User extends BaseEntity{

private String username;
private String password;
private String email;
private Set<Offer> offers;
private Set<Offer> boughtOffers;




    public User() {
      //  offers = new HashSet<>();
     //   boughtOffers = new HashSet<>();
    }





    @Column(unique = true, nullable = false)
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }



    @Column(nullable = false)
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }


    @Column(nullable = false, unique = true)
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }



    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "offers")
    public Set<Offer> getOffers() {
        return offers;
    }
    public void setOffers(Set<Offer> offers) {
        this.offers = offers;
    }






    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "bought_offers")
    public Set<Offer> getBoughtOffers() {
        return boughtOffers;
    }
    public void setBoughtOffers(Set<Offer> boughtOffers) {
        this.boughtOffers = boughtOffers;
    }
}
