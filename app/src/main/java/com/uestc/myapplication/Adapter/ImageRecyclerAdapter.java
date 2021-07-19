package com.uestc.myapplication.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.uestc.myapplication.R;
import com.uestc.myapplication.ui.activity.ImageShowActivity;
import com.uestc.myapplication.ui.fragment.ImageShowFragment;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ImageRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
//    private List<Uri> mImageDatas;
    private int mImageCount;


//    public ImageRecyclerAdapter(Context context, List<Uri> ImageData){
//        mContext = context;
//        mImageDatas = ImageData;
//    }

    public ImageRecyclerAdapter(Context context, int imageCount){
        mContext = context;
        mImageCount = imageCount;
    }



    @NonNull
    @NotNull
    @Override
    public ImageMoreViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        ImageMoreViewHolder imageMoreViewHolder = new ImageMoreViewHolder(LayoutInflater
                .from(mContext).inflate(R.layout.item_recycler_more_image, parent,false));
        return imageMoreViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerView.ViewHolder holder, int position) {
        ((ImageMoreViewHolder)holder).mImageView.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putInt("imageCount", mImageCount);
            bundle.putInt("position", position);
            Intent intent = new Intent(mContext, ImageShowActivity.class);
            intent.putExtras(bundle);
            mContext.startActivity(intent);
        });
    }


    @Override
    public int getItemCount() {
//        return mImageDatas.size();
//        return 8;
        return mImageCount;
    }


    static class ImageMoreViewHolder extends RecyclerView.ViewHolder{
        private ImageView mImageView;
        private FrameLayout mFrameLayout;

        public ImageMoreViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.iv_item_recycler);
            mFrameLayout = itemView.findViewById(R.id.fl_item_image);
            DisplayMetrics displayMetrics = itemView.getResources().getDisplayMetrics();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(displayMetrics.widthPixels * 7 / 24,
                    displayMetrics.widthPixels * 7 / 24);
            mFrameLayout.setLayoutParams(layoutParams);
            mImageView.setLayoutParams(layoutParams);
//            //设置文字位置
//            // 1.用FontMetrics对象计算高度
//            Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
//            int textHeight = fontMetricsInt.bottom - fontMetricsInt.top;//文本高度
//            int paddingTop = (mImageSize - textHeight) / 2;
//            //方法一：设置居中,setGravity(Gravity.CENTER)只显示为水平居中，所以需要设置padding
//            textView.setPadding(0, paddingTop, 0, paddingTop);
//            textView.setGravity(Gravity.CENTER)


        }
    }


}
