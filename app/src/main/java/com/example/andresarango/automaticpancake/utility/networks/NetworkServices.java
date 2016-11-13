package com.example.andresarango.automaticpancake.utility.networks;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by andresarango on 11/1/16.
 * <p>
 * Network Services holds methods that make dealing with network related things easier. These
 * methods should be implementable by any object involved in the retrofit network process.
 */

public class NetworkServices {


    public <T> T getJSONService(String base_url, Class<T> networkServiceInterface) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(networkServiceInterface);
    }

    public <T> T getXMLService(String base_url, Class<T> networkServiceInterface) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(base_url)
                .client(new OkHttpClient())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();
        return retrofit.create(networkServiceInterface);
    }
}
