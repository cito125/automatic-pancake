package com.example.andresarango.automaticpancake.cat.CatAPINetwork;


import com.example.andresarango.automaticpancake.BuildConfig;
import com.example.andresarango.automaticpancake.cat.CatAPIPOJO.CatMemePOJO;
import com.example.andresarango.automaticpancake.news.nytimes_network.NYTimesAPI;
import com.example.andresarango.automaticpancake.news.nytimes_network.NYTimesService;
import com.example.andresarango.automaticpancake.news.nytimespojo.Article;
import com.example.andresarango.automaticpancake.utility.GoogleNowCardHolder;
import com.example.andresarango.automaticpancake.utility.networks.GoogleNowCardParser;
import com.example.andresarango.automaticpancake.utility.networks.NetworkServices;

import retrofit2.Call;

/**
 * Created by catwong on 11/9/16.
 */

public class CatAPIParser {

    private String BASE_CAT_URL = "http://thecatapi.com/api/";
    private String CAT_API_KEY = BuildConfig.CAT_API_KEY;
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



