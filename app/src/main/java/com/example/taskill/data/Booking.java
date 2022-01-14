package com.example.taskill.data;

import android.location.Address;
import android.location.Location;

public class Booking {

    private String serviceProvider;
    private String serviceRequester;
    private String service;
    private String date;
    private String time;
    private BookingStatus status;
    private int price;
    private Location location;
    private Address address;

    public Booking(Address address, String serviceProvider, String serviceRequester, String service, String date, String time, int price) {
        this.address=address;
        this.serviceProvider = serviceProvider;
        this.serviceRequester = serviceRequester;
        this.service = service;
        this.date = date;
        this.time = time;
        this.price = price;
        this.status=BookingStatus.UPCOMING;
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

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
