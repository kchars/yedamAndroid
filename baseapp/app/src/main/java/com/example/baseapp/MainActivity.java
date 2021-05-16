package com.example.baseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = findViewById(R.id.btn1);
        ImageView img = findViewById(R.id.imageView);

        btn1.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.nate.com"));
            startActivity(intent);
            }
        );
        Button btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(v -> {
                    Intent mlntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:/911"));
                }
        );
        Button btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(v -> {
                    Intent mlntent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://media/internal/images/media"));
                }
        );
        Button btn4 = findViewById(R.id.btn4);
        btn4.setOnClickListener(v -> {
            finish();
                }
        );
        Button btn5 = findViewById(R.id.btn5);
        btn5.setOnClickListener(v -> {
            btn1.setBackgroundColor(Color.GREEN);
        }
        );
        Button btn6 = findViewById(R.id.btn6);
        btn6.setOnClickListener(v -> {
                    img.setImageResource(R.drawable.ic_launcher_background);
                }
        );
    }
}
