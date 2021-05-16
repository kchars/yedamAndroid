package com.example.mymenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ViewFlipper;

public class FlipperActivity extends AppCompatActivity {
    Button btnPrev, btnNext;
    ViewFlipper viewFlipper1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flipper);

        btnPrev = findViewById(R.id.btnPrev);
        btnNext = findViewById(R.id.btnNext);
        viewFlipper1 = findViewById(R.id.viewFlipper1);

        btnPrev.setOnClickListener(v -> { viewFlipper1.showPrevious(); });
        btnNext.setOnClickListener(v -> { viewFlipper1.showNext(); });

        //설정 간격 자동 view 교체
        viewFlipper1.setFlipInterval(2000);
        viewFlipper1.startFlipping();//자동 Flipping 시작
    }
}