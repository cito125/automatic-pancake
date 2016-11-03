package com.example.andresarango.automaticpancake.sample_package;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SampleService {

    @GET("jokes/random")
    Call<SamplePOJO> getRandomJoke();
}