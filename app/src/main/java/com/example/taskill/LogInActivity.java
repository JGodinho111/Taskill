package com.example.taskill;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LogInActivity extends AppCompatActivity {

    EditText inputEmail;
    EditText inputPassword;
    EditText inputConfirmPassword;
    Button b;

    String emailPattern= "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    ProgressDialog progressDialog;

    FirebaseAuth mAuth;
    FirebaseUser mUser;

    @SuppressLint({"ResourceAsColor", "Range"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#20232A"));

        inputEmail=findViewById(R.id.inputEmail);
        inputPassword=findViewById(R.id.inputPassword);
        progressDialog= new ProgressDialog(this);
        mAuth= FirebaseAuth.getInstance();
        mUser= mAuth.getCurrentUser();

        b = (Button)findViewById(R.id.buttonLogIn);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performLogin();
                //startActivity(new Intent(LogInActivity.this,MainActivityBot.class));
                //startActivity(new Intent(LogInActivity.this,MainActivity.class));
            }
        });

        TextView goToRegister = (TextView) findViewById(R.id.textViewGoToRegister);
        goToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LogInActivity.this,RegisterActivity.class));
            }
        });
    }

    private void performLogin() {
        String email = inputEmail.getText().toString();
        String password = inputPassword.getText().toString();

        if (!email.matches(emailPattern)) {
            inputEmail.setError("Enter a valid Email!");
        } else if (password.isEmpty() || password.length() < 6) {
            inputPassword.setError("Enter valid password!");
        } else {
            progressDialog.setMessage("Login in progress... Please Wait!");
            progressDialog.setTitle("Login");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        progressDialog.dismiss();
                        sendUserToNextActivity();
                        Toast.makeText(LogInActivity.this,"Login Successful!", Toast.LENGTH_SHORT).show();
                    }else{
                        progressDialog.dismiss();
                        Toast.makeText(LogInActivity.this,""+task.getException(),Toast.LENGTH_SHORT).show();

                    }
                }
            });

        }
    }

    private void sendUserToNextActivity() {
        Intent intent= new Intent(LogInActivity.this,MainActivityBot.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}