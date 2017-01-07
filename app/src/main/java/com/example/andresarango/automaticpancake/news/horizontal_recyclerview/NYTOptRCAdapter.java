package com.example.andresarango.automaticpancake.news.horizontal_recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.andresarango.automaticpancake.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andresarango on 11/5/16.
 */

public class NYTOptRCAdapter extends RecyclerView.Adapter<NYTOptViewHolder> {
    private List<String> mNewsOptionsList = new ArrayList<>();

    @Override
    public NYTOptViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NYTOptViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.aanyt_news_option_viewholder, parent, false));

    }

    @Override
    public void onBindViewHolder(NYTOptViewHolder holder, int position) {
        holder.onBind(mNewsOptionsList.get(position));
    }

    protected void setCardHolderList(List<String> updateList) {
        mNewsOptionsList.clear();
        mNewsOptionsList.addAll(updateList);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mNewsOptionsList.size();
    }

    public void removeCard(int position) {
        mNewsOptionsList.remove(position);
        notifyItemRemoved(position);
    }
}
