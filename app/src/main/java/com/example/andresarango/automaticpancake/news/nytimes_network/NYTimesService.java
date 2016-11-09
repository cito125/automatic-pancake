package com.example.andresarango.automaticpancake.news.nytimes_network;

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


    @GET("svc/topstories/v2/{section}.json")
    Call<Article> newsStory(@Path("section") String section, @Query("api-key") String apikey);

}

