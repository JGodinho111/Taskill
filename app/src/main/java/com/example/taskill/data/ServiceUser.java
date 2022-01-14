package com.example.taskill.data;

import java.util.List;

public class ServiceUser {

    public String name;
    public String username;
    public String email;
    public String password;

    public ServiceUser() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public ServiceUser(String name, String username, String email, String password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password=password;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }


}
