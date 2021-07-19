package com.uestc.myapplication.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.Window;

import com.uestc.myapplication.Adapter.ImageShowAdapter;
import com.uestc.myapplication.R;
import com.uestc.myapplication.base.activity.BaseActivity;
import com.uestc.myapplication.base.fragment.BaseFragment;
import com.uestc.myapplication.ui.fragment.ImageShowFragment;

import java.util.ArrayList;
import java.util.List;

public class ImageShowActivity extends BaseActivity {
    private int mPosition;
    private int mImageCount;
    private ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);   //去掉系统设置默认标题栏
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_show);
        initData();
        initView();
    }

    private void initData(){
        Bundle bundle = getIntent().getExtras();
        mImageCount = bundle.getInt("imageCount");
        mPosition = bundle.getInt("position",0);
    }

    private void initView(){
            List<BaseFragment> mFragment = new ArrayList<>();
            for(int i = 0; i < mImageCount; i++){
                mFragment.add(new ImageShowFragment(this,i,mImageCount));
            }

            mViewPager = findViewById(R.id.view_pager_image_show);
            ImageShowAdapter imageShowAdapter = new ImageShowAdapter(getSupportFragmentManager(),this,mFragment);
            mViewPager.setAdapter(imageShowAdapter);
            mViewPager.setCurrentItem(mPosition);

    }

}