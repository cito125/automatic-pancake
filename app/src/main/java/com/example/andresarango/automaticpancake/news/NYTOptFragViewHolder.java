package com.example.andresarango.automaticpancake.news;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.andresarango.automaticpancake.R;

/**
 * Created by andresarango on 11/5/16.
 */

public class NYTOptFragViewHolder extends RecyclerView.ViewHolder {
    TextView mNYTOptTV;

    public NYTOptFragViewHolder(View itemView) {
        super(itemView);
        mNYTOptTV = (TextView) itemView.findViewById(R.id.nyt_news_op_tv);
    }

    protected void onBind(String newsOption){
        mNYTOptTV.setText(newsOption);
    }
}
