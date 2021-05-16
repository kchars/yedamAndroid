package com.example.myintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //레이아웃
        setContentView(R.layout.activity_second);
        btn1 = findViewById(R.id.btn1);

        btn1.setOnClickListener(v -> {
            goSecondPage();
        });
        radBtn1.setOnClickListener(v -> {
            goThirdPage();
        });

        
        }

    private void goThirdPage() {
        
    }


    private void goSecondPage() {
        Intent intent = new Intent(getApplicationContext(),SecondActivity.class);
        intent.putExtra("username","홍길동");

        startActivity(intent);

    }
}
