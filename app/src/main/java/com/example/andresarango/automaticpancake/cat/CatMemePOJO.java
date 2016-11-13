package com.example.andresarango.automaticpancake.cat;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.andresarango.automaticpancake.R;
import com.example.andresarango.automaticpancake.sample_package.SampleViewHolder;
import com.example.andresarango.automaticpancake.utility.CardHolderPOJO;
import com.example.andresarango.automaticpancake.utility.CardViewHolder;

/**
 * http://thecatapi.com/api/images/get?api_key=MTMzNDM2&format=src&results_per_page=1
 */

public class CatMemePOJO implements CardHolderPOJO {

    private Response response;


    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    @Override
    public CardViewHolder POJOViewholder(ViewGroup parent) {
        return new CatCardViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.cat_card, parent, false));

    }
}
