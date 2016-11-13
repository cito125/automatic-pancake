package com.example.andresarango.automaticpancake.horoscope;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.andresarango.automaticpancake.R;
import com.example.andresarango.automaticpancake.utility.CardViewHolder;
import com.example.andresarango.automaticpancake.utility.GoogleNowCardHolder;

/**
 * Created by catwong on 11/12/16.
 */

public class HoroscopePOJO implements GoogleNowCardHolder{

    public final static String HOROSCOPE_BASE_URL = "http://horoscope-api.herokuapp.com/";

    private String sunsign;
    private String week;
    private String year;
    private String lord;
    private String lucky_color;
    private String type;
    private String lucky_number;
    private String meaning_of_name;
    private String sanskrit_name;


    @Override
    public CardViewHolder POJOViewholder(ViewGroup parent) {
        return new HoroscopeViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.horoscope_card, parent, false));
    }

}
