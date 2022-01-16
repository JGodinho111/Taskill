package com.example.taskill.data;

import java.util.ArrayList;
import java.util.List;

public class ServiceUser {

    public String name;
    public String username;
    public String email;
    public String password;
    public List<Booking> bookings;

    public ServiceUser() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public ServiceUser(String name, String username, String email, String password, List<Booking> bookings) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password=password;
        this.bookings=bookings;
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

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public void addBooking(Booking booking){
        bookings.add(booking);
    }

}
