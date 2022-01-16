package com.example.taskill.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.taskill.R;

public class AccountActivity extends AppCompatActivity {

    ImageView service_provider;
    ImageView normal_user;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        service_provider= findViewById(R.id.service_provider);
        normal_user=findViewById(R.id.normal_user);

        sp=getSharedPreferences("UserData", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor= sp.edit();

        service_provider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("type","service_provider");
                editor.commit();
                Intent intent= new Intent(AccountActivity.this,LogInActivity.class);
                startActivity(intent);


            }
        });

        normal_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("type","normal_user");
                editor.commit();
                Intent intent= new Intent(AccountActivity.this,LogInActivity.class);
                startActivity(intent);

            }
        });
    }
}