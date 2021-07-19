package com.uestc.myapplication.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.uestc.myapplication.R;
import com.uestc.myapplication.base.fragment.BaseFragment;
import com.uestc.myapplication.base.presenter.BasePresenter;
import com.uestc.myapplication.model.HomeFriendModel;
import com.uestc.myapplication.presenter.HomeFriendPresenter;

public class ImageShowFragment extends BaseFragment {
    private Context mContext;
    private int mPosition;
    private int mImageCount;

    private TextView mTextViewPosition;
    private LinearLayout mLinearLayoutImageShow;

    public ImageShowFragment(Context context, int position, int imageCount){
        mContext = context;
        mPosition = position;
        mImageCount = imageCount;
    }

    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.fragment_image_show,null);
        if(mImageCount >= 2){
            mTextViewPosition = view.findViewById(R.id.tv_image_show_position);
            mTextViewPosition.setText((mPosition + 1) + " / " + mImageCount);
        }

        mLinearLayoutImageShow = view.findViewById(R.id.ll_image_show);
        mLinearLayoutImageShow.setOnClickListener(v -> {
            ((Activity)mContext).finish();
        });

        return view;
    }

    /**
     * 每次创建、绘制该Fragment的View组件时回调该方法，Fragment将会显示该方法返回的View组件
     * 控件、页面的初始化
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return  返回初始化的view
     */
    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @org.jetbrains.annotations.NotNull LayoutInflater inflater,
                             @Nullable @org.jetbrains.annotations.Nullable ViewGroup container,
                             @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        return initView();
    }

    /**
     * 当Fragment所在的Activity被启动完成后回调该方法
     * 设置控件的点击事件放在其中
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }



}
