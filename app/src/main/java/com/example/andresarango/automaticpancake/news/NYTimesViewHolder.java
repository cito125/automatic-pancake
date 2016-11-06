package com.example.andresarango.automaticpancake.news;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.andresarango.automaticpancake.R;
import com.example.andresarango.automaticpancake.utility.CardViewHolder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by andresarango on 10/30/16.
 */

public class NYTimesViewHolder extends CardViewHolder {
    int yo = 0;
    Context mContext;
    private RecyclerView mNewsOptionRecycler;
    private List<String> mNewsOptionList = new ArrayList<String>(Arrays.asList("home",
            "opinion",
            "world",
            "national",
            "politics",
            "upshot",
            "nyregion",
            "business",
            "technology",
            "science",
            "health",
            "sports",
            "arts",
            "books",
            "movies",
            "theater",
            "sundayreview",
            "fashion",
            "tmagazine",
            "food",
            "travel",
            "magazine",
            "realestate",
            "automobiles",
            "obituaries",
            "insider"));

    public NYTimesViewHolder(View itemView) {
        super(itemView);
        mContext = itemView.getContext();
        mNewsOptionRecycler = (RecyclerView) itemView.findViewById(R.id.nyt_news_op_recycle);

    }

    @Override
    public void bindViewHolder(Object obj) {

        mNewsOptionRecycler.setLayoutManager(
                new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false));
        NYTNewsOptionRCAdapter newsOptionAdapter = new NYTNewsOptionRCAdapter();
        mNewsOptionRecycler.setAdapter(newsOptionAdapter);
        newsOptionAdapter.setCardHolderList(mNewsOptionList);
    }

}
