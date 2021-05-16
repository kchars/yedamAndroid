package com.example.mydb;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edt1, edt2;
    Button btn1, btn2, btn3;
    TextView txtv1;
    SQLiteDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.edt2);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        txtv1 = findViewById(R.id.txtv1);

        btn1.setOnClickListener(v -> {
            createDB();
        });
        btn2.setOnClickListener(v -> {
            createTable();
        });
        btn3.setOnClickListener(v -> {

        });
    }

    public void createDB(){
    String dbname = String.valueOf(edt1.getText());
    database = openOrCreateDatabase(dbname, MODE_PRIVATE, null);
    }
    public void createTable(){
        String dbname = String.valueOf(edt1.getText());
        String tablename = String.valueOf(edt2.getText());
        database.execSQL("create table if not exists " + tablename + "("
                + " _id integer PRIMARY KEY autoincrement, "
                + " name text, "
                + " age integer, "
                + " mobile text)");
        database.execSQL("insert into " + tablename
                + "(name, age, mobile) "
                + " values "
                + "('John', 20, '010-1000-1000')");
        Cursor cursor = database.rawQuery("select _id, name, age, mobile from " + tablename, null);
        int recordCount = cursor.getCount();

        //출력
        txtv1.setText("레코드 개수 : " + recordCount);

        database.close();
    }

}