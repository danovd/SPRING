package com.example.gira.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User extends BaseEntity{

private String username;
private String password;
private String email;





    public User() {
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
}
