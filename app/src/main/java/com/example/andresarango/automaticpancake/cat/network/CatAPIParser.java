package com.example.andresarango.automaticpancake.cat.network;


import com.example.andresarango.automaticpancake.cat.model.CatMemePOJO;
import com.example.andresarango.automaticpancake.utility.networks.NetworkServices;

import retrofit2.Call;

/**
 * Created by catwong on 11/9/16.
 */

public class CatAPIParser {

    private String BASE_CAT_URL = "http://thecatapi.com/api/";
    private final CatAPIService apiService;


    private static CatAPIParser instance;

    public static CatAPIParser getInstance() {
        if (instance == null) {
            instance = new CatAPIParser();
        }
        return instance;
    }

    private CatAPIParser() {
        apiService = (new NetworkServices()).getXMLService(BASE_CAT_URL, CatAPIService.class);
    }

    public Call<CatMemePOJO> getCats() {
        return apiService.getCatMeme();
    }
}



