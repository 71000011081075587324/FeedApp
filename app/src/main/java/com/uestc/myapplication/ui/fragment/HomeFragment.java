package com.uestc.myapplication.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.uestc.myapplication.Adapter.HomeFragmentAdapter;
import com.uestc.myapplication.R;
import com.uestc.myapplication.base.fragment.BaseFragment;
import com.uestc.myapplication.base.presenter.BasePresenter;
import com.uestc.myapplication.bean.FeedStreamBean;
import com.uestc.myapplication.contract.Home.HomeFriendContract;
import com.uestc.myapplication.model.HomeFriendModel;
import com.uestc.myapplication.presenter.HomeFriendPresenter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends BaseFragment {

    private final int VIEWPAGERCOUNT = 2;

    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    private HomeFriendContract.IHomePresenter mIHomePresenter;

    private HomeFriendFragment mHomeFriendFragment;

    public HomeFragment(Context context){
        mContext = context;
    }

    @Override
    protected View initView() {
        List<BaseFragment> fragments = new ArrayList<BaseFragment>();
        fragments.add(mHomeFriendFragment);
        fragments.add(new HomeRecommendFragment(mContext));

        mView = View.inflate(mContext, R.layout.fragment_home,null);

        mTabLayout = mView.findViewById(R.id.tab_layout);
        List<String> titles = new ArrayList<String>(VIEWPAGERCOUNT);
        titles.add("关注");
        titles.add("推荐");

        for(String str : titles){
            mTabLayout.addTab(mTabLayout.newTab().setText(str));
        }

        mViewPager = mView.findViewById(R.id.view_pager_home);
        HomeFragmentAdapter mFragmentStateAdapter = new HomeFragmentAdapter(getChildFragmentManager(), fragments, titles);
        mViewPager.setAdapter(mFragmentStateAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabsFromPagerAdapter(mFragmentStateAdapter);

        return mView;
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
        HomeFriendModel homeFriendModel = HomeFriendModel.getInstance();
        mHomeFriendFragment = new HomeFriendFragment(mContext);
        mIHomePresenter = new HomeFriendPresenter(homeFriendModel, mHomeFriendFragment);
        mHomeFriendFragment.setPresenter((BasePresenter) mIHomePresenter);
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
