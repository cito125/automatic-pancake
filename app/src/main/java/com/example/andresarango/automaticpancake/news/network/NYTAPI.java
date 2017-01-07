package com.example.andresarango.automaticpancake.news.network;

import com.example.andresarango.automaticpancake.BuildConfig;
import com.example.andresarango.automaticpancake.news.model.Article;
import com.example.andresarango.automaticpancake.utility.networks.NetworkServices;

import retrofit2.Call;

/**
 * Created by andresarango on 11/7/16.
 */

public class NYTAPI {
    private String BASE_NYTIMES_URL = "https://api.nytimes.com/";
    private String NYTIMES_TOP_ARTICLES_API_KEY = BuildConfig.NYTIMES_API_KEY;
    private final NYTService apiService;

    private static NYTAPI instance;

    public static NYTAPI getInstance() {
        if (instance == null) {
            instance = new NYTAPI();
        }
        return instance;
    }

    private NYTAPI() {
        apiService = (new NetworkServices()).getJSONService(BASE_NYTIMES_URL, NYTService.class);
    }

    public Call<Article> getSection(String section) {
        return apiService.newsStory(section, NYTIMES_TOP_ARTICLES_API_KEY);
    }
}
