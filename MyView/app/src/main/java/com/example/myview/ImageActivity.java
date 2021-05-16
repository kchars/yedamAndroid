package com.example.myview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ImageActivity extends AppCompatActivity {
    LinearLayout linear;
    ImageView img;
        
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
    
            linear = findViewById(R.id.linear);
            img = findViewById(R.id.img);

            linear.setOnTouchListener((v, event) ->{
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN: break;
                    case MotionEvent.ACTION_UP: break;
                    case MotionEvent.ACTION_MOVE:
                        //이미지
                        img.setX(event.getX());
                        img.setY(event.getY());

                }
              return true;
            });
    
    
    }
}