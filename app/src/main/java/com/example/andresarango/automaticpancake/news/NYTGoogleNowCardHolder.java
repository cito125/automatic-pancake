package com.example.andresarango.automaticpancake.news;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.andresarango.automaticpancake.R;
import com.example.andresarango.automaticpancake.news.horizontal_recyclerview.NYTViewHolder;
import com.example.andresarango.automaticpancake.utility.GoogleNowCardHolder;
import com.example.andresarango.automaticpancake.utility.CardViewHolder;

/**
 * Created by andresarango on 10/30/16.
 */

public class NYTGoogleNowCardHolder implements GoogleNowCardHolder {
    @Override
    public CardViewHolder POJOViewholder(ViewGroup parent) {
        return new NYTViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.aanyt_news_card, parent, false));
    }

}
