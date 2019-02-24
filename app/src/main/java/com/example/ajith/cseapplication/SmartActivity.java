package com.example.ajith.cseapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SmartActivity extends AppCompatActivity {

    private Button submitteam;
    private EditText mailid;

    private DatabaseReference teamRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smart);

        submitteam = findViewById(R.id.submitfinally);
        mailid = findViewById(R.id.mail);

        teamRef = FirebaseDatabase.getInstance().getReference("newTeam");

        submitteam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teamRef.push().setValue(mailid.getText().toString());
            }
        });

    }
}
