package com.example.mylist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btnArray;
    ListView lv;
    EditText txtName, txtMobile;
    List<String> str = new ArrayList<>(Arrays.asList("100","200","300","400","500"));
    List<EmpVO> list = new ArrayList<>();
    DBHelper dbHelper;
    EmpDAO dao = new EmpDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DBHelper(this);
    
        btnArray = findViewById(R.id.btnArray);
        lv = findViewById(R.id.lv);
        txtName = findViewById(R.id.txtName);
        txtMobile = findViewById(R.id.txtMobile);

/*        arrayListView();
        btnArray.setOnClickListener(v-> {
            String name = txtName.getText().toString();
            str.add(name);
            ((ArrayAdapter)lv.getAdapter()).notifyDataSetChanged();
        });*/
        customListView();
        btnArray.setOnClickListener(v-> {
            addEmp();
        });
    
    }

    private void addEmp() {
        //dataset에 추가
        String name = txtName.getText().toString();
        String mobile = txtMobile.getText().toString();
        EmpVO emp = new EmpVO(name, mobile);
        list.add(emp);
        //DB에 저장
        dao.insertData(dbHelper, emp);
        //리스트뷰 새로고침
        ((EmpAdater)lv.getAdapter()).notifyDataSetChanged();
        //입력필드 초기화
        txtName.setText("");
        txtMobile.setText("");
    }

    private void customListView() {
        list = dao.selectData(dbHelper);
        EmpAdater adater = new EmpAdater(list);
        lv.setAdapter(adater);
        lv.setOnItemClickListener((parent, view, position, id) -> {
            Toast.makeText(this, list.get(position).getName(), Toast.LENGTH_SHORT).show();
            list.remove(position);
            ((EmpAdater)lv.getAdapter()).notifyDataSetChanged();

        });

    }

    private void arrayListView2() {
        final String[] str1 = new String[]{"100","200","300","400","500"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice,
                str1);

        lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        lv.setAdapter(adapter);
    }

    private void arrayListView() {

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                str);

        lv.setAdapter(adapter);

        lv.setOnItemClickListener((parent, view, position, l) -> {
            Toast.makeText(this, str.get(position), Toast.LENGTH_SHORT).show();
            str.remove(position);
            ((ArrayAdapter)lv.getAdapter()).notifyDataSetChanged();

        });

    }
}