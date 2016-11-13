package com.example.andresarango.automaticpancake.sample_package;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.andresarango.automaticpancake.utility.GoogleNowCardHolder;
import com.example.andresarango.automaticpancake.R;
import com.example.andresarango.automaticpancake.utility.CardViewHolder;

/**
 * Created by andresarango on 10/31/16.
 */

public class SampleGoogleNowCardHolder implements GoogleNowCardHolder {

    String icon_url;
    String id;
    String url;
    String value;

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public CardViewHolder POJOViewholder(ViewGroup parent) {
        return new SampleViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.sample_card, parent, false));
    }
}
