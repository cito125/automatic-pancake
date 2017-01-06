package com.example.andresarango.automaticpancake.horoscope.HoroscopeNetwork;

import com.example.andresarango.automaticpancake.horoscope.HoroscopePOJOs.DisplayHoroscope;

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
    Call<DisplayHoroscope> getTodayHoroscope(@Path("sign")String sunsign);

    @GET("/horoscope/week/{sunsign}")
    Call<DisplayHoroscope> getWeekHoroscope(@Query("sign")String sunsign);

    @GET("/horoscope/month/{sunsign}")
    Call<DisplayHoroscope> getMonthHoroscope(@Query("sign")String sunsign);

    @GET("knowmore/{sunsign}")
    Call<DisplayHoroscope> getMoreInfo(@Query("sign")String sunsign);
}
