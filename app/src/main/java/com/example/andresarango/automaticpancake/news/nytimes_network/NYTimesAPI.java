package com.example.andresarango.automaticpancake.news.nytimes_network;

import com.example.andresarango.automaticpancake.BuildConfig;
import com.example.andresarango.automaticpancake.news.nytimespojo.Article;
import com.example.andresarango.automaticpancake.utility.networks.NetworkServices;

import retrofit2.Call;

/**
 * Created by andresarango on 11/7/16.
 */

public class NYTimesAPI {
    private String BASE_NYTIMES_URL = "https://api.nytimes.com/";
    private String NYTIMES_TOP_ARTICLES_API_KEY = BuildConfig.NYTIMES_API_KEY;
    private final NYTimesService apiService;

    private static NYTimesAPI instance;

    public static NYTimesAPI getInstance(){
        if(instance == null){
            instance = new NYTimesAPI();
        }
        return instance;
    }

    private NYTimesAPI(){
        apiService = (new NetworkServices()).getJSONService(BASE_NYTIMES_URL,NYTimesService.class);
    }

    public Call<Article> getSection(String section){
        return apiService.newsStory(section,NYTIMES_TOP_ARTICLES_API_KEY);
    }
}
