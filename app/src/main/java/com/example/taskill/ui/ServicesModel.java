package com.example.taskill.ui;

public class ServicesModel {

    private String name;
    private String email;
    //private String services;

    private ServicesModel(){}

    private ServicesModel(String name, String email){
        this.name = name;
        this.email = email;
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
/*
    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }
 */
}
