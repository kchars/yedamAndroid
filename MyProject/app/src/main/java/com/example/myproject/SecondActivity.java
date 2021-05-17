package com.example.myproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    Button secondTopBtn1, secondTopBtn2, secondBottomBtn1, secondBottomBtn2, secondBottomBtn3, secondBottomBtn4;
    EditText lv2_2, lv2_5, lv2_6, lv3_2, lv3_3, lv3_6;
    TextView lv2_3, lv2_4, lv3_1, lv3_4, lv3_5;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        secondTopBtn1 = findViewById(R.id.SecondTopBtn1);
        secondTopBtn2 = findViewById(R.id.SecondTopBtn2);
        secondBottomBtn1 = findViewById(R.id.SecondBottomBtn1);
        secondBottomBtn2 = findViewById(R.id.SecondBottomBtn2);
        secondBottomBtn3 = findViewById(R.id.SecondBottomBtn3);
        secondBottomBtn4 = findViewById(R.id.SecondBottomBtn4);
        lv2_2 = findViewById(R.id.lv2_2);
        lv2_5 = findViewById(R.id.lv2_5);
        lv2_5 = findViewById(R.id.lv2_5);
        lv2_6 = findViewById(R.id.lv2_6);
        lv3_2 = findViewById(R.id.lv3_2);
        lv3_3 = findViewById(R.id.lv3_3);
        lv3_6 = findViewById(R.id.lv3_6);

        lv2_3 = findViewById(R.id.lv2_3);
        lv2_4 = findViewById(R.id.lv2_4);
        lv3_1 = findViewById(R.id.lv3_1);
        lv3_4 = findViewById(R.id.lv3_4);
        lv3_5 = findViewById(R.id.lv3_5);


        secondTopBtn1.setOnClickListener(view -> {goHomePage();});
        secondTopBtn2.setOnClickListener(view -> {goCalPage();});


    }

    private void goCalPage() {
    }

    private void goHomePage() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}
