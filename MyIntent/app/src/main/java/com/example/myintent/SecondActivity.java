package com.example.myintent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class SecondActivity extends Activity {
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //레이아웃
        setContentView(R.layout.activity_second);
        btn2 = findViewById(R.id.btn2);


        btn2.setOnClickListener(v ->{
            goMainPage();

        });

    }

    private void goMainPage() {
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);

        startActivity(intent);

    }
}
