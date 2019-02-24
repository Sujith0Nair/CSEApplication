package com.example.ajith.cseapplication;

import android.content.Intent;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements GestureDetector.OnGestureListener{
    private EditText name, pass;
    private TextView info;
    private Button login;
    private int counter=5;
    private ImageView image;
    private GestureDetectorCompat detector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        name= findViewById(R.id.username);
        pass= findViewById(R.id.password);
        info= findViewById(R.id.info);
        login= findViewById(R.id.btlogin);
        image= findViewById(R.id.imageinnov);
        detector = new GestureDetectorCompat(this, this);

        info.setText("Attempts Remaining: 5");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(name.getText().toString(), pass.getText().toString());
                name.setText("");
                pass.setText("");
            }
        });
    }

    private void validate(String uname, String upass){
        if((uname.equals("Admin")) && (upass.equals("0308"))){
            Intent i= new Intent(LoginActivity.this, AdminActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
        }else{
            counter--;
            info.setText("Attempts Remaining:" + String.valueOf(counter));
            Toast.makeText(this, "Invalid Username/Password", Toast.LENGTH_SHORT).show();
            if(counter==0){
                login.setEnabled(false);
            }
        }
    }


    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        Intent i= new Intent(LoginActivity.this, HiddenActivity.class);
        startActivity(i);
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        detector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

}
