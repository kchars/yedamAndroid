package com.example.myplayer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.os.SystemClock;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.pedro.library.AutoPermissions;
import com.pedro.library.AutoPermissionsListener;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AutoPermissionsListener {

    ListView lv1;
    Button btnPlay, btnStop;
    TextView tv1, tvTime, testView;
    List<String> fileList;
    SeekBar pbMp3;

    String selectMp3;
    MediaPlayer mp3Player;
    String mp3Path = Environment.getExternalStorageDirectory().getPath() + "/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AutoPermissions.Companion.loadAllPermissions(this, 101);
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);


        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "외부저장장치 권한 있음", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "외부저장장치 권한 없음", Toast.LENGTH_LONG).show();
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }

        tv1 = findViewById(R.id.tv1);
        tvTime = findViewById(R.id.tvTime);
        lv1 = findViewById(R.id.lv1);
        btnPlay = findViewById(R.id.btnPlay);
        btnStop = findViewById(R.id.btnStop);
        pbMp3 = findViewById(R.id.pbMp3);
        testView = (TextView) findViewById(R.id.testView);

        btnPlay.setOnClickListener((v) -> {
            btnPlayHandler();
        });
        btnStop.setOnClickListener((v) -> {
            btnStopHandler();
        });

        listEnit();


        thread1.start();
    }

    //1초마다 시간 출력
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    Thread thread1 = new Thread() {
        public void run() {
            while (true) {
                Calendar cal = Calendar.getInstance();
                String strTime = sdf.format(cal.getTime());
                runOnUiThread(() -> {
                    testView.setText(strTime);
                });
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();

                }
            }
        }
    };

    //
    private void btnStopHandler() {
        mp3Player.stop();
        mp3Player.reset();
        btnPlay.setClickable(true);
        btnStop.setClickable(false);
        tv1.setText("실행중인 음악: ");
    }

    //
    private void btnPlayHandler() {

        try {
            mp3Player = new MediaPlayer();
            mp3Player.setDataSource(mp3Path + selectMp3);
            mp3Player.prepare();
            mp3Player.start();
            btnPlay.setClickable(false);
            btnStop.setClickable(true);
            tv1.setText("실행중인 음악: " + selectMp3);
            //SeekBar Thread
            SimpleDateFormat timeFormat = new SimpleDateFormat("mm:ss");
            int duration = mp3Player.getDuration();
            pbMp3.setMax(duration);
            new Thread() {
                public void run() {
                    while (mp3Player.isPlaying()) {
                        runOnUiThread(() -> {
                            pbMp3.setProgress(mp3Player.getCurrentPosition());
                            String ms = timeFormat.format(mp3Player.getCurrentPosition());
                            tvTime.setText(ms + "");
                        });
                        SystemClock.sleep(100);
                    }
                }
            }.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //
    private void listEnit() {
        List fileList = new ArrayList<String>();
        String mp3Path = Environment.getExternalStorageDirectory().getPath();
        File[] files = new File(mp3Path).listFiles();
        for (File file : files) {
            String filename = file.getName();
            String ext = filename.substring(filename.length() - 3);
            if (ext.equals("mp3")) {
                fileList.add(filename);
            }
        }

        //Listview 초기화
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, fileList);
        lv1.setAdapter(adapter);
        lv1.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lv1.setOnItemClickListener((parent, view, position, id) -> {
            selectMp3 = (String) fileList.get(position);
        });

        selectMp3 = (String) fileList.get(0);
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