package com.example.andresarango.automaticpancake.news;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.andresarango.automaticpancake.R;
import com.example.andresarango.automaticpancake.news.nytimes_horizant_rc.NYTimesViewHolder;
import com.example.andresarango.automaticpancake.utility.GoogleNowCardHolder;
import com.example.andresarango.automaticpancake.utility.CardViewHolder;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by andresarango on 10/30/16.
 */

public class NYTimesGoogleNowCardHolder implements GoogleNowCardHolder {
    @Override
    public CardViewHolder POJOViewholder(ViewGroup parent) {
        return new NYTimesViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.aanyt_news_card, parent, false));
    }
    
}
