package com.example.andresarango.automaticpancake.horoscope.models;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.andresarango.automaticpancake.R;
import com.example.andresarango.automaticpancake.horoscope.views.HoroscopeViewHolder;
import com.example.andresarango.automaticpancake.utility.CardViewHolder;
import com.example.andresarango.automaticpancake.utility.GoogleNowCardHolder;

/**
 * Created by catwong on 11/12/16.
 */

public class HoroscopeCardHolder implements GoogleNowCardHolder {

    public final static String HOROSCOPE_BASE_URL = "http://horoscope-api.herokuapp.com/";

    @Override
    public CardViewHolder POJOViewholder(ViewGroup parent) {
        return new HoroscopeViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.horoscope_card, parent, false));
    }

}
