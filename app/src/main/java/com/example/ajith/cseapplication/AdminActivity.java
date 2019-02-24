package com.example.ajith.cseapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        Button bt1= (Button)findViewById(R.id.notify);
        Button bt2= (Button)findViewById(R.id.events);
        Button bt3= (Button)findViewById(R.id.logout);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1= new Intent(AdminActivity.this, MainActivity.class);
                startActivity(i1);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2= new Intent(AdminActivity.this, UpcomingActivity.class);
                startActivity(i2);
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3 = new Intent(AdminActivity.this, HomeActivity.class);
                i3.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i3);
            }
        });
    }
}