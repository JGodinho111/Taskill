package com.example.taskill.ui.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.taskill.R;
import com.example.taskill.ui.LogInActivity;
import com.example.taskill.ui.MainActivityBot;
import com.example.taskill.ui.UserBookingsActivity;
import com.example.taskill.ui.marketplace.MarketplaceFragment;

public class ProviderHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider_home);

        LinearLayout home= findViewById(R.id.provider_nav_home);
        LinearLayout marketplace= findViewById(R.id.provider_nav_marketplace);
        LinearLayout bookings=findViewById(R.id.provider_nav_bookings);
        ImageView profile= findViewById(R.id.pprofile_button);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProviderHomeActivity.this, ProviderHomeActivity.class);
                startActivity(intent);

            }
        });

        marketplace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Fragment replacementFragment = new MarketplaceFragment();
//                getSupportFragmentManager().beginTransaction().replace(R.id.,replacementFragment).addToBackStack(null).commit();
//

            }
        });

        bookings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProviderHomeActivity.this, UserBookingsActivity.class);
                startActivity(intent);
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}