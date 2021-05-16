package com.example.mythread;

import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ProgressBar pb1, pb2;
    Button btn1, btn2;
    TextView tv1;
    SeekBar sb1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb1 = findViewById(R.id.pb1);
        pb2 = findViewById(R.id.pb2);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        tv1 = findViewById(R.id.tv1);
        sb1 = findViewById(R.id.sb1);

        btn1.setOnClickListener(v -> {
            new Thread() {
                public void run() {
                    for (
                            int i = 0;
                            i < 100; i = i + 2) {
                        pb1.setProgress(i);
                        SystemClock.sleep(100);
                    }
                }
            }.start();
            new Thread() {
                public void run() {
                    for (
                            int i = 0;
                            i < 100; i = i + 2) {
                        pb2.setProgress(i);
                        SystemClock.sleep(400);
                    }
                }
            }.start();
        });

        btn2.setOnClickListener(v -> {
            pb1.setProgress(pb2.getProgress() - 10);
            pb2.setProgress(pb2.getProgress() - 10);
        });

        sb1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUse) {
                tv1.setText("진행율 " + progress + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
}