package com.dnteam.medkit.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.widget.Toast;

import com.dnteam.medkit.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import static androidx.navigation.Navigation.findNavController;
import static androidx.navigation.ui.NavigationUI.setupActionBarWithNavController;

public class HomeActivity extends AppCompatActivity {

    private BottomNavigationView homeNavigation;
    private NavController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setUpNavigation();

        homeNavigation.setOnNavigationItemSelectedListener(item -> {
                    int id = item.getItemId();
                    switch (id) {
                        case R.id.search: {
                            controller.navigate(R.id.search_fragment);
                            break;
                        }
                        case R.id.offers: {
                            controller.navigate(R.id.offers_fragment);
                            break;
                        }
                        case R.id.pharmacy: {
                            controller.navigate(R.id.pharmacy_fragment);
                            break;
                        }

                        case R.id.schedule: {
                            controller.navigate(R.id.schedule_fragment);
                            break;
                        }

                        case R.id.more: {
                            controller.navigate(R.id.more_fragment);
                            break;
                        }
                    }
                    return true;
                }
        );

    }

    public void setUpNavigation() {
        homeNavigation = findViewById(R.id.bottom_nav);
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(homeNavigation,
                navHostFragment.getNavController());

        controller = navHostFragment.getNavController();
    }
}