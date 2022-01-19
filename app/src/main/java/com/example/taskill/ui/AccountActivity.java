package com.example.taskill.ui;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
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
        // Request permission for location - directly from Android Studio Website on asking for location permision
        ActivityResultLauncher<String[]> locationPermissionRequest =
                registerForActivityResult(new ActivityResultContracts
                                .RequestMultiplePermissions(), result -> {
                            Boolean fineLocationGranted = null;
                            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                                fineLocationGranted = result.getOrDefault( //will not work on API level lower than 24, project minimum is 21
                                        Manifest.permission.ACCESS_FINE_LOCATION, false);
                            }
                            Boolean coarseLocationGranted = null;
                            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                                coarseLocationGranted = result.getOrDefault( //will not work on API level lower than 24, project minimum is 21
                                        Manifest.permission.ACCESS_COARSE_LOCATION,false);
                            }
                            if (fineLocationGranted != null && fineLocationGranted) {
                                // Precise location access granted.
                            } else if (coarseLocationGranted != null && coarseLocationGranted) {
                                // Only approximate location access granted.
                            } else {
                                // No location access granted.
                            }
                        }
                );
        // Before you perform the actual permission request, check whether your app
        // already has the permissions, and whether your app needs to show a permission
        // rationale dialog. For more details, see Request permissions.
        locationPermissionRequest.launch(new String[] {
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
        });
    }
}