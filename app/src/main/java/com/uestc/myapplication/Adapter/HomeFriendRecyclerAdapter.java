package com.uestc.myapplication.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.uestc.myapplication.Custom.TailTextView;
import com.uestc.myapplication.R;
import com.uestc.myapplication.bean.FeedStreamBean;
import com.uestc.myapplication.ui.activity.HomeDetailActivity;
import com.uestc.myapplication.ui.activity.ImageShowActivity;
import com.uestc.myapplication.utils.SharedPreferencesUtils;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class HomeFriendRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {
    private Context mContext;
    private List<FeedStreamBean.ArticleData> mDatas;
    private static final int ONEIMAGE = 0;
    private static final int MOREIMAGE = 1;
    private static final int KEY_ARTICLE = 0;
    private Boolean isLike = false;

    private SharedPreferencesUtils mSharedPreferencesUtils;


    public HomeFriendRecyclerAdapter(Context context, List<FeedStreamBean.ArticleData> datas){
        mContext = context;
        mDatas = datas;
        mSharedPreferencesUtils = SharedPreferencesUtils.getInstance(mContext);
//        mSharedPreferencesUtils.putBoolean("isLike", isLike);
    }


    //为子项加载布局
    @NonNull
    @NotNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

        Log.e(getClass().getSimpleName(), "onCreateViewHolder ->");

        RecyclerView.ViewHolder holder = null;

        switch (viewType){
            case ONEIMAGE:
                holder = new ImageOneViewHolder(LayoutInflater.from(mContext)
                        .inflate(R.layout.item_recycler_home_friend_one_image,parent,false));
                break;
            case MOREIMAGE:
                holder = new FriendViewHolder(LayoutInflater.from(mContext)
                        .inflate(R.layout.item_recycler_home_friend,parent,false));
                break;
        }

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerView.ViewHolder holder, int position) {

        Log.e(getClass().getSimpleName(), "position" + position);
        Bundle bundle = new Bundle();
        bundle.putParcelable("data", mDatas.get(position));
        bundle.putInt("position",position);
//        bundle.putBoolean("isLike", isLike);

        //设置圆形用户头像
        RequestOptions options = new RequestOptions()
                .error(R.drawable.profile_error)
                .placeholder(R.drawable.profile_error)
                .transforms(new CircleCrop());

        if(holder instanceof HomeFriendRecyclerAdapter.FriendViewHolder){
            ImageRecyclerAdapter imageRecyclerAdapter = new ImageRecyclerAdapter(mContext,mDatas.get(position).getPic_ids().toString().split(",").length);
            ((FriendViewHolder) holder).mRcyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
            ((FriendViewHolder) holder).mRcyclerView.setAdapter(imageRecyclerAdapter);
            ((FriendViewHolder) holder).mRcyclerView.setHasFixedSize(true);
            ((SimpleItemAnimator) ((FriendViewHolder) holder).mRcyclerView.getItemAnimator()).setSupportsChangeAnimations(false);

            ((FriendViewHolder) holder).mTailTextView.setText(mDatas.get(position).getText());
//            //设置圆形用户头像
//            RequestOptions options = new RequestOptions()
//                    .error(R.drawable.profile_error)
//                    .placeholder(R.drawable.profile_error)
//                    .transforms(new CircleCrop());
            switch (position % 4){
                case 0 :
                    Glide.with(holder.itemView)
                            .load(R.drawable.profile_image_0)
                            .apply(options)
                            .into(((FriendViewHolder) holder).mImageViewProfile);
//                    ((ImageOneViewHolder) holder).mImageViewProfile.setImageResource(R.drawable.profile_image_0);
                    break;
                case 1:
                    Glide.with(holder.itemView)
                            .load(R.drawable.profile_image_1)
                            .apply(options)
                            .into(((FriendViewHolder) holder).mImageViewProfile);
//                    ((ImageOneViewHolder) holder).mImageViewProfile.setImageResource(R.drawable.profile_image_1);
                    break;
                case 2:
                    Glide.with(holder.itemView)
                            .load(R.drawable.profile_image_2)
                            .apply(options)
                            .into(((FriendViewHolder) holder).mImageViewProfile);
//                    ((ImageOneViewHolder) holder).mImageViewProfile.setImageResource(R.drawable.profile_image_2);
                    break;
                case 3:
                    Glide.with(holder.itemView)
                            .load(R.drawable.profile_image_3)
                            .apply(options)
                            .into(((FriendViewHolder) holder).mImageViewProfile);
//                    ((ImageOneViewHolder) holder).mImageViewProfile.setImageResource(R.drawable.profile_image_3);
                    break;
            }
            ((FriendViewHolder) holder).mTextViewName.setText(mDatas.get(position).getUser().getScreen_name());
            ((FriendViewHolder) holder).mTextViewTime.setText(mDatas.get(position).getCreated_at());
            ((FriendViewHolder) holder).mTextViewModel.setText(mDatas.get(position).getSource());

            ((FriendViewHolder) holder).mTailTextView.setOnClickListener(v->{
                Intent intent = new Intent(mContext, HomeDetailActivity.class);
                intent.putExtra("Detail",bundle);
                ((Activity)mContext).startActivityForResult(intent,KEY_ARTICLE);
            });

            ((FriendViewHolder) holder).mLinearLayoutLike.setOnClickListener(v -> {
                if(isLike){
                    isLike = false;
                    ((FriendViewHolder) holder).mImageViewLike.setImageResource(R.drawable.praise);
                    ((FriendViewHolder) holder).mTextViewLikeCount.setText(mDatas.get(position).getLike_count() + "");
                }else{
                    isLike = true;
                    ((FriendViewHolder) holder).mImageViewLike.setImageResource(R.drawable.praise_press);
                    ((FriendViewHolder) holder).mTextViewLikeCount.setText(mDatas.get(position).getLike_count() + 1 + "");
                }
                mSharedPreferencesUtils.putBoolean("isLike" + mDatas.get(position).getId(), isLike);
//                bundle.putBoolean("isLike", isLike);
            });
            if(mSharedPreferencesUtils.readBoolean("isLike" + mDatas.get(position).getId())){
                ((FriendViewHolder) holder).mImageViewLike.setImageResource(R.drawable.praise_press);
                ((FriendViewHolder) holder).mTextViewLikeCount.setText(mDatas.get(position).getLike_count() + 1 + "");
            }else{
                ((FriendViewHolder) holder).mImageViewLike.setImageResource(R.drawable.praise);
                ((FriendViewHolder) holder).mTextViewLikeCount.setText(mDatas.get(position).getLike_count() + "");
            }

            ((FriendViewHolder) holder).mRcyclerView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    return ((FriendViewHolder) holder).itemView.onTouchEvent(event);
                }
            });

            //最后一个item的下方去掉分割线
            if(position == mDatas.size() - 1){
                ((FriendViewHolder) holder).mViewDecoration.setVisibility(View.INVISIBLE);
            }else{
                ((FriendViewHolder) holder).mViewDecoration.setVisibility(View.VISIBLE);
            }

        }else{
            ((ImageOneViewHolder) holder).mTailTextView.setText(mDatas.get(position).getText());
//            //设置圆形用户头像
//            RequestOptions options = new RequestOptions()
//                    .error(R.drawable.profile_error)
//                    .placeholder(R.drawable.profile_error)
//                    .transforms(new CircleCrop());
            switch (position % 4){
                case 0 :
                    Glide.with(holder.itemView)
                            .load(R.drawable.profile_image_0)
                            .apply(options)
                            .into(((ImageOneViewHolder) holder).mImageViewProfile);
//                    ((ImageOneViewHolder) holder).mImageViewProfile.setImageResource(R.drawable.profile_image_0);
                    break;
                case 1:
                    Glide.with(holder.itemView)
                            .load(R.drawable.profile_image_1)
                            .apply(options)
                            .into(((ImageOneViewHolder) holder).mImageViewProfile);
//                    ((ImageOneViewHolder) holder).mImageViewProfile.setImageResource(R.drawable.profile_image_1);
                    break;
                case 2:
                    Glide.with(holder.itemView)
                            .load(R.drawable.profile_image_2)
                            .apply(options)
                            .into(((ImageOneViewHolder) holder).mImageViewProfile);
//                    ((ImageOneViewHolder) holder).mImageViewProfile.setImageResource(R.drawable.profile_image_2);
                    break;
                case 3:
                    Glide.with(holder.itemView)
                            .load(R.drawable.profile_image_3)
                            .apply(options)
                            .into(((ImageOneViewHolder) holder).mImageViewProfile);
//                    ((ImageOneViewHolder) holder).mImageViewProfile.setImageResource(R.drawable.profile_image_3);
                    break;
            }
            ((ImageOneViewHolder) holder).mTextViewName.setText(mDatas.get(position).getUser().getScreen_name());
            ((ImageOneViewHolder) holder).mTextViewTime.setText(mDatas.get(position).getCreated_at());
            ((ImageOneViewHolder) holder).mTextViewModel.setText(mDatas.get(position).getSource());

            ((ImageOneViewHolder) holder).mTailTextView.setOnClickListener((v)->{
//                Intent intent = new Intent(mContext, HomeDetailActivity.class);
//                ((Activity)mContext).startActivityForResult(intent,KEY_ARTICLE,bundle);
                Intent intent = new Intent(mContext, HomeDetailActivity.class);
                intent.putExtra("Detail",bundle);
                ((Activity)mContext).startActivityForResult(intent,KEY_ARTICLE);
            });

            //最后一个item的下方去掉分割线
            if(position == mDatas.size() - 1){
                ((ImageOneViewHolder) holder).mViewDecoration.setVisibility(View.INVISIBLE);
            }else{
                ((ImageOneViewHolder) holder).mViewDecoration.setVisibility(View.VISIBLE);
            }


            ((ImageOneViewHolder) holder).mImageView.setOnClickListener(v -> {
                bundle.putInt("imageCount",mDatas.get(position).getPic_ids().toString().split(",").length);
                Intent intent = new Intent(mContext, ImageShowActivity.class);
                intent.putExtras(bundle);
                mContext.startActivity(intent);
            });

            //点赞相关逻辑
            ((ImageOneViewHolder) holder).mLinearLayoutLike.setOnClickListener(v -> {
                if(isLike){
                    isLike = false;
                    ((ImageOneViewHolder) holder).mImageViewLike.setImageResource(R.drawable.praise);
                    ((ImageOneViewHolder) holder).mTextViewLikeCount.setText(mDatas.get(position).getLike_count() + "");
                }else{
                    isLike = true;
                    ((ImageOneViewHolder) holder).mImageViewLike.setImageResource(R.drawable.praise_press);
                    ((ImageOneViewHolder) holder).mTextViewLikeCount.setText(mDatas.get(position).getLike_count() + 1 + "");
                }
//                bundle.putBoolean("isLike", isLike);
                mSharedPreferencesUtils.putBoolean("isLike" + mDatas.get(position).getId(), isLike);
            });
            if(mSharedPreferencesUtils.readBoolean( "isLike" + mDatas.get(position).getId())){
                ((ImageOneViewHolder) holder).mImageViewLike.setImageResource(R.drawable.praise_press);
                ((ImageOneViewHolder) holder).mTextViewLikeCount.setText(mDatas.get(position).getLike_count() + 1 + "");
            }else{
                ((ImageOneViewHolder) holder).mImageViewLike.setImageResource(R.drawable.praise);
                ((ImageOneViewHolder) holder).mTextViewLikeCount.setText(mDatas.get(position).getLike_count() + "");
            }

        }

        holder.itemView.setOnClickListener((v) -> {
            Intent intent = new Intent(mContext, HomeDetailActivity.class);
            intent.putExtra("Detail",bundle);
            ((Activity)mContext).startActivityForResult(intent,KEY_ARTICLE);
//            ((Activity)mContext).startActivityForResult(intent,KEY_ARTICLE,bundle);
        });



    }


    @Override
    public int getItemCount() {
//        return 8;
        return mDatas.size();
    }

    //重写ViewType的返回值
    @Override
    public int getItemViewType(int position) {
        Log.e(getClass().getSimpleName(), "size = " +  mDatas.get(position).getPic_ids().toString().split(",").length);
        int count = mDatas.get(position).getPic_ids().toString().split(",").length;
        if(count < 2){
            return ONEIMAGE;
        }else{
            return MOREIMAGE;
        }
    }



    static class FriendViewHolder extends RecyclerView.ViewHolder{
        private RecyclerView mRcyclerView;
        private ImageView mImageViewProfile;
        private TailTextView mTailTextView;
        private TextView mTextViewName;
        private TextView mTextViewTime;
        private TextView mTextViewModel;
        private View mViewDecoration;
        private LinearLayout mLinearLayoutLike;
//        private ImageButton mImageButtonLike;
        private ImageView mImageViewLike;
        private TextView mTextViewLikeCount;


        public FriendViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            initView(itemView);

//            itemView.setOnClickListener(v->{
//                itemView.getContext().startActivity(new Intent(itemView.getContext(), HomeDetailActivity.class));
//            });
//
//            mTailTextView.setOnClickListener((v)->{
//                itemView.getContext().startActivity(new Intent(itemView.getContext(), HomeDetailActivity.class));
//            });

        }

        public void initView(final View itemView){
            mRcyclerView = itemView.findViewById(R.id.recycler_view_image);
            mImageViewProfile = itemView.findViewById(R.id.iv_profile);
            mTailTextView = itemView.findViewById(R.id.ttv_text);
            mTextViewName = itemView.findViewById(R.id.tv_name);
            mTextViewTime = itemView.findViewById(R.id.tv_time);
            mTextViewModel = itemView.findViewById(R.id.tv_model);
            mViewDecoration = itemView.findViewById(R.id.view_item_decoration_recycle_home_friend);
            mLinearLayoutLike = itemView.findViewById(R.id.ll_like);
            mImageViewLike = itemView.findViewById(R.id.iv_like);
            mTextViewLikeCount = itemView.findViewById(R.id.tv_like_count);
//            mTailTextView.setHighlightColor(itemView.getResources().getColor(android.R.color.holo_blue_bright));
//
//            //设置圆形用户头像
//            RequestOptions options = new RequestOptions()
//                    .error(R.drawable.profile_image_2)
//                    .placeholder(R.drawable.profile_image_2)
//                    .transforms(new CircleCrop());
//            Glide.with(itemView)
//                    .load(R.drawable.profile_image_2)
//                    .apply(options)
//                    .into(mImageViewProfile);
        }
    }

    static class ImageOneViewHolder extends RecyclerView.ViewHolder{
        private ImageView mImageView;
        private ImageView mImageViewProfile;
        private TailTextView mTailTextView;
        private TextView mTextViewName;
        private TextView mTextViewTime;
        private TextView mTextViewModel;
        private View mViewDecoration;
        private LinearLayout mLinearLayoutLike;
//        private ImageButton mImageButtonLike;
        private ImageView mImageViewLike;
        private TextView mTextViewLikeCount;


         public ImageOneViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
             mImageViewProfile = itemView.findViewById(R.id.iv_profile);
             mTailTextView = itemView.findViewById(R.id.ttv_text);
             mTextViewName = itemView.findViewById(R.id.tv_name);
             mTextViewTime = itemView.findViewById(R.id.tv_time);
             mTextViewModel = itemView.findViewById(R.id.tv_model);
             mViewDecoration = itemView.findViewById(R.id.view_item_decoration_recycle_home_friend);
             mLinearLayoutLike = itemView.findViewById(R.id.ll_like);
             mImageViewLike = itemView.findViewById(R.id.iv_like);
             mTextViewLikeCount = itemView.findViewById(R.id.tv_like_count);

             mTailTextView = itemView.findViewById(R.id.ttv_text);

//             mTailTextView.setOnClickListener((v)->{
//                 itemView.getContext().startActivity(new Intent(itemView.getContext(), HomeDetailActivity.class));
//             });
//             mTailTextView.setHighlightColor(itemView.getResources().getColor(android.R.color.holo_blue_bright));

            mImageView = itemView.findViewById(R.id.iv_one_item_recycler);
            DisplayMetrics displayMetrics = itemView.getResources().getDisplayMetrics();

            ViewGroup.LayoutParams layoutParams = mImageView.getLayoutParams();
            layoutParams.width = displayMetrics.widthPixels * 4 / 5;
            layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
            mImageView.setLayoutParams(layoutParams);

            mImageView.setMaxWidth(displayMetrics.widthPixels);
            mImageView.setMaxHeight(displayMetrics.heightPixels * 3 / 5);

//             itemView.setOnClickListener(v->{
//                 itemView.getContext().startActivity(new Intent(itemView.getContext(), HomeDetailActivity.class));
//             });


//             mImageViewProfile = itemView.findViewById(R.id.iv_profile);
//             //设置圆形用户头像
//             RequestOptions options = new RequestOptions()
//                     .error(R.drawable.profile_image_2)
//                     .placeholder(R.drawable.profile_image_2)
//                     .transforms(new CircleCrop());
//             Glide.with(itemView)
//                     .load(R.drawable.profile_image_2)
//                     .apply(options)
//                     .into(mImageViewProfile);

         }
    }

}
