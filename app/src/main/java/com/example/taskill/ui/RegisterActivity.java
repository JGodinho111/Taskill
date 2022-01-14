package com.example.taskill.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.taskill.R;
import com.example.taskill.data.ServiceUser;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class RegisterActivity extends AppCompatActivity {

    EditText inputEmail;
    EditText inputPassword;
    EditText inputConfirmPassword;
    Button b;

    String emailPattern= "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    ProgressDialog progressDialog;

    FirebaseAuth mAuth;
    FirebaseUser mUser;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        inputEmail=findViewById(R.id.editTextAddEmailAddress);
        inputPassword=findViewById(R.id.editTextAddPassword);
        inputConfirmPassword=findViewById(R.id.editTextAddConfirmPassword);
        progressDialog= new ProgressDialog(this);
        mAuth= FirebaseAuth.getInstance();
        mUser= mAuth.getCurrentUser();

        b = (Button)findViewById(R.id.buttonRegister);
        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                SendDataToFirebase();
                PerformAuth();


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
        reference=rootNode.getReference("serviceUsers");

        String email=inputEmail.getText().toString();
        String password=inputPassword.getText().toString();

        String name = "First";
        String username = "firstusername";
        
        ServiceUser newUser= new ServiceUser(name,username,email,password);

        reference.child(username).setValue(newUser);

    }

    private void PerformAuth() {
        String email=inputEmail.getText().toString();
        String password=inputPassword.getText().toString();
        String confirmPassword=inputConfirmPassword.getText().toString();

        if(!email.matches(emailPattern)){
            inputEmail.setError("Enter a valid Email!");
        }else if(password.isEmpty() || password.length()<6){
            inputPassword.setError("Enter valid password!");
        }else if(!password.equals(confirmPassword)){
            inputConfirmPassword.setError("Passwords not match!");
        }else{
            progressDialog.setMessage("Registration in progress... Please Wait!");
            progressDialog.setTitle("Registration");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        progressDialog.dismiss();
                        sendUserToNextActivity();
                        Toast.makeText(RegisterActivity.this,"Registration Successful", Toast.LENGTH_SHORT).show();
                    }else{
                        progressDialog.dismiss();
                        Toast.makeText(RegisterActivity.this,""+task.getException(),Toast.LENGTH_SHORT).show();

                    }
                }
            });

        }

    }

    private void sendUserToNextActivity() {
        Intent intent= new Intent(RegisterActivity.this,MainActivityBot.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }


}