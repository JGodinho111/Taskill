package com.example.taskill.data;

import java.util.List;
import java.util.Map;

public class ServiceProvider {

    public String name;
    public String username;
    public String email;
    public String password;

    public Map<String,Integer> provided_services;

    public ServiceProvider() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public ServiceProvider(String name, String username, String email,String password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password=password;
    }

    public void addService(String service, int basePrice){
        provided_services.put(service,basePrice);
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

    public Map<String,Integer> getProvided_services() {
        return provided_services;
    }

}