package com.example.mylist;

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


    public void deleteData(DBHelper dbHelper, EmpVO emp) {
        //이름으로 삭제
        db = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", emp.getName());
        db.delete("emp", "name = ?", new String[]{emp.getName()});
        db.close();

    }


    public void insertData(DBHelper dbHelper, EmpVO emp) {
        db = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", emp.getName());
        contentValues.put("age", emp.getAge());
        contentValues.put("mobile", emp.getMobile());
        db.insert("emp", null, contentValues);
        db.close();

    }


    public List<EmpVO> selectData(DBHelper dbHelper) {
        db = dbHelper.getReadableDatabase();
        Cursor cursor =  db.rawQuery("SELECT name, mobile FROM emp", null);
        List<EmpVO> list = new ArrayList<EmpVO>();
        while(cursor.moveToNext()){
            EmpVO emp = new EmpVO();
            emp.setName(cursor.getString(0));
            emp.setMobile(cursor.getString(1));
            list.add(emp);

        }
        db.close();
        return list;
    }


}

