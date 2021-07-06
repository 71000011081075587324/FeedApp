package com.uestc.myapplication.ui.activity;

import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.viewpager.widget.ViewPager;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.tabs.TabLayout;
import com.uestc.myapplication.Adapter.HomeDetailFragmentAdapter;
import com.uestc.myapplication.Adapter.ImageRecyclerAdapter;
import com.uestc.myapplication.R;
import com.uestc.myapplication.base.activity.BaseActivity;
import com.uestc.myapplication.base.fragment.BaseFragment;
import com.uestc.myapplication.ui.fragment.DetailCommentFragment;
import com.uestc.myapplication.ui.fragment.DetailPraiseFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeDetailActivity extends BaseActivity implements View.OnClickListener {
    private RecyclerView mRecyclerView;
    private List<Uri> mImageDatas;
    private ImageRecyclerAdapter mImageRecyclerAdapter;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private View mIncludeOne;
    private View mIncludeMore;
    private ImageView mImageViewProfile;
    private ImageView mImageViewExit;
    private NestedScrollView mNestedScrollView;
    private int tempSize;

//    ViewGroup rlTitle;
//    ViewGroup rlButtom;
//    View mView;
//    ViewGroup nestSrcollView;
//    ViewGroup.LayoutParams layoutParams;
//    DisplayMetrics displayMetrics;

    private final int VIEWPAGERCOUNT = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);   //去掉系统设置默认标题栏
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_detail);
        initView();
        initData();
        initClickListener();

//        rlTitle = findViewById(R.id.rl_title_detail);
//        rlButtom = findViewById(R.id.include_buttom_detail);
//        mView = findViewById(R.id.view_detail_line);
//        nestSrcollView = findViewById(R.id.nested_scrollview_detail);
//        layoutParams = nestSrcollView.getLayoutParams();
//        displayMetrics = getResources().getDisplayMetrics();
//
//
//        Log.e(getClass().getSimpleName(),"layoutParams.height :" + layoutParams.height);
//        Log.e(getClass().getSimpleName(),"displayMetrics.heightPixels :" + displayMetrics.heightPixels);
//        Log.e(getClass().getSimpleName(),"rlTitle.getMeasuredHeight() :" + rlTitle.getMeasuredHeight());
//        Log.e(getClass().getSimpleName(),"rlButtom.getMeasuredHeight() :" + rlButtom.getMeasuredHeight());
//        Log.e(getClass().getSimpleName(),"mView.getMeasuredHeight() :" + mView.getMeasuredHeight());


//        ViewGroup rlTitle = findViewById(R.id.rl_title_detail);
//        ViewGroup rlButtom = findViewById(R.id.include_buttom_detail);
//        View mView = findViewById(R.id.view_detail_line);
//        ViewGroup nestSrcollView = findViewById(R.id.nested_scrollview_detail);
//        ViewGroup.LayoutParams layoutParams = nestSrcollView.getLayoutParams();
//        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
//
//
//        Log.e(getClass().getSimpleName(),"layoutParams.height :" + layoutParams.height);
//        Log.e(getClass().getSimpleName(),"displayMetrics.heightPixels :" + displayMetrics.heightPixels);
//        Log.e(getClass().getSimpleName(),"rlTitle.getMeasuredHeight() :" + measureView(rlTitle)[1]);
//        Log.e(getClass().getSimpleName(),"rlButtom.getMeasuredHeight() :" + measureView(rlButtom)[1]);
//        Log.e(getClass().getSimpleName(),"mView.getMeasuredHeight() :" + measureView(mView)[1]);
//
//        Log.e(getClass().getSimpleName(),"layoutParams.height :" + layoutParams.height);
//        Log.e(getClass().getSimpleName(),"displayMetrics.heightPixels :" + displayMetrics.heightPixels);
//        Log.e(getClass().getSimpleName(),"rlTitle.getMeasuredHeight() :" + rlTitle.getMeasuredHeight());
//        Log.e(getClass().getSimpleName(),"rlButtom.getMeasuredHeight() :" + rlButtom.getMeasuredHeight());
//        Log.e(getClass().getSimpleName(),"mView.getMeasuredHeight() :" + mView.getMeasuredHeight());
//
//
//        layoutParams.height = displayMetrics.heightPixels
//                - rlTitle.getMeasuredHeight()
//                - rlButtom.getMeasuredHeight()
//                - mView.getMeasuredHeight();
//        Log.e(getClass().getSimpleName(),"layoutParams.height : " + layoutParams.height);
//        nestSrcollView.setLayoutParams(layoutParams);

    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        Log.e(getClass().getSimpleName(),"layoutParams.height :" + layoutParams.height);
