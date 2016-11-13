package com.example.andresarango.automaticpancake.horoscope;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.andresarango.automaticpancake.R;
import com.example.andresarango.automaticpancake.utility.CardViewHolder;
import com.example.andresarango.automaticpancake.utility.GoogleNowCardHolder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by catwong on 11/12/16.
 */

public class DisplayHoroscope implements GoogleNowCardHolder {

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

    public void setDate(String date) {
        this.date = date;
    }

    public String getHoroscope() {
        return horoscope;
    }

    public void setHoroscope(String horoscope) {
        this.horoscope = horoscope;
    }

    public String getSunsign() {
        return sunsign;
    }

    public void setSunsign(String sunsign) {
        this.sunsign = sunsign;
    }



    @Override
    public CardViewHolder POJOViewholder(ViewGroup parent) {
        return new DisplayHoroscopeViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.horoscope_text, parent, false));
    }
}
