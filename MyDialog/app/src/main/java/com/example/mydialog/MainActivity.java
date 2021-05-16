package com.example.mydialog;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowInsetsAnimation;
import android.view.WindowManager;
import android.view.WindowMetrics;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btnToast, btnDialog1, btnDialog2, btnDialog3, btnInflate;
    LinearLayout linearLayout;
    EditText txtName, txtMobile;
    DBHelper dbHelper;
    TextView tvList;



    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DBHelper(getApplicationContext());


        //초기화
        btnToast = findViewById(R.id.btnToast);
        btnDialog1 = findViewById(R.id.btnDialog1);
        btnDialog2 = findViewById(R.id.btnDialog2);
        btnDialog3 = findViewById(R.id.btnDialog3);
        btnInflate = findViewById(R.id.btnInflate);
        linearLayout = findViewById(R.id.linearLayout);

        LayoutInflater inflater = (LayoutInflater)
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout container = findViewById(R.id.linear);
        inflater.inflate(R.layout.inflate, linearLayout, true);

        tvList = findViewById(R.id.tvList);
        //이벤트


        //이벤트(메서드로 호출)
        btnInflate.setOnClickListener(v -> {
            empList();
        });
        btnToast.setOnClickListener(v -> {

        });
        btnDialog1.setOnClickListener(v -> {
            makeAlertDialog();
        });
        btnDialog2.setOnClickListener(v -> {
            makeArrayDialog();
        });
        btnDialog3.setOnClickListener(v -> {
            makeCustomDialog();
        });


    }

    //목록 조회
    private void empList() {
        EmpDAO dao = new EmpDAO();
        List<EmpVO> list =  dao.selectData(dbHelper);
        tvList.setText("");
        for(EmpVO emp : list) {
            tvList.append(emp.getName());
            tvList.append(emp.getMobile());
            tvList.append("\n");
        }
    }

    private void makeCustomDialog() {

        View view = View.inflate(MainActivity.this, R.layout.dialog, null);
        AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
        dlg
                .setTitle("제목")
                .setIcon(R.drawable.ic_launcher_foreground)
                .setPositiveButton("확인", (dialog, which) -> {
                    //대화상자에서 입력한 이름과 모바일값을 textview 출력
                    EditText txtName = view.findViewById(R.id.txtName);
                    EditText txtMobile = view.findViewById(R.id.txtMobile);

                    //테이블에 저장

                    EmpDAO dao = new EmpDAO();
                    EmpVO emp = new EmpVO(txtName.getText().toString(),
                            txtMobile.getText().toString());
                    dao.insertData(dbHelper, emp);

                })
                .setNegativeButton("취소", (dialog, which) -> {
                    Toast toast = new Toast(MainActivity.this);
                    View toastView = (View) View.inflate(MainActivity.this, R.layout.toast, null);
                    TextView toastText = (TextView) toastView.findViewById(R.id.toastText);
                    toastText.setText("취소했습니다");
                    toast.setView(toastView);
                    ;
                    toast.show();

                })
                .setView(view)
                .show();

    }

    private void makeArrayDialog() {
        AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
        String[] ver = new String[]{"파이", "Q버전", "R버전"};
//        String[] ver = R.array.androidVersion;
        dlg
//                .setMessage("AlertDialog입니다.")
                .setTitle("제목")
                .setIcon(R.drawable.ic_launcher_foreground)
//                .setPositiveButton("확인", (dialog, which) -> { Log.d("toast","ok"); })
//                .setNegativeButton("취소", (dialog, which) -> {Log.d("toast","취소"); })
                .setItems(ver, (dialog, which) -> {
                    Log.d("toast", ver[which]);
                })
                .show();

    }

    private void makeAlertDialog() {
        AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
        dlg.setMessage("AlertDialog입니다.")
                .setTitle("제목")
                .setIcon(R.drawable.ic_launcher_foreground)
                .setPositiveButton("확인", (dialog, which) -> {
                    Log.d("toast", "ok");
                })
                .setNegativeButton("취소", (dialog, which) -> {
                    Log.d("toast", "취소");
                })
                .show();

    }


    @RequiresApi(api = Build.VERSION_CODES.R)
    private void toast() {
        Toast tMsg = Toast.makeText(this, "토스트 연습", Toast.LENGTH_SHORT);
        //디바이스 해상도 정보 획득
        WindowMetrics metrics = ((WindowManager) getSystemService(WINDOW_SERVICE)).getCurrentWindowMetrics();
        Rect bounds = metrics.getBounds();
        int w = bounds.width();
        int h = bounds.height();
        int offsetX = (int) (Math.random() * w); //X축으로 랜덤값 받음
        int offsetY = (int) (Math.random() * h); //Y축으로 랜덤값 받음
        Log.d("toast", offsetX + ":" + offsetY);
        tMsg.setGravity(Gravity.TOP | Gravity.LEFT, offsetX, offsetY); // XY축 범위 한계
        tMsg.show();

    }

}