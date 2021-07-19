package com.uestc.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.uestc.myapplication.R;
import com.uestc.myapplication.bean.HomeDetailCommentBean;
import com.uestc.myapplication.ui.fragment.DetailCommentFragment;

import org.jetbrains.annotations.NotNull;

public class HomeDetailCommentAdapter extends RecyclerView.Adapter<HomeDetailCommentAdapter.DetailCommentViewHolder> {
    private Context mContext;

    //数据项有了之后还要加入数据项
    public HomeDetailCommentAdapter(Context context){
        mContext = context;
    }

    @NonNull
    @NotNull
    @Override
    public DetailCommentViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        DetailCommentViewHolder holder = new DetailCommentViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_recycler_detail_comment,parent,false));
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull HomeDetailCommentAdapter.DetailCommentViewHolder holder, int position) {
        RequestOptions options = new RequestOptions()
                .error(R.drawable.profile_error)
                .placeholder(R.drawable.profile_error)
                .transforms(new CircleCrop());
        switch (position % 4){
            case 0 :
                Glide.with(mContext)
                        .load(R.drawable.profile_image_0)
                        .apply(options)
                        .into(holder.mImageViewHeadPortrait);
                break;
            case 1:
                Glide.with(mContext)
                        .load(R.drawable.profile_image_1)
                        .apply(options)
                        .into(holder.mImageViewHeadPortrait);
//                    ((ImageOneViewHolder) holder).mImageViewProfile.setImageResource(R.drawable.profile_image_1);
                break;
            case 2:
                Glide.with(mContext)
                        .load(R.drawable.profile_image_2)
                        .apply(options)
                        .into(holder.mImageViewHeadPortrait);
//                    ((ImageOneViewHolder) holder).mImageViewProfile.setImageResource(R.drawable.profile_image_2);
                break;
            case 3:
                Glide.with(mContext)
                        .load(R.drawable.profile_image_3)
                        .apply(options)
                        .into(holder.mImageViewHeadPortrait);
//                    ((ImageOneViewHolder) holder).mImageViewProfile.setImageResource(R.drawable.profile_image_3);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 30;
    }

    static class DetailCommentViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageViewHeadPortrait;

        public DetailCommentViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            mImageViewHeadPortrait = itemView.findViewById(R.id.iv_head_portrait);
        }
    }
}
