package project.model.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="users")
public class User extends BaseEntity{

private String username;
private String password;
private String email;
private Set<Word> addedWords;




    public User() {
    }





    @Column(nullable = false, unique = true)
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

    @Column(unique = true, nullable = false)
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    @JoinTable(name = "users_words")
    public Set<Word> getAddedWords() {
        return addedWords;
    }
    public void setAddedWords(Set<Word> addedWords) {
        this.addedWords = addedWords;
    }
}
