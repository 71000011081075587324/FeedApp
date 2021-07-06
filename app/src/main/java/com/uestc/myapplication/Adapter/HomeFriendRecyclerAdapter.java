package com.uestc.myapplication.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

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

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class HomeFriendRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private List<FeedStreamBean.ArticleData> mDatas;
    private static final int ONEIMAGE = 0;
    private static final int MOREIMAGE = 1;


    public HomeFriendRecyclerAdapter(Context context, List<FeedStreamBean.ArticleData> datas){
        mContext = context;
        mDatas = datas;
    }


    //为子项加载布局
    @NonNull
    @NotNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
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

        if(holder instanceof HomeFriendRecyclerAdapter.FriendViewHolder ){
            ImageRecyclerAdapter imageRecyclerAdapter = new ImageRecyclerAdapter(mContext,null);
            ((FriendViewHolder) holder).mRcyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
            ((FriendViewHolder) holder).mRcyclerView.setAdapter(imageRecyclerAdapter);
            ((FriendViewHolder) holder).mRcyclerView.setHasFixedSize(true);
            ((SimpleItemAnimator) ((FriendViewHolder) holder).mRcyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        }
    }


    @Override
    public int getItemCount() {
        return 8;
//        return mDatas.size();
    }

    //重写ViewType的返回值
    @Override
    public int getItemViewType(int position) {
        int size = 8;
        if(size < 2){
            return ONEIMAGE;
        }else{
            return MOREIMAGE;
        }
    }


    static class FriendViewHolder extends RecyclerView.ViewHolder{
        private RecyclerView mRcyclerView;
        private ImageView mImageViewProfile;
        private TailTextView mTailTextView;

        public FriendViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            initView(itemView);

            itemView.setOnClickListener(v->{
                itemView.getContext().startActivity(new Intent(itemView.getContext(), HomeDetailActivity.class));
            });

            mTailTextView.setOnClickListener((v)->{
                itemView.getContext().startActivity(new Intent(itemView.getContext(), HomeDetailActivity.class));
            });

        }

        public void initView(final View itemView){
            mRcyclerView = itemView.findViewById(R.id.recycler_view_image);
            mImageViewProfile = itemView.findViewById(R.id.iv_profile);
            mTailTextView = itemView.findViewById(R.id.ttv_text);

//            mTailTextView.setHighlightColor(itemView.getResources().getColor(android.R.color.holo_blue_bright));

            //设置圆形用户头像
            RequestOptions options = new RequestOptions()
                    .error(R.drawable.profile_image_2)
                    .placeholder(R.drawable.profile_image_2)
                    .transforms(new CircleCrop());
            Glide.with(itemView)
                    .load(R.drawable.profile_image_2)
                    .apply(options)
                    .into(mImageViewProfile);
        }
    }

    static class ImageOneViewHolder extends RecyclerView.ViewHolder{
        private ImageView mImageView;
        private ImageView mImageViewProfile;
        private TailTextView mTailTextView;

         public ImageOneViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
             mTailTextView = itemView.findViewById(R.id.ttv_text);

             mTailTextView.setOnClickListener((v)->{
                 itemView.getContext().startActivity(new Intent(itemView.getContext(), HomeDetailActivity.class));
             });
//             mTailTextView.setHighlightColor(itemView.getResources().getColor(android.R.color.holo_blue_bright));

            mImageView = itemView.findViewById(R.id.iv_one_item_recycler);
            DisplayMetrics displayMetrics = itemView.getResources().getDisplayMetrics();

            ViewGroup.LayoutParams layoutParams = mImageView.getLayoutParams();
            layoutParams.width = displayMetrics.widthPixels * 4 / 5;
            layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
            mImageView.setLayoutParams(layoutParams);

            mImageView.setMaxWidth(displayMetrics.widthPixels);
            mImageView.setMaxHeight(displayMetrics.heightPixels * 3 / 5);

             itemView.setOnClickListener(v->{
                 itemView.getContext().startActivity(new Intent(itemView.getContext(), HomeDetailActivity.class));
             });


             mImageViewProfile = itemView.findViewById(R.id.iv_profile);
             //设置圆形用户头像
             RequestOptions options = new RequestOptions()
                     .error(R.drawable.profile_image_2)
                     .placeholder(R.drawable.profile_image_2)
                     .transforms(new CircleCrop());
             Glide.with(itemView)
                     .load(R.drawable.profile_image_2)
                     .apply(options)
                     .into(mImageViewProfile);

         }
    }

}
