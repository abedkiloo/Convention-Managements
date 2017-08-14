package com.example.abednego.mwingiregistration.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.abednego.mwingiregistration.R;
import com.example.abednego.mwingiregistration.fragments.Register;
import com.example.abednego.mwingiregistration.fragments.RegisteredList;

public class LandingActivity extends AppCompatActivity {


    private FragmentManager fragmentManager;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragmentManager.beginTransaction().replace(R.id.content, new Register()).commit();
                    return true;
                case R.id.navigation_dashboard:
                    fragmentManager.beginTransaction().replace(R.id.content, new RegisteredList()).commit();
//                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
//                case R.id.navigation_notifications:
//                    mTextMessage.setText(R.string.title_notifications);
//                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);


//        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        Menu menu = navigation.getMenu();
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content, new RegisteredList()).commit();
        menu.findItem(R.id.navigation_dashboard).setIcon(R.drawable.ic_dashboard_black_24dp);


    }

}
