package com.example.gira.model.binding;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserLoginBindingModel {

    private String username;
    private String password;



    public UserLoginBindingModel() {
    }

    @NotBlank
    @Size(min = 2)
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }



    @NotBlank
    @Size(min = 2)
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
