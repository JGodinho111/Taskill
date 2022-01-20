package com.example.taskill.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.taskill.R;
import com.example.taskill.ui.home.ProviderHomeActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class ServicesChoiceActivity extends AppCompatActivity {

    FirebaseDatabase rootNode;
    DatabaseReference serviceProvidersReference;

    FirebaseAuth mAuth;

    CheckBox c_babysitting,c_dogwalking,c_plumber,c_lawncare,c_locksmith,c_cleaning,c_electrician,c_carpenter;
    EditText e_babysitting,e_dogwalking,e_plumber,e_lawncare,e_locksmith,e_cleaning,e_electrician,e_carpenter;
    Button confirm;

    Map<String,Integer> servicesProvided;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services_choice);


        c_babysitting=findViewById(R.id.checkBox_babysitting);
        c_dogwalking= findViewById(R.id.checkBox_dogwalking);
        c_lawncare=findViewById(R.id.checkBox_lawncare);
        c_locksmith=findViewById(R.id.checkBox_locksmith);
        c_plumber=findViewById(R.id.checkBox_plumber);
        c_cleaning=findViewById(R.id.checkBox_cleaning);
        c_electrician=findViewById(R.id.checkBox_electrician);
        c_carpenter=findViewById(R.id.checkBox_carpenter);

        e_babysitting=findViewById(R.id.input_babysitting);
        e_dogwalking=findViewById(R.id.input_dogwalking);
        e_plumber=findViewById(R.id.input_plumber);
        e_lawncare=findViewById(R.id.input_lawncare);
        e_locksmith=findViewById(R.id.input_locksmith);
        e_cleaning=findViewById(R.id.input_cleaning);
        e_electrician=findViewById(R.id.input_electrician);
        e_carpenter=findViewById(R.id.input_carpenter);

        confirm= findViewById(R.id.sc_button);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendServicesToFirebase();
                Intent intent= new Intent(ServicesChoiceActivity.this, ProviderHomeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });


    }

    private void sendServicesToFirebase() {

         servicesProvided= new HashMap<>();

         verifyCheckboxesAndInputs(servicesProvided);

         rootNode=FirebaseDatabase.getInstance();
         serviceProvidersReference =rootNode.getReference("serviceProviders");
         mAuth= FirebaseAuth.getInstance();
         String currentUserId = mAuth.getCurrentUser().getUid();

         serviceProvidersReference.child(currentUserId).child("provided_services").setValue(servicesProvided);

    }

    private void verifyCheckboxesAndInputs(Map<String, Integer> servicesProvided) {

        if(c_babysitting.isChecked() && !e_babysitting.getText().toString().equals("")){
            servicesProvided.put("babysitting",Integer.parseInt(e_babysitting.getText().toString()));
        }

        if(c_dogwalking.isChecked() && !e_dogwalking.getText().toString().equals("")){
            servicesProvided.put("dogwalking",Integer.parseInt(e_dogwalking.getText().toString()));
        }

        if(c_lawncare.isChecked() && !e_lawncare.getText().toString().equals("")){
            servicesProvided.put("lawncare",Integer.parseInt(e_lawncare.getText().toString()));
        }
        if(c_locksmith.isChecked() && !e_locksmith.getText().toString().equals("")){
            servicesProvided.put("locksmith",Integer.parseInt(e_locksmith.getText().toString()));
        }

        if(c_plumber.isChecked() && !e_plumber.getText().toString().equals("")){
            servicesProvided.put("plumber",Integer.parseInt(e_plumber.getText().toString()));
        }

        if(c_cleaning.isChecked() && !e_cleaning.getText().toString().equals("")){
            servicesProvided.put("cleaning",Integer.parseInt(e_cleaning.getText().toString()));
        }

        if(c_electrician.isChecked() && !e_electrician.getText().toString().equals("")){
            servicesProvided.put("electrician",Integer.parseInt(e_electrician.getText().toString()));
        }

        if(c_carpenter.isChecked() && !e_carpenter.getText().toString().equals("")){
            servicesProvided.put("carpenter",Integer.parseInt(e_carpenter.getText().toString()));
        }
    }
}