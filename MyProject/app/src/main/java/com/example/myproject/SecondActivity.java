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

        secondTopBtn1 = (Button)findViewById(R.id.SecondTopBtn1);
        secondTopBtn2 = (Button)findViewById(R.id.SecondTopBtn2);
        secondBottomBtn1 = (Button)findViewById(R.id.SecondBottomBtn1);
        secondBottomBtn2 = (Button)findViewById(R.id.SecondBottomBtn2);
        secondBottomBtn3 = (Button)findViewById(R.id.SecondBottomBtn3);
        secondBottomBtn4 = (Button)findViewById(R.id.SecondBottomBtn4);
        lv2_2 = (EditText)findViewById(R.id.lv2_2);
        lv2_5 = (EditText)findViewById(R.id.lv2_5);
        lv2_5 = (EditText)findViewById(R.id.lv2_5);
        lv2_6 = (EditText)findViewById(R.id.lv2_6);
        lv3_2 = (EditText)findViewById(R.id.lv3_2);
        lv3_3 = (EditText)findViewById(R.id.lv3_3);
        lv3_6 = (EditText)findViewById(R.id.lv3_6);

        lv2_3 = (TextView)findViewById(R.id.lv2_3);
        lv2_4 = (TextView)findViewById(R.id.lv2_4);
        lv3_1 = (TextView)findViewById(R.id.lv3_1);
        lv3_4 = (TextView)findViewById(R.id.lv3_4);
        lv3_5 = (TextView)findViewById(R.id.lv3_5);


        secondTopBtn1.setOnClickListener(view -> {goHomePage();});
        secondTopBtn2.setOnClickListener(view -> {goCalPage();});


    }

    private void goCalPage() {
        Intent intent = new Intent(getApplicationContext(), CalActivity.class);
        startActivity(intent);
    }

    private void goHomePage() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}
