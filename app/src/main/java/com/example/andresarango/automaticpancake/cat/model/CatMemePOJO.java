package com.example.andresarango.automaticpancake.cat.model;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.andresarango.automaticpancake.R;
import com.example.andresarango.automaticpancake.cat.view.CatCardViewHolder;
import com.example.andresarango.automaticpancake.utility.CardViewHolder;
import com.example.andresarango.automaticpancake.utility.GoogleNowCardHolder;

/**
 * http://thecatapi.com/api/images/get?api_key=MTMzNDM2&format=src&results_per_page=1
 * <p>
 * <response>
 * <data>
 * <images>
 * <image>
 * <url>
 * http://24.media.tumblr.com/tumblr_m3vxk5jAZH1r81frto1_500.jpg
 * </url>
 * <id>4tk</id>
 * <source_url>http://thecatapi.com/?id=4tk</source_url>
 * </image>
 * </images>
 * </data>
 * </response>
 */

public class CatMemePOJO implements GoogleNowCardHolder {

    private Response response;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "ClassPojo [response = " + response + "]";
    }

    @Override
    public CardViewHolder POJOViewholder(ViewGroup parent) {
        return new CatCardViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.cat_card, parent, false));

    }
}
