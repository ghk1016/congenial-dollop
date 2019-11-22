package com.bw.day1119;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private Button btn_tiao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_tiao = findViewById(R.id.btn_tiao);
        btn_tiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,TiaoActivity.class);
                startActivity(intent);
            }
        });
        Log.d(TAG, "a--------onCreate: ");
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        Log.d(TAG, "a-------------------onWindowFocusChanged: ");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "a------------------onSaveInstanceState: ");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "a--------------------onRestoreInstanceState: ");
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
