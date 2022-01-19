package com.example.taskill.ui;

import java.util.Map;

public class BookingModel {

    private String address;
    private String dateAndTime;
    private String price;
    private String service;
    private String serviceProvider;
    private String serviceRequester;
    private String status;

    private BookingModel(){}

    private BookingModel(String address, String dateAndTime, String price,String service,String serviceProvider,String serviceRequester,String status){
        this.address = address;
        this.dateAndTime = dateAndTime;
        this.price = price;
        this.service = service;
        this.serviceProvider = serviceProvider;
        this.serviceRequester = serviceRequester;
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(String serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    public String getServiceRequester() {
        return serviceRequester;
    }

    public void setServiceRequester(String serviceRequester) {
        this.serviceRequester = serviceRequester;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
