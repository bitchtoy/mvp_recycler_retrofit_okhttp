package com.sequoia.mvpdemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sequoia.mvpdemo.bean.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator.
 * @date 2018/5/23.
 * @funtion
 */
public class Adapter extends RecyclerView.Adapter<Adapter.BaseViewHolder> {
    private List<Data.Subjects.Casts> mList;
    private Context mContext;
    private static final int NORMAL = 5002;
    private static final int FOOT = 5003;
    public Adapter(List<Data.Subjects.Casts> list, Context context) {
        mList = list;
        mContext = context;
    }
    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == NORMAL){
            View normal = LayoutInflater.from(mContext).inflate(R.layout.item_layout,parent,false);
            return new Normal(normal);
        }else if (viewType == FOOT){
            View foot = LayoutInflater.from(mContext).inflate(R.layout.item_foot,parent,false);
            return new FootViewHolder(foot);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
       if (holder instanceof Normal){
           Glide.with(((Normal) holder).mImageView).load(mList.get(position).alt);
       }

    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size()+1;
    }

    public static class BaseViewHolder extends RecyclerView.ViewHolder{

        public BaseViewHolder(View itemView) {
            super(itemView);
        }
    }
    public static class Normal extends BaseViewHolder{
        ImageView mImageView;
        TextView tv;
        public Normal(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.item_img);
            tv = itemView.findViewById(R.id.item_text);
        }
    }
    public static class FootViewHolder extends BaseViewHolder {
        public FootViewHolder(View itemView) {
            super(itemView);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position>= mList.size()){
            return FOOT;
        }
        return NORMAL;
    }
}
