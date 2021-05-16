package com.example.myview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class CheckBoxActivity extends AppCompatActivity {
    CheckBox chb1, chb2, chb3;
    Button btnAll;
    Switch sw1;
    ToggleButton tog1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);

        //초기화
        chb1 = findViewById(R.id.ckb1);
        chb2 = findViewById(R.id.ckb2);
        chb3 = findViewById(R.id.ckb3);
        btnAll = findViewById(R.id.btnAll);
        sw1 = findViewById(R.id.sw1);
        tog1 = findViewById(R.id.tog1);

        chb1.setOnCheckedChangeListener((buttonView,isChecked) ->{
            String result = buttonView.getText().toString() + isChecked;
            Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
            
        });
        //이벤트
        btnAll.setOnClickListener(v->{
            chb1.setChecked(true);
            chb2.setChecked(true);
            chb3.setChecked(true);

        });
        sw1.setOnClickListener(v->{
            boolean b = sw1.isChecked();
            chb1.setChecked(b);
            chb2.setChecked(b);
            chb3.setChecked(b);

        });


    }
}