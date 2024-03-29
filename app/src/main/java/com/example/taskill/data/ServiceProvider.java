package com.example.taskill.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceProvider implements DatabaseReference.CompletionListener {

    public String name;
    public String username;
    public String email;
    public String password;
    public List<Booking> bookings;
    public Map<String,Integer> provided_services;

    public ServiceProvider() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public ServiceProvider(String name, String username, String email, String password, List<Booking> bookings, Map<String,Integer> provided_services) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password=password;
        this.bookings=bookings;
        this.provided_services=provided_services;
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

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public void addBooking(Booking booking){
        bookings.add(booking);
    }

    @Override
    public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {

    }
}
