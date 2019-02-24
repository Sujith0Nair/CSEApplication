package com.example.ajith.cseapplication;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class BottomNavigationViewHelper{
    private static final String TAG = "BottomNavigationViewHel";

    public static void setupBottomNavigationView(BottomNavigationViewEx bottomNavigationViewEx){
        Log.d(TAG, "setupBottomNavigationView: Setting up NavBar Bottom");
    }

    public static void enableNavigation(final Context con, BottomNavigationViewEx view){
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.ic_house:
                        Intent ione= new Intent(con, HomeActivity.class);
                        ione.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        con.startActivity(ione);
                        break;
                    case R.id.ic_notifications:
                        Intent itwo= new Intent(con, ImagesActivity.class);
                        itwo.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        con.startActivity(itwo);
                        break;
                    case R.id.ic_profile:
                        Intent ithree= new Intent(con, ProfileActivity.class);
                        ithree.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        con.startActivity(ithree);
                        break;
                }
                return false;
            }
        });
    }
}


