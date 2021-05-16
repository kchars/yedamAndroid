package com.example.mypat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView txtStart, txtLike;
    CheckBox ckbStart;
    RadioGroup radGrp;
    RadioButton radBtnCat, radBtnRab, radBtnDog;
    Button choBtn;
    ImageView imgView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("애완동물 사진보기");

        txtStart = findViewById(R.id.txtStart);
        txtLike = findViewById(R.id.txtLike);
        ckbStart = findViewById(R.id.ckbStart);
        radGrp = findViewById(R.id.radGrp);
        radBtnCat = findViewById(R.id.radBtnCat);
        radBtnDog = findViewById(R.id.radBtnDog);
        radBtnRab = findViewById(R.id.radBtnRab);
        choBtn = findViewById(R.id.choBtn);
        imgView = findViewById(R.id.imgView);

        ckbStart.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
               if(ckbStart.isChecked() == true) {
                   txtLike.setVisibility(View.VISIBLE);
                   radGrp.setVisibility(View.VISIBLE);
                   choBtn.setVisibility(View.VISIBLE);
                   imgView.setVisibility(View.VISIBLE);
               } else {
                   txtLike.setVisibility(View.INVISIBLE);
                   radGrp.setVisibility(View.INVISIBLE);
                   choBtn.setVisibility(View.INVISIBLE);
                   imgView.setVisibility(View.INVISIBLE);
               }
            }
        });

        choBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                switch (radGrp.getCheckedRadioButtonId()){
                    case R.id.radBtnDog:
                        imgView.setImageResource(R.drawable.dog);
                        break;
                    case R.id.radBtnCat:
                        imgView.setImageResource(R.drawable.cat);
                        break;
                    case R.id.radBtnRab:
                        imgView.setImageResource(R.drawable.rabbit);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "동물먼저 선택하세요", Toast.LENGTH_SHORT).show();
                }

            }

        });


    }
}