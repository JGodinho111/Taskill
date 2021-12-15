package com.example.taskill;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBotBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_menu, R.id.navigation_services, R.id.navigation_marketplace, R.id.navigation_profile, R.id.navigation_settings)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main_bot);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

    /*
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        FragmentManager fm = fragmentManager;
        switch (item.getItemId()) {
            case R.id.main_page:
                return true;
            case R.id.menu_main:
                Fragment fragment = new MenuFragment();
                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.menu,fragment);
                transaction.addToBackStack(null);
                transaction.commit();
                return true;
            case R.id.services:
                Fragment fragmentS = new ServicesFragment();
                FragmentTransaction transactionS = fm.beginTransaction();
                transactionS.replace(R.id.menu,fragmentS);
                transactionS.addToBackStack(null);
                transactionS.commit();
                return true;
            case R.id.marketplace:
                Fragment fragmentM = new MarketplaceFragment();
                FragmentTransaction transactionM = fm.beginTransaction();
                transactionM.replace(R.id.menu,fragmentM);
                transactionM.addToBackStack(null);
                transactionM.commit();
                return true;
            case R.id.settings:
                Fragment fragmentSt = new SettingsFragment();
                FragmentTransaction transactionSt = fm.beginTransaction();
                transactionSt.replace(R.id.menu,fragmentSt);
                transactionSt.addToBackStack(null);
                transactionSt.commit();
                return true;
            case R.id.profile:
                Fragment fragmentPf = new ProfileFragment();
                FragmentTransaction transactionPf = fm.beginTransaction();
                transactionPf.replace(R.id.menu,fragmentPf);
                transactionPf.addToBackStack(null);
                transactionPf.commit();
                return true;
            case R.id.help:
                Fragment fragmentH = new HelpFragment();
                FragmentTransaction transactionH = fm.beginTransaction();
                transactionH.replace(R.id.menu,fragmentH);
                transactionH.addToBackStack(null);
                transactionH.commit();
                return true;
            case R.id.SwapAccount:
                return true;
            case R.id.about:
                Fragment fragmentA = new AboutFragment();
                FragmentTransaction transactionA = fm.beginTransaction();
                transactionA.replace(R.id.menu,fragmentA);
                transactionA.addToBackStack(null);
                transactionA.commit();
                return true;
            case R.id.logout:
                startActivity(new Intent(MainActivityBot.this,LogInActivity.class));
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
    */

}