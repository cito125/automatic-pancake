package com.example.andresarango.automaticpancake.utility.networks;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by andresarango on 11/1/16.
 */

public class NetworkServices {

    /*
    * Network Services holds methods that make dealing with network related things easier. These
    * methods should be implementable by any object involved in the retrofit network process.
    * */

    public <T> T getServiceObject(String base_url, Class<T> networkServiceInterface){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(networkServiceInterface);
    }




}
