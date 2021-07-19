package com.uestc.myapplication.ui.activity;

import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.uestc.myapplication.R;
import com.uestc.myapplication.base.activity.BaseActivity;
import com.uestc.myapplication.utils.SharedPreferencesUtils;

public class SplashActivity extends BaseActivity {
    private ImageView ivHi;
    private SharedPreferencesUtils mSharedPreferencesUtils;
    private static final int REQUEST_CODE_PERMISSION = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);   //去掉系统设置默认标题栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);   //设置透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);   //设置透明导航栏
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mSharedPreferencesUtils = SharedPreferencesUtils.getInstance(SplashActivity.this);
        initView();

    }

    private void initView(){
        ivHi =  findViewById(R.id.iv_splash_hi);

        //设置动画
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.splash_open);
        ivHi.setAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if(mSharedPreferencesUtils.readBoolean("notFirstOpen") == false){
                    //第一次打开应用，进行应用权限请求
                    mSharedPreferencesUtils.putBoolean("notFirstOpen", true);
                    getPermission();
                }else{
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });

    }

    //获取存储权限
    private void getPermission() {
        //判断系统版本
        if (Build.VERSION.SDK_INT>22){
            //判断是否获取存储权限权限
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
                //未获得权限,进行申请
                ActivityCompat.requestPermissions(SplashActivity.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
                                Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_CODE_PERMISSION);
                return;

            }
        }
    }

    //请求权限后的回调方法
    @Override
    public void onRequestPermissionsResult(int requestCode,String permissions[], int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_PERMISSION: {
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
            }
            return;
        }
    }
}
