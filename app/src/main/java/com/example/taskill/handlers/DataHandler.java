package com.example.taskill.handlers;

import com.example.taskill.data.Booking;
import com.example.taskill.data.ServiceProvider;
import com.example.taskill.data.ServiceUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataHandler {

    private DatabaseReference mDatabase;


    public DataHandler(DatabaseReference mDatabase) {
        mDatabase= FirebaseDatabase.getInstance().getReference();
    }

    public void writeNewServiceUser(String userId, String name,String username, String email,String password, List<Booking> bookings) {
        ServiceUser user = new ServiceUser(name,username,email,password,bookings);
        mDatabase.child("users").child(userId).setValue(user);
    }

    public void writeNewServiceProvider(String userId, String name,String username, String email,String password, List<Booking> bookings, Map<String,Double> provided_services) {
        ServiceProvider user = new ServiceProvider(name,username,email,password,bookings,provided_services);
        mDatabase.child("users").child(userId).setValue(user);
    }

}
