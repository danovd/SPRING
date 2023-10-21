package project.model.service;

import project.model.entity.Word;

import java.util.Set;

public class UserServiceModel {

    private String id;
    private String username;
    private String password;
    private String email;
    private Set<Word> addedWords;



    public UserServiceModel() {
    }





    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }



    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }



    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Word> getAddedWords() {
        return addedWords;
    }

    public void setAddedWords(Set<Word> addedWords) {
        this.addedWords = addedWords;
    }
}
