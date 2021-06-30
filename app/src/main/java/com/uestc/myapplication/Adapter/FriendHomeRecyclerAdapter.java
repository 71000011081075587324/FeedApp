package com.uestc.myapplication.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.uestc.myapplication.R;
import com.uestc.myapplication.bean.HomeArticleBean;
import com.uestc.myapplication.ui.activity.HomeFriendDetailActivity;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class FriendHomeRecyclerAdapter extends RecyclerView.Adapter<FriendHomeRecyclerAdapter.FriendViewHolder> {
    private Context mContext;
    private List<HomeArticleBean.ArticleData> mDatas;

    public FriendHomeRecyclerAdapter(Context context, List<HomeArticleBean.ArticleData> datas){
        mContext = context;
        mDatas = datas;
    }


    //为子项加载布局
    @NonNull
    @NotNull
    @Override
    public FriendViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        FriendViewHolder holder = new FriendViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_recycler_home_friend,parent,false));
        return holder;
    }

    //为子项绑定数据
    @Override
    public void onBindViewHolder(@NonNull @NotNull FriendHomeRecyclerAdapter.FriendViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    static class FriendViewHolder extends RecyclerView.ViewHolder{

        public FriendViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            initView();

            itemView.setOnClickListener(v->{
                itemView.getContext().startActivity(new Intent(itemView.getContext(), HomeFriendDetailActivity.class));
            });

        }

        public void initView(){
        }
    }

}
