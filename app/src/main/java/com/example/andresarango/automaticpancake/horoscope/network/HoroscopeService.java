package com.example.andresarango.automaticpancake.horoscope.network;

import com.example.andresarango.automaticpancake.horoscope.models.DisplayHoroscopeCardHolder;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * GET http://horoscope-api.herokuapp.com/horoscope/today/Libra
 * GET http://horoscope-api.herokuapp.com/horoscope/week/libra
 * GET http://horoscope-api.herokuapp.com/horoscope/month/libra
 * GET http://horoscope-api.herokuapp.com/knowmore/libra
 */

public interface HoroscopeService {

    @GET("/horoscope/today/{sign}")
    Call<DisplayHoroscopeCardHolder> getTodayHoroscope(@Path("sign")String sunsign);

    @GET("/horoscope/week/{sunsign}")
    Call<DisplayHoroscopeCardHolder> getWeekHoroscope(@Query("sign")String sunsign);

    @GET("/horoscope/month/{sunsign}")
    Call<DisplayHoroscopeCardHolder> getMonthHoroscope(@Query("sign")String sunsign);

    @GET("knowmore/{sunsign}")
    Call<DisplayHoroscopeCardHolder> getMoreInfo(@Query("sign")String sunsign);
}
