package com.example.gira.model.binding;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class UserRegisterBindingModel {


    private String username;
    private String email;
    private String budget;
    private String password;
    private String confirmPassword;





    public UserRegisterBindingModel() {
    }


    @NotBlank
    @Size(min = 2)
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }



    @Email
    @NotBlank
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }



    @NotBlank
    @Positive
    public String getBudget() {
        return budget;
    }
    public void setBudget(String budget) {
        this.budget = budget;
    }

    @NotBlank
    @Size(min = 2)
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }



    @NotBlank
    @Size(min = 2)
    public String getConfirmPassword() {
        return confirmPassword;
    }
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }







}
