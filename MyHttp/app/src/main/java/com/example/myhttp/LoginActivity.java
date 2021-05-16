package com.example.myhttp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class LoginActivity extends AppCompatActivity {
    EditText edtID, edtPW, edtName;
    Button btnLogin, btnRegis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtID = findViewById(R.id.edtID);
        edtPW = findViewById(R.id.edtPW);
        edtName = findViewById(R.id.edtName);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegis = findViewById(R.id.btnRegis);

        btnLogin.setOnClickListener(view -> {
            new Thread() {
                public void run() {

                    loginRequest();
                }
            }.start();
        });


        btnRegis.setOnClickListener(view -> {
            new Thread() {
                public void run() {

                    JoinRequest();
                }
            }.start();
        });



    }

    private void loginRequest() {
        StringBuffer sb = new StringBuffer();
        sb.append("요청시작\n");
        try {
            String userid = edtID.getText().toString();
            String userpw = edtPW.getText().toString();
            String param = "?userid=" + userid + "&userpw=" + userpw;
            String strUrl = "http://10.0.2.2/androidServer/Login.do" + param;
            URL url = new URL(strUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            if (conn != null) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line = null;
                while (true) {
                    line = reader.readLine();
                    if (line == null) break;
                    sb.append(line + "\n");
                }
                reader.close();
                conn.disconnect();
                runOnUiThread(() -> {
                    new AlertDialog.Builder(LoginActivity.this)
                            .setTitle("로그인")
                            .setMessage(sb.toString())
                            .create()
                            .show();
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void JoinRequest() {
        StringBuffer sb = new StringBuffer();
        sb.append("요청시작\n");
        try {
            String userid = edtID.getText().toString();
            String userpw = edtPW.getText().toString();
            String username = edtName.getText().toString();

            String param = String.format("userid=%s&userpw=%s&username=%s", userid, userpw, username);
            String strUrl = "http://10.0.2.2/androidServer/Register.do";
            URL url = new URL(strUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            if (conn != null) {
                //파라미터 전달
                conn.setRequestMethod("POST");
                conn.setDoOutput(true);
                PrintWriter out = new PrintWriter(conn.getOutputStream());
                out.println(param);
                out.close();
                
                //응답 결과
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line = null;
                while (true) {
                    line = reader.readLine();
                    if (line == null) break;
                    sb.append(line + "\n");
                }
                reader.close();
                conn.disconnect();
                runOnUiThread(() -> {
                    new AlertDialog.Builder(LoginActivity.this)
                            .setTitle("로그인")
                            .setMessage(sb.toString())
                            .create()
                            .show();
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}