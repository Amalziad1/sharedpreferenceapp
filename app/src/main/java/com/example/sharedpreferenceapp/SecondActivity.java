package com.example.sharedpreferenceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView textViewUserName;
    TextView textViewPassword;
    Button buttonLoad;
    Button buttonBackToMainActivity;
    SharedPrefManager sharedPrefManager;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textViewUserName = (TextView) findViewById(R.id.textViewUserName);
        textViewPassword = (TextView) findViewById(R.id.textViewPassword);
        buttonLoad = (Button) findViewById(R.id.buttonLoad);
        buttonBackToMainActivity = (Button)
                findViewById(R.id.buttonBackToMainActivity);
        sharedPrefManager=SharedPrefManager.getInstance(this);
        intent = new Intent(SecondActivity.this,MainActivity.class);
        buttonLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                textViewUserName.setText(sharedPrefManager.readString("userName","noValue"));

                textViewPassword.setText(sharedPrefManager.readString("password","noValue"));
            }
        });
        buttonBackToMainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
                finish();
            }
        });
    }

}