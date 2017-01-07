package com.example.andresarango.automaticpancake.horoscope.models;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.andresarango.automaticpancake.R;
import com.example.andresarango.automaticpancake.horoscope.views.DisplayHoroscopeViewHolder;
import com.example.andresarango.automaticpancake.utility.CardViewHolder;
import com.example.andresarango.automaticpancake.utility.GoogleNowCardHolder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by catwong on 11/12/16.
 */

public class DisplayHoroscopeCardHolder implements GoogleNowCardHolder, Serializable {

    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("horoscope")
    @Expose
    private String horoscope;
    @SerializedName("sunsign")
    @Expose
    private String sunsign;

    public String getDate() {
        return date;
    }


    public String getHoroscope() {
        return horoscope;
    }


    public String getSunsign() {
        return sunsign;
    }


    @Override
    public CardViewHolder POJOViewholder(ViewGroup parent) {
        return new DisplayHoroscopeViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.horoscope_text, parent, false));
    }
}
