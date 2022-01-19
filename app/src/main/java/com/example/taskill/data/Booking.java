package com.example.taskill.data;

import android.location.Address;
import android.location.Location;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

public class Booking implements DatabaseReference.CompletionListener {

    private String serviceProvider;
    private String serviceRequester;
    private String service;
    private String dateAndTime;

    private BookingStatus status;
    private int price;
    private String address;

    public Booking(String address, String serviceProvider, String serviceRequester, String service, String dateAndTime, int price) {
        this.address=address;
        this.serviceProvider = serviceProvider;
        this.serviceRequester = serviceRequester;
        this.service = service;
        this.dateAndTime = dateAndTime;
        this.price = price;
        this.status=BookingStatus.UPCOMING;
    }

    public Booking() {

    }

    public String getServiceProvider() {
        return serviceProvider;
    }

    public String getServiceRequester() {
        return serviceRequester;
    }

    public String getService() {
        return service;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {

    }
}
