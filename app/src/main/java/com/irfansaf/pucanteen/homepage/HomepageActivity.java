package com.irfansaf.pucanteen.homepage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.irfansaf.pucanteen.R;

public class HomepageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.action_home) {
                loadFragment(new HomeFragment());
                return true;
            } else if (item.getItemId() == R.id.action_history) {
                loadFragment(new HistoryFragment());
                return true;
            } else if (item.getItemId() == R.id.action_menu) {
                loadFragment(new RestoFragment());
                return true;
            } else if (item.getItemId() == R.id.action_profile) {
                loadFragment(new ProfileFragment());
                return true;
            }
            return false;
        });

        loadFragment(new HomeFragment());
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragmentContainer, fragment);
        transaction.commit();
    }
}