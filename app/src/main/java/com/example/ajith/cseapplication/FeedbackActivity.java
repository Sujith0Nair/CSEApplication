package com.example.ajith.cseapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FeedbackActivity extends AppCompatActivity {

    private EditText et;
    private Button bt;

    private DatabaseReference mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        et= findViewById(R.id.et1);
        bt= findViewById(R.id.bt1);

        mRef = FirebaseDatabase.getInstance().getReference("Queries");
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRef.push().setValue(et.getText().toString());
                Toast.makeText(FeedbackActivity.this, "Upload successful", Toast.LENGTH_LONG).show();
            }
        });
    }
}
