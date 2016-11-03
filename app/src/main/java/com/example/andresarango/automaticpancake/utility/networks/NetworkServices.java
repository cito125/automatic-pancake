package com.example.andresarango.automaticpancake.utility.networks;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by andresarango on 11/1/16.
 */

public class NetworkServices {

    public <T> T getServiceObject(String base_url, Class<T> interfaceService){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(interfaceService);
    }




}
