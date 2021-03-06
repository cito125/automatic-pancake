package com.example.andresarango.automaticpancake.cat.network;

import com.example.andresarango.automaticpancake.cat.model.CatMemePOJO;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * http://thecatapi.com/api/images/get?api_key=MTMzNDM2&format=src&results_per_page=1
 */

public interface CatAPIService {

    @GET("images/get?api_key=MTMzNDM2&format=xml&results_per_page=1")
    Call<CatMemePOJO> getCatMeme();
}
