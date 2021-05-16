package com.example.myhttp;

import android.os.Build;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.pedro.library.AutoPermissions;
import com.pedro.library.AutoPermissionsListener;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AutoPermissionsListener {
    TextView tv1, tvTitle, tvCode, tvOpenDay;
    DatePicker dt1;
    Button btn1;
    ListView lv1;
    List<MovieVO> movieList = new ArrayList<MovieVO>();
    MovieAdater adapter;
    RequestQueue queue;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AutoPermissions.Companion.loadAllPermissions(this, 101);


        btn1 = findViewById(R.id.btn1);
        tv1 = findViewById(R.id.tv1);
        tvTitle = findViewById(R.id.tvTitle);
        tvCode = findViewById(R.id.tvCode);
        tvOpenDay = findViewById(R.id.tvOpenDay);
        dt1 = findViewById(R.id.dt1);
        lv1 = findViewById(R.id.lv1);

        adapter = new MovieAdater(movieList);
        lv1.setAdapter(adapter);

        dt1.setOnDateChangedListener((view, year, monthOfYear, dayOfMonth) -> {
            monthOfYear = monthOfYear +1;
            String dt = year + ""
                    + (monthOfYear<10? "0" + monthOfYear : monthOfYear)
                    + (dayOfMonth<10? "0" + dayOfMonth : dayOfMonth);
            tv1.setText(dt);
        });




        btn1.setOnClickListener(v -> {
            request();
        });
    }

    private void request() {

        String url = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20210509";
        StringRequest request =
                new StringRequest(url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        runOnUiThread(() -> {
                            try {
                                JSONObject obj = new JSONObject(response);
                                JSONObject office = obj.getJSONObject("boxOfficeResult");
                                JSONArray list = office.getJSONArray("dailyBoxOfficeList");
                                for (int i = 0; i < list.length(); i++) {
                                    JSONObject movie = list.getJSONObject(i);
                                    String movieNm = movie.getString("movieNm");
                                    String movieCd = movie.getString("movieCd");
                                    String openDt = movie.getString("openDt");
                                    MovieVO movieVO = new MovieVO();
                                    MovieVO.setTitle(movieNm);
                                    MovieVO.setCode(movieCd);
                                    MovieVO.setOpenDay(openDt);
                                    movieList.add(movieVO);
                                }
                                adapter.notifyDataSetChanged();
                            } catch (Exception e) {

                            }


                        });
                    }
                }, null);
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);
    }

    @Override
    public void onDenied(int i, String[] strings) {
    }

    @Override
    public void onGranted(int i, String[] strings) {
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        AutoPermissions.Companion.parsePermissions(this, requestCode, permissions, this);
    }


}