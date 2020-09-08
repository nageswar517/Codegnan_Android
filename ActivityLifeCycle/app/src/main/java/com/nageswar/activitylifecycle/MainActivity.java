package com.nageswar.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate:activated");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: activated");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: activated");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: activated");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: activated");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: activated");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart: activated");
    }
}