package com.uestc.myapplication.Adapter;

import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerTitleStrip;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.uestc.myapplication.base.fragment.BaseFragment;
import com.uestc.myapplication.ui.fragment.HomeFragment;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class HomeFragmentAdapter extends FragmentPagerAdapter {
    private List<BaseFragment> mFragments;
    private List<String> mTitles;

    public HomeFragmentAdapter(FragmentManager fm, List<BaseFragment> fragments, List<String> titles){
        super(fm);
        mFragments = fragments;
        mTitles = titles;
    }

    @NonNull
    @NotNull
    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }


    //保存ViewPager中Fragment的状态
    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public Parcelable saveState() {
        return super.saveState();
    }

    //恢复ViewPager和Fragment的状态
    @Override
    public void restoreState(@Nullable @org.jetbrains.annotations.Nullable Parcelable state, @Nullable @org.jetbrains.annotations.Nullable ClassLoader loader) {
        super.restoreState(state, loader);
    }
}
