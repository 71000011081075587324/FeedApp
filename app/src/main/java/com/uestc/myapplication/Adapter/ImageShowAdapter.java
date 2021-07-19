package com.uestc.myapplication.Adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import com.uestc.myapplication.R;
import com.uestc.myapplication.base.fragment.BaseFragment;
import com.uestc.myapplication.ui.fragment.ImageShowFragment;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ImageShowAdapter extends FragmentPagerAdapter {

    private List<BaseFragment> mFragments;
    private Context mContext;

    public ImageShowAdapter(FragmentManager fm, Context context, List<BaseFragment> fragments){
        super(fm);
        mContext = context;
        mFragments = fragments;
    }

    @NonNull
    @NotNull
    @Override
    public Fragment getItem(int position) {
        return (ImageShowFragment)mFragments.get(position);
    }

//    @Override
//    public Object instantiateItem(ViewGroup container, int position) {
//        ImageShowFragment imageShowFragment = (ImageShowFragment)mFragments.get(position);
//////        imageShowFragment.textViewPosition.setText(position + " / " + mFragments.size());
////        TextView textView = View.inflate(mContext, R.layout.fragment_image_show,null).findViewById(R.id.tv_image_show_position);
////        ((TextView)imageShowFragment.getView().findViewById(R.id.tv_image_show_position)).setText(position + " / " + mFragments.size());
////        textViewPosition.setOnClickListener(v -> {
////
////        });
//
//        return imageShowFragment;
//    }


    @Override
    public int getCount() {
        return mFragments.size();
    }

//    @Override
//    public boolean isViewFromObject(@NonNull @NotNull View view, @NonNull @NotNull Object object) {
//        return false;
//    }
}
