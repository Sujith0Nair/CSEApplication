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
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;


public class ProfileActivity extends AppCompatActivity {

    private static final String TAG = "ProfileActivity";
    private Context mcon= ProfileActivity.this;

    private FloatingActionButton fab1;

    private DatabaseReference newRef;

    private ArrayList<String> arrayList = new ArrayList<>();

    private ArrayAdapter<String> adapter;

    private ListView listview;

    private static final int ACTIVITY_NUM = 2;
    private WebView web;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setupBottomNavigationView();

        newRef = FirebaseDatabase.getInstance().getReference("upcoming");

        listview = findViewById(R.id.listupcoming);

        fab1 = findViewById(R.id.fab);

        web = findViewById(R.id.devweb);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);

        listview.setAdapter(adapter);

        newRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String string = dataSnapshot.getValue(String.class);
                arrayList.add(string);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                String string = dataSnapshot.getValue(String.class);
                arrayList.remove(string);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        web.loadUrl("https://flamingo-b117f.firebaseapp.com");
        web.getSettings().setJavaScriptEnabled(true);
        web.setWebViewClient(new WebViewClient());

        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(ProfileActivity.this, LoginActivity.class);
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
