package com.uestc.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    static class DetailCommentViewHolder extends RecyclerView.ViewHolder {

        public DetailCommentViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

        }
    }
}
