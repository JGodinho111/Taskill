package com.example.taskill.ui;

import java.util.Map;

public class ServicesModel {

    private String name;
    private String email;


    //private String services;
    public Map<String,Integer> provided_services;

    private ServicesModel(){}

    private ServicesModel(String name, String email, Map<String,Integer> provided_services){
        this.name = name;
        this.email = email;
        this.provided_services = provided_services;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Map<String, Integer> getProvided_services() {
        return provided_services;
    }

    public void setProvided_services(Map<String, Integer> provided_services) {
        this.provided_services = provided_services;
    }

/*
    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }
 */
}
