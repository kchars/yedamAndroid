package com.example.mylayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class FrameActivity extends AppCompatActivity {
    Button btn1, btn2, btn3;
    FrameLayout frameLayout;
    View frame1, frame2, frame3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);

        //초기화
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        frameLayout = findViewById(R.id.frameLayout);
        frame1 = findViewById(R.id.frame1);
        frame2 = findViewById(R.id.frame2);
        frame3 = findViewById(R.id.frame3);

        //이벤트
        View.OnClickListener handler = v -> {
            frame1.setVisibility(View.INVISIBLE);
            frame2.setVisibility(View.INVISIBLE);
            frame3.setVisibility(View.INVISIBLE);
            switch (v.getId()) {
                case R.id.btn1:
                    frame1.setVisibility(View.VISIBLE);
                    break;
                case R.id.btn2:
                    frame2.setVisibility(View.VISIBLE);
                    break;
                case R.id.btn3:
                    frame3.setVisibility(View.VISIBLE);
                    break;
            }
        };
        btn1.setOnClickListener(handler);
        btn2.setOnClickListener(handler);
        btn3.setOnClickListener(handler);

    }
}