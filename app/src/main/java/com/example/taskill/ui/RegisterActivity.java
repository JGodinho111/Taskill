package com.example.taskill.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.taskill.R;
import com.example.taskill.data.Booking;
import com.example.taskill.data.ServiceProvider;
import com.example.taskill.data.ServiceUser;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    EditText inputEmail;
    EditText inputPassword;
    EditText inputConfirmPassword;
    Button b;

    String emailPattern= "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    String usernamePattern = "^[a-zA-Z0-9._-]{3,}$";
    ProgressDialog progressDialog;

    FirebaseAuth mAuth;
    //FirebaseUser mUser;

    FirebaseDatabase rootNode;
    DatabaseReference serviceUsersReference;
    DatabaseReference serviceProvidersReference;
    EditText inputName;
    EditText inputUsername;

    SharedPreferences sp;
    String userType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        inputName=findViewById(R.id.register_name);
        inputUsername=findViewById(R.id.register_username);
        inputEmail=findViewById(R.id.register_email);
        inputPassword=findViewById(R.id.register_pasword);
        inputConfirmPassword=findViewById(R.id.register_confirmPassword);
        progressDialog= new ProgressDialog(this);
        mAuth= FirebaseAuth.getInstance();
        //mUser= mAuth.getCurrentUser();

        sp= getApplicationContext().getSharedPreferences("UserData", Context.MODE_PRIVATE);
        userType= sp.getString("type","");

        b = (Button)findViewById(R.id.buttonRegister);
        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                PerformAuth();
                //SendDataToFirebase();


            }
        });

        TextView goToLogin = (TextView) findViewById(R.id.textViewGoToLogIn);
        goToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this,LogInActivity.class));
            }
        });
    }

    private void SendDataToFirebase() {

        rootNode=FirebaseDatabase.getInstance();
        serviceProvidersReference =rootNode.getReference("serviceProviders");
        serviceUsersReference =rootNode.getReference("serviceUsers");

        String name= inputName.getText().toString();
        String username = inputUsername.getText().toString();
        String emailAndUsername=inputEmail.getText().toString();
        String password=inputPassword.getText().toString();


        if(userType.equals("service_provider")){
            List<Booking> bookings= new ArrayList<>();
            Map<String,Integer> services_provided=new HashMap<>();

            bookings.add(new Booking("","","","","",0));

            services_provided.put("teste",0);

            ServiceProvider newProvider= new ServiceProvider(name,username,emailAndUsername,password,bookings,services_provided);
            serviceProvidersReference.child(mAuth.getCurrentUser().getUid()).setValue(newProvider);
        }

        else{
            List<Booking> bookings= new ArrayList<>();
            bookings.add(new Booking("","","","","",0));
            ServiceUser newUser= new ServiceUser(name,username,emailAndUsername,password,bookings);
            serviceUsersReference.child(mAuth.getCurrentUser().getUid()).setValue(newUser);
        }
    }

    private void PerformAuth() {
        String name= inputName.getText().toString();
        String username = inputUsername.getText().toString();
        String email=inputEmail.getText().toString();
        String password=inputPassword.getText().toString();
        String confirmPassword=inputConfirmPassword.getText().toString();
        rootNode=FirebaseDatabase.getInstance();
        serviceUsersReference =rootNode.getReference("serviceUsers");
        Query checkUsername = serviceUsersReference.orderByChild("username").equalTo(username);

        checkUsername.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    inputUsername.setError("This username already exists!");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        if(name.isEmpty()){
            inputName.setError("Insert valid Name!");
        }
        if(!email.matches(emailPattern)){
            inputEmail.setError("Enter a valid Email!");
        }else if(password.isEmpty() || password.length()<6){
            inputPassword.setError("Enter valid password!");

        }else if(!username.matches(usernamePattern)){
            inputUsername.setError("Invalid Username");
        }else if(!password.equals(confirmPassword)){
            inputConfirmPassword.setError("Passwords not match!");
        }else{
            progressDialog.setMessage("Registration in progress... Please Wait!");
            progressDialog.setTitle("Registration");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();
            SharedPreferences.Editor editor= sp.edit();
            editor.putString("user", username);
            editor.putString("password", password);
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        progressDialog.dismiss();
                        Toast.makeText(RegisterActivity.this,"Registration Successful", Toast.LENGTH_SHORT).show();

                        SendDataToFirebase();
                        sendUserToNextActivity();

                    }else{
                        progressDialog.dismiss();
                        Toast.makeText(RegisterActivity.this,""+task.getException(),Toast.LENGTH_SHORT).show();

                    }
                }
            });

        }

    }

    private void sendUserToNextActivity() {
        if(userType.equals("service_provider")){
            Intent intent= new Intent(RegisterActivity.this,ServicesChoiceActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        else{
            Intent intent= new Intent(RegisterActivity.this,MainActivityBot.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }

    }


}