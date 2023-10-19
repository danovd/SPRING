package com.example.gira.model.service;

public class UserServiceModel {

    private String id;
    private String username;
    private String password;
    private String email;
    private Integer budget;


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



    public Integer getBudget() {
        return budget;
    }
    public void setBudget(Integer budget) {
        this.budget = budget;
    }
}
