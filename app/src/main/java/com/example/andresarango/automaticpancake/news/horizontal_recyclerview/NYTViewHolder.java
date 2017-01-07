package com.example.andresarango.automaticpancake.news.horizontal_recyclerview;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import com.example.andresarango.automaticpancake.R;
import com.example.andresarango.automaticpancake.utility.CardViewHolder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by andresarango on 10/30/16.
 */

public class NYTViewHolder extends CardViewHolder {
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

    public NYTViewHolder(View itemView) {
        super(itemView);
        mContext = itemView.getContext();
        mNewsOptionRecycler = (RecyclerView) itemView.findViewById(R.id.nyt_news_op_recycle);

    }

    @Override
    public void bindViewHolder(Object obj) {

        mNewsOptionRecycler.setLayoutManager(
                new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        final NYTOptRCAdapter newsOptionAdapter = new NYTOptRCAdapter();
        mNewsOptionRecycler.setAdapter(newsOptionAdapter);
        newsOptionAdapter.setCardHolderList(mNewsOptionList);

        ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.UP | ItemTouchHelper.DOWN) {

            @Override
            public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                int swipeFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
                return makeMovementFlags(0, swipeFlags);
            }

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public boolean isItemViewSwipeEnabled() {
                return true;
            }


            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                newsOptionAdapter.removeCard(position);
            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(mNewsOptionRecycler);
    }


}
