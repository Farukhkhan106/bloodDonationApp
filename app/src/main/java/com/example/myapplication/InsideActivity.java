package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class InsideActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    private HomeFragment homeFragment = new HomeFragment();
    private DashBoardFragment dashBoardFragment = new DashBoardFragment();
    private notificationFragment notificationFragment = new notificationFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inside);

        bottomNavigationView = findViewById(R.id.bottom_nevigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            Fragment fragment = null;
            if (item.getItemId() == R.id.home) {
                fragment = homeFragment;
            } else if (item.getItemId() == R.id.dashboard) {
                fragment = dashBoardFragment;
            } else if (item.getItemId() == R.id.notifications) {
                fragment = notificationFragment;
            }



            if (fragment!= null) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, fragment);
                transaction.commit();
            }

            return true;
        });
        // Set the default fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
    }
}