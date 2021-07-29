package com.uestc.myapplication.base.activity;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);     //设置状态栏中的字体颜色
        super.onCreate(savedInstanceState);
        Log.e(getClass().getSimpleName(),
                getClass().getSimpleName() + ":->" +"onCreat()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(getClass().getSimpleName(),
                getClass().getSimpleName() + ":->" + "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(getClass().getSimpleName(),
                getClass().getSimpleName() + ":->" + "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(getClass().getSimpleName(),
                getClass().getSimpleName() + ":->" + "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(getClass().getSimpleName(),
                getClass().getSimpleName() + ":->" + "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(getClass().getSimpleName(),
                getClass().getSimpleName() + ":->" + "onDestory()");
    }
}
