package com.example.ajith.cseapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HiddenActivity extends AppCompatActivity {

    private Button btn;
    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hidden);

        btn = findViewById(R.id.fake);
        txt = findViewById(R.id.congrats);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HiddenActivity.this, HomeActivity.class);
                startActivity(i);
                Toast.makeText(HiddenActivity.this, "Great job done! And Good luck.", Toast.LENGTH_LONG);
            }
        });

        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(HiddenActivity.this, SmartActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });
    }
}