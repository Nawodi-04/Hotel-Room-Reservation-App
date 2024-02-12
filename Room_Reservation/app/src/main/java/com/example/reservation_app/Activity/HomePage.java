package com.example.reservation_app.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.reservation_app.R;

public class HomePage extends AppCompatActivity {
    Button button2;
    TextView textView6 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        button2  = findViewById(R.id.button2);
        textView6 = findViewById(R.id.textView6);

        button2.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
            startActivity(intent);
        });

        textView6.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),SignupActivity.class);
            startActivity(intent);
        });

    }
}