package com.example.mydialog;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class EmpDAO {
    SQLiteDatabase db;


    public void updateData() {

    }


    public void selectNameData() {

    }


    public void deleteData(com.example.mydialog.DBHelper dbHelper, com.example.mydialog.EmpVO emp) {
        //이름으로 삭제
        db = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", emp.getName());
        db.delete("emp", "name = ?", new String[]{emp.getName()});
        db.close();

    }


    public void insertData(com.example.mydialog.DBHelper dbHelper, com.example.mydialog.EmpVO emp) {
        db = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", emp.getName());
        contentValues.put("age", emp.getAge());
        contentValues.put("mobile", emp.getMobile());
        db.insert("emp", null, contentValues);
        db.close();

    }


    public List<com.example.mydialog.EmpVO> selectData(com.example.mydialog.DBHelper dbHelper) {
        db = dbHelper.getReadableDatabase();
        Cursor cursor =  db.rawQuery("SELECT name, mobile FROM emp", null);
        List<com.example.mydialog.EmpVO> list = new ArrayList<com.example.mydialog.EmpVO>();
        while(cursor.moveToNext()){
            com.example.mydialog.EmpVO emp = new com.example.mydialog.EmpVO();
            emp.setName(cursor.getString(0));
            emp.setMobile(cursor.getString(1));
            list.add(emp);

        }
        db.close();
        return list;
    }


}

