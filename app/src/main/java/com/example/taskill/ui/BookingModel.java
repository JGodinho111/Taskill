package com.example.taskill.ui;

import com.example.taskill.data.BookingStatus;

import java.util.Map;

public class BookingModel {

    private String address;
    private String dateAndTime;
    private int price;
    private String service;
    private String serviceProvider;
    private String serviceRequester;
    private BookingStatus status;

    private BookingModel(){}

    private BookingModel(String address, String dateAndTime, int price,String service, String serviceProvider, String serviceRequester, BookingStatus status){
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
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

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }


}
