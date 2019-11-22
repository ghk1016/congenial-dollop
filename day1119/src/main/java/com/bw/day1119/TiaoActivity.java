package com.bw.day1119;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class TiaoActivity extends AppCompatActivity {
    private static final String TAG = "TiaoActivity";
    private Button btn_show;
    private Button btn_my;
    private FrameLayout frame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiao);
        btn_show = findViewById(R.id.btn_show);
        btn_my = findViewById(R.id.btn_my);
        frame = findViewById(R.id.frame);
        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().add(R.id.frame,new ShowFragment()).commit();
            }
        });
        btn_my.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().add(R.id.frame,new MyFragment()).commit();
            }
        });
        Log.d(TAG, "onCreate: ");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "a--------onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "a---------onResume: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "a-------onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "a------onDestroy: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "a-------onRestart: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "a-------onPause: ");
    }
}
