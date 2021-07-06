package com.uestc.myapplication.Custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

public class HomeDetailLinearLayout extends LinearLayout {


    public HomeDetailLinearLayout(Context context) {
        super(context);
    }

    public HomeDetailLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public HomeDetailLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public HomeDetailLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
//
//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        ViewGroup.LayoutParams layoutParams = mContentView.getLayoutParams();
//        layoutParams.height = getMeasuredHeight();
//        mContentView.setLayoutParams(layoutParams);
//    }

}
