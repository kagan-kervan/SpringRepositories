package com.example.AuthUserService;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Collection;

@Entity
public class User{

    @Id @GeneratedValue Long id;
    String username;
    String name;
    String password;
    String role;



    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getRole(){
        return role;
    }
    public String getName(){
        return name;
    }
    public Long getId(){
        return id;
    }

}
