package com.uestc.myapplication.ui.activity;

import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.tabs.TabLayout;
import com.uestc.myapplication.Adapter.HomeDetailFragmentAdapter;
import com.uestc.myapplication.Adapter.ImageRecyclerAdapter;
import com.uestc.myapplication.R;
import com.uestc.myapplication.base.activity.BaseActivity;
import com.uestc.myapplication.base.fragment.BaseFragment;
import com.uestc.myapplication.bean.FeedStreamBean;
import com.uestc.myapplication.ui.fragment.DetailCommentFragment;
import com.uestc.myapplication.ui.fragment.DetailPraiseFragment;
import com.uestc.myapplication.utils.SharedPreferencesUtils;

import java.util.ArrayList;
import java.util.List;

public class HomeDetailActivity extends BaseActivity implements View.OnClickListener {
    private RecyclerView mRecyclerView;
//    private List<Uri> mImageDatas;
    private ImageRecyclerAdapter mImageRecyclerAdapter;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private View mIncludeOne;
    private View mIncludeMore;
    private ImageView mImageViewProfile;
    private ImageView mImageViewExit;
    private NestedScrollView mNestedScrollView;
    private TextView mTextViewName;
    private TextView mTextViewTime;
    private TextView mTextViewModel;
    private TextView mTextViewArticle;
    private LinearLayout mLinearLayoutLike;
    private ImageView mImageViewLike;
    private TextView mTextViewLikeCount;
    private ImageView mImageViewOneImage;

    private FeedStreamBean.ArticleData mDatas;
    private int mPosition;
    private Boolean isLike;

    private SharedPreferencesUtils mSharedPreferencesUtils;

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
        mSharedPreferencesUtils = SharedPreferencesUtils.getInstance(this);
        initData();
        initView();
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


    private void initData(){
        Bundle bundle = getIntent().getBundleExtra("Detail");
        mDatas = bundle.getParcelable("data");
        mPosition = bundle.getInt("position");

        isLike = mSharedPreferencesUtils.readBoolean("isLike");
//        isLike = bundle.getBoolean("isLike");
    }

    private void initView(){
        mIncludeOne = findViewById(R.id.include_text_home_friend_one_image);
        mIncludeMore = findViewById(R.id.include_text_home_friend_more_image);
        mImageViewExit = findViewById(R.id.btn_title_bar_exit);
        mRecyclerView = findViewById(R.id.recycler_view_image);
        mLinearLayoutLike = findViewById(R.id.ll_like_detail);
        mImageViewLike = findViewById(R.id.iv_like_detail);
        mTextViewLikeCount = findViewById(R.id.tv_like_count_detail);


        if(mDatas.getPic_ids().toString().split(",").length < 2){
            mIncludeMore.setVisibility(View.GONE);
            mImageViewProfile = mIncludeOne.findViewById(R.id.iv_profile);
            mImageViewOneImage = mIncludeOne.findViewById(R.id.iv_one_item_recycler);

            mTextViewName = findViewById(R.id.tv_name);
            mTextViewTime = findViewById(R.id.tv_time);
            mTextViewModel = findViewById(R.id.tv_model);
            mTextViewArticle = findViewById(R.id.tv_article);

        }else{
            mIncludeOne.setVisibility(View.GONE);
            mImageRecyclerAdapter = new ImageRecyclerAdapter(this, mDatas.getPic_ids().toString().split(",").length);
//            mTextViewArticle = mIncludeMore.findViewById(R.id.tv_article);
            mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
            mRecyclerView.setAdapter(mImageRecyclerAdapter);
            mRecyclerView.setHasFixedSize(true);
            ((SimpleItemAnimator) mRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);

            mTextViewName = mIncludeMore.findViewById(R.id.tv_name);
            mTextViewTime = mIncludeMore.findViewById(R.id.tv_time);
            mTextViewModel = mIncludeMore.findViewById(R.id.tv_model);
            mTextViewArticle = mIncludeMore.findViewById(R.id.tv_article);
            //设置圆形用户头像
            mImageViewProfile = mIncludeMore.findViewById(R.id.iv_profile);
        }

        mTextViewTime.setText(mDatas.getCreated_at());
        mTextViewName.setText(mDatas.getUser().getScreen_name());
        mTextViewModel.setText(mDatas.getSource());
        mTextViewArticle.setText(mDatas.getText());

        RequestOptions options = new RequestOptions()
                .error(R.drawable.profile_error)
                .placeholder(R.drawable.profile_error)
                .transforms(new CircleCrop());
        switch (mPosition % 4){
            case 0 :
                Glide.with(this)
                        .load(R.drawable.profile_image_0)
                        .apply(options)
                        .into(mImageViewProfile);
                break;
            case 1:
                Glide.with(this)
                        .load(R.drawable.profile_image_1)
                        .apply(options)
                        .into(mImageViewProfile);
//                    ((ImageOneViewHolder) holder).mImageViewProfile.setImageResource(R.drawable.profile_image_1);
                break;
            case 2:
                Glide.with(this)
                        .load(R.drawable.profile_image_2)
                        .apply(options)
                        .into(mImageViewProfile);
//                    ((ImageOneViewHolder) holder).mImageViewProfile.setImageResource(R.drawable.profile_image_2);
                break;
            case 3:
                Glide.with(this)
                        .load(R.drawable.profile_image_3)
                        .apply(options)
                        .into(mImageViewProfile);
//                    ((ImageOneViewHolder) holder).mImageViewProfile.setImageResource(R.drawable.profile_image_3);
                break;
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

        if(isLike){
            mImageViewLike.setImageResource(R.drawable.praise_press);
            mTextViewLikeCount.setText(mDatas.getLike_count() + 1 + "");
        }else{
            mImageViewLike.setImageResource(R.drawable.praise);
            mTextViewLikeCount.setText(mDatas.getLike_count() + "");
        }

        mLinearLayoutLike.setOnClickListener(v -> {
            if(isLike){
                isLike = false;
                mImageViewLike.setImageResource(R.drawable.praise);
                mTextViewLikeCount.setText(mDatas.getLike_count() + "");
            }else{
                isLike = true;
                mImageViewLike.setImageResource(R.drawable.praise_press);
                mTextViewLikeCount.setText(mDatas.getLike_count() + 1 + "");
            }
            mSharedPreferencesUtils.putBoolean("isLike",isLike);
        });

    }

    private void initClickListener(){
        mImageViewExit.setOnClickListener(this);
        mImageViewOneImage.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
             case R.id.btn_title_bar_exit:
                finish();
                break;
            case R.id.iv_one_item_recycler:
                Bundle bundle = new Bundle();
                bundle.putInt("imageCount",mDatas.getPic_ids().toString().split(",").length);
                Intent intent = new Intent(this, ImageShowActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
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