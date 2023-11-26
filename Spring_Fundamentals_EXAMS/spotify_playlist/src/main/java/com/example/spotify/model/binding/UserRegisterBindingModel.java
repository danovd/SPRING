package com.example.spotify.model.binding;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRegisterBindingModel {


    private String username;
    private String email;
    private String password;
    private String confirmPassword;




    public UserRegisterBindingModel() {
    }



    @Size(min = 3, message = "hmm... It looks like the username is too short")
    @Size(max=20, message = "Oh! Username is too LONG, friend! Shorten it!")
    @NotBlank
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }



    @NotBlank
    @Email
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }



    @Size(min = 3, max = 20)
    @NotBlank
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }



    @Size(min = 3, max = 20)
    @NotBlank
    public String getConfirmPassword() {
        return confirmPassword;
    }
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }


}