//        Log.e(getClass().getSimpleName(),"displayMetrics.heightPixels :" + displayMetrics.heightPixels);
//        Log.e(getClass().getSimpleName(),"rlTitle.getMeasuredHeight() :" + rlTitle.getMeasuredHeight());
//        Log.e(getClass().getSimpleName(),"rlButtom.getMeasuredHeight() :" + rlButtom.getMeasuredHeight());
//        Log.e(getClass().getSimpleName(),"mView.getMeasuredHeight() :" + mView.getMeasuredHeight());
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        Log.e(getClass().getSimpleName(),"layoutParams.height :" + layoutParams.height);
//        Log.e(getClass().getSimpleName(),"displayMetrics.heightPixels :" + displayMetrics.heightPixels);
//        Log.e(getClass().getSimpleName(),"rlTitle.getMeasuredHeight() :" + rlTitle.getMeasuredHeight());
//        Log.e(getClass().getSimpleName(),"rlButtom.getMeasuredHeight() :" + rlButtom.getMeasuredHeight());
//        Log.e(getClass().getSimpleName(),"mView.getMeasuredHeight() :" + mView.getMeasuredHeight());
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        Log.e(getClass().getSimpleName(),"layoutParams.height :" + layoutParams.height);
//        Log.e(getClass().getSimpleName(),"displayMetrics.heightPixels :" + displayMetrics.heightPixels);
//        Log.e(getClass().getSimpleName(),"rlTitle.getMeasuredHeight() :" + rlTitle.getMeasuredHeight());
//        Log.e(getClass().getSimpleName(),"rlButtom.getMeasuredHeight() :" + rlButtom.getMeasuredHeight());
//        Log.e(getClass().getSimpleName(),"mView.getMeasuredHeight() :" + mView.getMeasuredHeight());
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        Log.e(getClass().getSimpleName(),"layoutParams.height :" + layoutParams.height);
//        Log.e(getClass().getSimpleName(),"displayMetrics.heightPixels :" + displayMetrics.heightPixels);
//        Log.e(getClass().getSimpleName(),"rlTitle.getMeasuredHeight() :" + rlTitle.getMeasuredHeight());
//        Log.e(getClass().getSimpleName(),"rlButtom.getMeasuredHeight() :" + rlButtom.getMeasuredHeight());
//        Log.e(getClass().getSimpleName(),"mView.getMeasuredHeight() :" + mView.getMeasuredHeight());
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        Log.e(getClass().getSimpleName(),"layoutParams.height :" + layoutParams.height);
//        Log.e(getClass().getSimpleName(),"displayMetrics.heightPixels :" + displayMetrics.heightPixels);
//        Log.e(getClass().getSimpleName(),"rlTitle.getMeasuredHeight() :" + rlTitle.getMeasuredHeight());
//        Log.e(getClass().getSimpleName(),"rlButtom.getMeasuredHeight() :" + rlButtom.getMeasuredHeight());
//        Log.e(getClass().getSimpleName(),"mView.getMeasuredHeight() :" + mView.getMeasuredHeight());
//    }

    private void initClickListener(){
        mImageViewExit.setOnClickListener(this);
    }

    private void initView(){
        mIncludeOne = findViewById(R.id.include_text_home_friend_one_image);
        mIncludeMore = findViewById(R.id.include_text_home_friend_more_image);
        mImageViewExit = findViewById(R.id.btn_title_bar_exit);
        tempSize = 8;
        if(tempSize < 2){
            mIncludeMore.setVisibility(View.GONE);
            //设置圆形用户头像
            mImageViewProfile = findViewById(R.id.iv_profile);
            RequestOptions options = new RequestOptions()
                    .error(R.drawable.profile_image_2)
                    .placeholder(R.drawable.profile_image_2)
                    .transforms(new CircleCrop());
            Glide.with(this)
                    .load(R.drawable.profile_image_2)
                    .apply(options)
                    .into(mImageViewProfile);
        }else{
            mIncludeOne.setVisibility(View.GONE);
            mImageRecyclerAdapter = new ImageRecyclerAdapter(this, mImageDatas);
            mRecyclerView = findViewById(R.id.recycler_view_image);
            mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
            mRecyclerView.setAdapter(mImageRecyclerAdapter);
            mRecyclerView.setHasFixedSize(true);
            ((SimpleItemAnimator) mRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);

            //设置圆形用户头像
            mImageViewProfile = mIncludeMore.findViewById(R.id.iv_profile);
            RequestOptions options = new RequestOptions()
                    .error(R.drawable.profile_image_2)
                    .placeholder(R.drawable.profile_image_2)
                    .transforms(new CircleCrop());
            Glide.with(this)
                    .load(R.drawable.profile_image_2)
                    .apply(options)
                    .into(mImageViewProfile);
        }

//        mNestedScrollView = findViewById(R.id.nested_scrollview_detail);
//        mNestedScrollView.setMinimumHeight((int) (getResources().getDisplayMetrics().density * 115 + 0.5f));

        List<BaseFragment> fragments = new ArrayList<BaseFragment>();
        fragments.add(new DetailCommentFragment(this));
        fragments.add(new DetailPraiseFragment(this));

        mTabLayout = findViewById(R.id.tab_layout_home_detail);

        List<String> titles = new ArrayList<String>(VIEWPAGERCOUNT);
        titles.add("评论");
        titles.add("点赞");


        for(String str : titles){
            mTabLayout.addTab(mTabLayout.newTab().setText(str));
        }

        mViewPager = findViewById(R.id.view_pager_home_detail);
        HomeDetailFragmentAdapter mHomeDetailFragmentAdapter = new HomeDetailFragmentAdapter(getSupportFragmentManager(), fragments, titles);
        mViewPager.setAdapter(mHomeDetailFragmentAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabsFromPagerAdapter(mHomeDetailFragmentAdapter);

//        //设置圆形用户头像
//        mImageViewProfile = findViewById(R.id.iv_profile);
//        RequestOptions options = new RequestOptions()
//                .error(R.drawable.profile_image_2)
//                .placeholder(R.drawable.profile_image_2)
//                .transforms(new CircleCrop());
//        Glide.with(this)
//                .load(R.drawable.profile_image_2)
//                .apply(options)
//                .into(mImageViewProfile);


    }


    private void initData(){
//        mImageDatas = new ArrayList<Uri>();


//        Random random = new Random();
//        mImageDatas.clear();
//        for(int i = 0; i < random.nextInt(9); i++){
//            mImageDatas.add(Uri.parse("http://www.test"));
//        }

//        mImageRecyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
             case R.id.btn_title_bar_exit:
                finish();
                break;
        }
    }

//    public static int[] measureView(final View view) {
//        ViewGroup.LayoutParams lp = view.getLayoutParams();
//        if (lp == null) {
//            lp = new ViewGroup.LayoutParams(
//                    ViewGroup.LayoutParams.MATCH_PARENT,
//                    ViewGroup.LayoutParams.WRAP_CONTENT
//            );
//        }
//        int widthSpec = ViewGroup.getChildMeasureSpec(0, 0, lp.width);
//        int lpHeight = lp.height;
//        int heightSpec;
//        if (lpHeight!=0) {
//            heightSpec = View.MeasureSpec.makeMeasureSpec(lpHeight, View.MeasureSpec.EXACTLY);
//        } else {
//            heightSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
//        }
//        view.measure(widthSpec, heightSpec);
//        return new int[]{view.getMeasuredWidth(), view.getMeasuredHeight()};
//    }

}