package com.example.myvote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        int[] voteResult = intent.getIntArrayExtra("VoteCount");
        String[] imageName = intent.getStringArrayExtra("ImageName");

        TextView tv[] = new TextView(imageName.length);
        RatingBar rbar[] = new RatingBar[imageName.length];

        Integer tvID[] = {
                R.id.iv1,
                R.id.iv2,
                R.id.iv3,
                R.id.iv4,
                R.id.iv5,
                R.id.iv6,
                R.id.iv7,
                R.id.iv8,
                R.id.iv9,

        };

        Integer rbarID[] = {
                R.id.rbar1,
                R.id.rbar2,
                R.id.rbar3,
                R.id.rbar4,
                R.id.rbar5,
                R.id.rbar6,
                R.id.rbar7,
                R.id.rbar8,
                R.id.rbar9,
        };

        for(int i=0; i<voteResult.length; i++){
            tv[i].setText(imageName[i]);;
            rbar[i].setRating((float)voteResult);
        }

        Button btnReturn = (Button)findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                finish();
            }

        });

    }
}