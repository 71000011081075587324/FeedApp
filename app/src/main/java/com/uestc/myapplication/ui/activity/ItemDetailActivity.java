package com.uestc.myapplication.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;

import com.uestc.myapplication.R;

public class ItemDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);   //去掉系统设置默认标题栏
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);
    }

}