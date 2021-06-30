package com.uestc.myapplication.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.net.Uri;
import android.os.Bundle;
import android.view.Window;

import com.uestc.myapplication.Adapter.ImageRecyclerAdapter;
import com.uestc.myapplication.R;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HomeFriendDetailActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private List<Uri> mImageDatas;
    private ImageRecyclerAdapter mImageRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);   //去掉系统设置默认标题栏
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);
        initView();
        initData();
    }

    private void initView(){
        mImageRecyclerAdapter = new ImageRecyclerAdapter(this, mImageDatas);
        mRecyclerView = findViewById(R.id.recycler_view_image);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(mImageRecyclerAdapter);
    }

    private void initData(){
        mImageDatas = new ArrayList<Uri>();


//        Random random = new Random();
//        mImageDatas.clear();
//        for(int i = 0; i < random.nextInt(9); i++){
//            mImageDatas.add(Uri.parse("http://www.test"));
//        }

        mImageRecyclerAdapter.notifyDataSetChanged();
    }

}