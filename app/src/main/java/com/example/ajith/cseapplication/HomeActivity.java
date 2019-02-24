package com.example.ajith.cseapplication;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;


public class HomeActivity extends AppCompatActivity {

    private WebView wb;
    private TextView scroll;
    private ImageView image;
    private FloatingActionButton bt;

    private static final int ACTIVITY_NUM = 0;


    private static final String TAG = "HomeActivity";
    private Context mcon= HomeActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        image = findViewById(R.id.video);

        bt= findViewById(R.id.fab2);

        wb = findViewById(R.id.web);
        wb.loadUrl("https://prathmesh3235.github.io/homepage/");
        wb.getSettings().setJavaScriptEnabled(true);
        wb.setWebViewClient(new WebViewClient());

        scroll = findViewById(R.id.slidetext);
        scroll.setSelected(true);

        setupBottomNavigationView();

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(HomeActivity.this, FeedbackActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });
    }

    private void setupBottomNavigationView(){
        Log.d(TAG, "setupBottomNavigationView: setting up bottom navigation view");
        BottomNavigationViewEx btnav= (BottomNavigationViewEx) findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.setupBottomNavigationView(btnav);
        BottomNavigationViewHelper.enableNavigation(mcon, btnav);
        Menu menu = btnav.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }
}
