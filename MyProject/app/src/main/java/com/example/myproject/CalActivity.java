package com.example.myproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CalActivity extends AppCompatActivity {
    EditText edit1, edit2;
    Button btnAdd, btnSub, btnMul, btnDiv;
    TextView textResult;
    String num1, num2;
    double result;
    double tab1, tab2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int[] btnNum = {R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9};
        setTitle("초간단 계산기");

        View[] btnView = new View[10];
        View.OnClickListener handler = v->{
            if(edit1.isFocused()){
                String num1 = edit1.getText().toString()
                        + ((Button)v).getText().toString();
                edit1.setText(num1);
            }else if(edit2.isFocused()){
                String num1 = edit2.getText().toString()
                        + ((Button)v).getText().toString();
                edit2.setText(num1);
            } else{
                Toast.makeText(this, "텍스트뷰 선택", Toast.LENGTH_SHORT).show();
            }

        };

        for(int n=0;n<10;n++){
            btnView[n] = findViewById(btnNum[n]);
            btnView[n].setOnClickListener(handler);
        }

        edit1 = (EditText) findViewById(R.id.Edit1);
        edit2 = (EditText) findViewById(R.id.Edit2);

        btnAdd = (Button) findViewById(R.id.BtnAdd);
        btnSub = (Button) findViewById(R.id.BtnSub);
        btnMul = (Button) findViewById(R.id.BtnMul);
        btnDiv = (Button) findViewById(R.id.BtnDiv);

        textResult = (TextView) findViewById(R.id.TextResult);


        //3. 리스너 핸들러 선언
        View.OnClickListener btnListener = v -> {
            String num1 = String.valueOf(edit1.getText()).trim();
            String num2 = String.valueOf(edit2.getText()).trim();
            //if toast
            if (num1.isEmpty() || num2.isEmpty()) {
                Toast.makeText(this, "입력필요", Toast.LENGTH_SHORT).show();
                return;
            }

            double result = 0.000000;
            switch (v.getId()) {
                case R.id.BtnAdd:
                    result = Double.parseDouble(num1) + Double.parseDouble(num2);
                    break;
                case R.id.BtnSub:
                    result = Double.parseDouble(num1) - Double.parseDouble(num2);
                    break;
                case R.id.BtnMul:
                    result = Double.parseDouble(num1) * Double.parseDouble(num2);
                    break;
                case R.id.BtnDiv:
                    if (!num1.equals("0")) {
                        result = Double.parseDouble(num1) / Double.parseDouble(num2);
                    }
                    break;
            }
            textResult.setText(String.valueOf(result));
        };

        //3. 리스너핸들러 연결
        btnAdd.setOnClickListener(btnListener);
        btnSub.setOnClickListener(btnListener);
        btnMul.setOnClickListener(btnListener);
        btnDiv.setOnClickListener(btnListener);
    }
}