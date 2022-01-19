package com.example.taskill.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import com.example.taskill.R;
import com.example.taskill.ui.home.ServiceProviderHomeActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.taskill.databinding.ActivityMainBotBinding;

public class MainActivityBot extends AppCompatActivity {

    private ActivityMainBotBinding binding;
    public FragmentManager fragmentManager = getSupportFragmentManager();
    SharedPreferences sp;
    String userType;
    NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBotBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sp= getApplicationContext().getSharedPreferences("UserData", Context.MODE_PRIVATE);
        userType = sp.getString("type", "");

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_services ,R.id.navigation_menu, R.id.navigation_marketplace)
                .build();

        if(userType.equals("service_provider")) {
            Intent intent = new Intent(MainActivityBot.this, ServiceProviderHomeActivity.class);
            startActivity(intent);
        }
        else
            navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main_bot);

        //NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

}