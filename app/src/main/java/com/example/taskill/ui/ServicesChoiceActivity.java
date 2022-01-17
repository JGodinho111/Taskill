package com.example.taskill.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.taskill.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServicesChoiceActivity extends AppCompatActivity {

    FirebaseDatabase rootNode;
    DatabaseReference serviceProvidersReference;

    CheckBox c_babysitting,c_dogwalking,c_plumber,c_lawncare,c_locksmith,c_cleaning,c_electrician,c_carpenter;
    EditText e_babysitting,e_dogwalking,e_plumber,e_lawncare,e_locksmith,e_cleaning,e_electrician,e_carpenter;
    Button confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services_choice);


        c_babysitting=findViewById(R.id.checkBox_babysitting);
        c_dogwalking= findViewById(R.id.checkBox_babysitting);
        c_lawncare=findViewById(R.id.checkBox_babysitting);
        c_locksmith=findViewById(R.id.checkBox_babysitting);
        c_plumber=findViewById(R.id.checkBox_babysitting);
        c_cleaning=findViewById(R.id.checkBox_babysitting);
        c_electrician=findViewById(R.id.checkBox_babysitting);
        c_carpenter=findViewById(R.id.checkBox_babysitting);

        e_babysitting=findViewById(R.id.input_babysitting);
        e_dogwalking=findViewById(R.id.input_dogwalking);
        e_plumber=findViewById(R.id.input_plumber);
        e_lawncare=findViewById(R.id.input_lawncare);
        e_locksmith=findViewById(R.id.input_locksmith);
        e_cleaning=findViewById(R.id.input_cleaning);
        e_electrician=findViewById(R.id.input_electrician);
        e_carpenter=findViewById(R.id.input_carpenter);

        confirm= findViewById(R.id.button_confirm);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendServicesToFirebase();
                Intent intent= new Intent(ServicesChoiceActivity.this,MainActivityBot.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });




    }

    private void sendServicesToFirebase() {
        Map<String,Double> servicesProvided= new HashMap<>();

        if(c_babysitting.isChecked())
            servicesProvided.put("babysitting",Double.parseDouble(e_babysitting.getText().toString()));


        if(c_dogwalking.isChecked())
            servicesProvided.put("dogwalking",Double.parseDouble(e_dogwalking.getText().toString()));


        if(c_lawncare.isChecked())
            servicesProvided.put("lawncare",Double.parseDouble(e_lawncare.getText().toString()));

        if(c_locksmith.isChecked())
            servicesProvided.put("locksmith",Double.parseDouble(e_locksmith.getText().toString()));


        if(c_plumber.isChecked())
            servicesProvided.put("plumber",Double.parseDouble(e_plumber.getText().toString()));


        if(c_cleaning.isChecked())
            servicesProvided.put("cleaning",Double.parseDouble(e_cleaning.getText().toString()));


        if(c_electrician.isChecked())
            servicesProvided.put("electrician",Double.parseDouble(e_electrician.getText().toString()));


        if(c_carpenter.isChecked())
            servicesProvided.put("carpenter",Double.parseDouble(e_carpenter.getText().toString()));



    }
}