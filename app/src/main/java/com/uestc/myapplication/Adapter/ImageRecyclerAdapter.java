package com.uestc.myapplication.Adapter;

import android.content.Context;
import android.net.Uri;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.uestc.myapplication.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Random;

public class ImageRecyclerAdapter extends RecyclerView.Adapter<ImageRecyclerAdapter.ImageViewHolder> {
    private Context mContext;
    private List<Uri> mImageDatas;


    public ImageRecyclerAdapter(Context context, List<Uri> ImageData){
        mContext = context;
        mImageDatas = ImageData;
    }

    @NonNull
    @NotNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        ImageViewHolder imageViewHolder = new ImageViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_recycler_image,parent,false));
        return imageViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ImageRecyclerAdapter.ImageViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {

        return 3;
    }

    static class ImageViewHolder extends RecyclerView.ViewHolder{
        private ImageView mImageView;

        public ImageViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.iv_item_recycler);
        }
    }
}
