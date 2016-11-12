package com.example.andresarango.automaticpancake.sample_package;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SampleService {

    public final static String CHUCK_NORRIS_BASE_URL = "https://api.chucknorris.io/";

    @GET("jokes/random")
    Call<SamplePOJO> getRandomJoke();
}