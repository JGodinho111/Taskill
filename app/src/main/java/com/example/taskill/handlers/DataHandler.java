package com.example.taskill.handlers;

import com.example.taskill.data.ServiceProvider;
import com.example.taskill.data.ServiceUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DataHandler {

    private DatabaseReference mDatabase;


    public DataHandler(DatabaseReference mDatabase) {
        mDatabase= FirebaseDatabase.getInstance().getReference();
    }

    public void writeNewServiceUser(String userId, String name,String username, String email,String password) {
        ServiceUser user = new ServiceUser(name,username,email,password);
        mDatabase.child("users").child(userId).setValue(user);
    }

    public void writeNewServiceProvider(String userId, String name,String username, String email,String password) {
        ServiceProvider user = new ServiceProvider(name,username,email,password);
        mDatabase.child("users").child(userId).setValue(user);
    }

}
