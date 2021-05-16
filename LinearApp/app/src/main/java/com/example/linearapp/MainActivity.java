package com.example.linearapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button btn1;
    EditText txt1, txt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //초기화
        btn1 = findViewById(R.id.btn1);
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        Button rbtn1 = findViewById(R.id.rbtn1);
        Button rbtn2 = findViewById(R.id.rbtn2);
            ImageView img1 = findViewById(R.id.img1);

        //이벤트
        btn1.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://naver.com"));
            startActivity(intent);
            txt2.setText(Intent.ACTION_VIEW);

        });

        //이벤트
        rbtn1.setOnClickListener(v -> {
                    img1.setImageResource(R.drawable.ic_launcher_foreground);
                }
        );
        rbtn2.setOnClickListener(v -> {
                    img1.setImageResource(R.drawable.ic_launcher_background);
                }
        );
    }
}