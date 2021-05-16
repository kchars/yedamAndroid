package com.example.mydb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EmpActivity extends AppCompatActivity {

    DBHelper dbHelper;
    SQLiteDatabase db;

    TextView tv;
    EditText edName, edAge, edPhone;
    Button btnJoin, btnSelect, btnDelete, btnSelName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emp);

        dbHelper = new DBHelper(getApplicationContext());
        tv = findViewById(R.id.tv);

        edName = findViewById(R.id.edName);
        edAge = findViewById(R.id.edAge);
        edPhone = findViewById(R.id.edPhone);
        btnJoin = findViewById(R.id.btnJoin);
        btnSelect = findViewById(R.id.btnSelect);
        btnDelete = findViewById(R.id.btnDelete);
        btnSelName = findViewById(R.id.btnSelName);

        btnJoin.setOnClickListener(v -> {
            insertData();
        });
        btnDelete.setOnClickListener(v -> {
            deleteData();
        });
        btnSelect.setOnClickListener(v -> {
            selectData();
        });
        btnSelName.setOnClickListener(v -> {
            updateData();
        });
        btnSelName.setOnClickListener(v -> {
            selectNameData();
        });

    }

    private void updateData() {

    }


    public void selectNameData(){
        db = dbHelper.getReadableDatabase();
        String name = String.valueOf(edName.getText());
        String[] params = new String[]{name};
        String sql = "SELECT * FROM emp WHERE name=? ";
        Cursor cursor = db.rawQuery(sql,params);
        StringBuffer sb = new StringBuffer();
        if(cursor.moveToNext()){
                sb.append(name);
        } else {
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
        db.close();
    }


    private void deleteData() {
        //이름으로 삭제
        db = dbHelper.getWritableDatabase();
        String name = String.valueOf(edName.getText());
//        db.execSQL("DELETE FROM emp WHERE name = '" + edName.getText().toString() + "'");
        db.delete("emp","name =?",new String[]{name});
        db.close();
        Toast.makeText(getApplicationContext(), "삭제됨", Toast.LENGTH_SHORT).show();

    }


    private void insertData() {
        db = dbHelper.getWritableDatabase();
        String name = String.valueOf(edName.getText());
        String age = String.valueOf(edAge.getText());
        String phone = String.valueOf(edPhone.getText());
//        db.execSQL("INSERT INTO emp(name, age, mobile) VALUES ( '" + edName.getText().toString() + "','" + edAge.getText() + "','" + edPhone.getText().toString() + "');");
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("age", age);
        contentValues.put("mobile", phone);
        db.insert("emp", null, contentValues);

        db.close();
        Toast.makeText(getApplicationContext(), "입력됨", Toast.LENGTH_SHORT).show();

    }


    public void selectData() {
        db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM emp", null);
        StringBuffer sb = new StringBuffer();
        int recordCount = cursor.getCount();
        tv.setText("레코드 개수 : " + recordCount);

        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToNext();
            String name = cursor.getString(1);
            int age = cursor.getInt(2);
            String phone = cursor.getString(3);
            sb.append(name);
            sb.append(age);
            sb.append(phone);
            sb.append("\n");

        }
        db.close();
        tv.setText(sb.toString());
    }
}