package com.example.andresarango.automaticpancake.news.nytimes_network;

import com.example.andresarango.automaticpancake.BuildConfig;
import com.example.andresarango.automaticpancake.news.nytimespojo.Article;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by andresarango on 11/4/16.
 */

public interface NYTimesService {
/*https://api.nytimes.com/svc/topstories/v2/science.json*/

    public static String BASE_NYTIMES_URL = "https://api.nytimes.com/";
    public static String NYTIMES_TOP_ARTICLES_API_KEY = BuildConfig.NYTIMES_API_KEY;
    @GET("svc/topstories/v2/{section}.json")
    Call<Article> getRandomJoke(@Path("section") String section, @Query("api-key") String apikey);
}

