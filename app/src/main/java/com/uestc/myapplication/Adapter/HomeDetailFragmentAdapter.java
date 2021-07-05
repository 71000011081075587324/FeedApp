package com.uestc.myapplication.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.uestc.myapplication.base.fragment.BaseFragment;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class HomeDetailFragmentAdapter extends FragmentPagerAdapter {
    private List<BaseFragment> mFragments;
    private List<String> mTitles;

    public HomeDetailFragmentAdapter(FragmentManager fm,
                               List<BaseFragment> fragments,
                               List<String> titles){
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
}
