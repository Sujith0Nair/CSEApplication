package com.example.ajith.cseapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;


import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class UpcomingActivity extends AppCompatActivity {


    private EditText event;
    private Button uploadbtn;

    private DatabaseReference mRef;

    private ProgressBar bar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming);

        event = findViewById(R.id.upcomingtext);
        uploadbtn = findViewById(R.id.upcominguploadbtn);

        mRef = FirebaseDatabase.getInstance().getReference("upcoming");

        uploadbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRef.push().setValue(event.getText().toString());
                Toast.makeText(UpcomingActivity.this, "Upload successful", Toast.LENGTH_LONG).show();
            }
        });

    }


}

