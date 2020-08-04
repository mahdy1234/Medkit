package com.dnteam.medkit.util;


import androidx.fragment.app.FragmentActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.dnteam.medkit.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class NavigationControl {
    private static NavController controller;
    private static BottomNavigationView homeNavigation;


    public static BottomNavigationView getHomePageBottomNav(FragmentActivity fragmentActivity) {
        if (homeNavigation == null) {
            homeNavigation = fragmentActivity.findViewById(R.id.bottom_nav);
        }
        return homeNavigation;

    }

    public static NavController getHomePageNavController(FragmentActivity fragmentActivity) {

        if (controller == null) {
            NavHostFragment navHostFragment = (NavHostFragment) fragmentActivity.getSupportFragmentManager()
                    .findFragmentById(R.id.nav_host_fragment);
            NavigationUI.setupWithNavController(homeNavigation,
                    navHostFragment.getNavController());

            controller = navHostFragment.getNavController();
        }

        return controller;
    }


}
