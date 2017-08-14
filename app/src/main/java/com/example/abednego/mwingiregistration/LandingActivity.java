package com.example.abednego.mwingiregistration;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class LandingActivity extends AppCompatActivity {


    private FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        fragmentManager=getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content,new Register()).commit();

//        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:

                    fragmentManager.beginTransaction().replace(R.id.content,new Register()).commit();
                    return true;
                case R.id.navigation_dashboard:
                    fragmentManager.beginTransaction().replace(R.id.content,new RegisteredList()).commit();
//                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
//                case R.id.navigation_notifications:
//                    mTextMessage.setText(R.string.title_notifications);
//                    return true;
            }
            return false;
        }

    };

}
