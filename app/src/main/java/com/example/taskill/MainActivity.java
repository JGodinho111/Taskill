package com.example.taskill;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    public FragmentManager fragmentManager = getSupportFragmentManager();
    //NavigationView navigationView;
    //Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().getDecorView().setBackgroundColor(Color.parseColor("#20232A"));
        //navigationView = findViewById(R.id.nav_view);
        //toolbar = findViewById(R.id.toolbarForApp);
        
        //setSupportActionBar(toolbar);
    }

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
                startActivity(new Intent(MainActivity.this,LogInActivity.class));
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        View view = this.getWindow().getDecorView();
        // Handle item selection
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
                startActivity(new Intent(MainActivity.this,LogInActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}