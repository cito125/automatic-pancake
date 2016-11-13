package com.example.andresarango.automaticpancake.horoscope;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.andresarango.automaticpancake.cat.CatCardViewHolder;
import com.example.andresarango.automaticpancake.utility.CardViewHolder;
import com.example.andresarango.automaticpancake.R;


/**
 * Created by catwong on 11/12/16.
 */

public class HoroscopeViewHolder extends CardViewHolder {

    private static final String LOG = CatCardViewHolder.class.getSimpleName();
    CardView horoscopeCard;
    TextView dailyHoroscope;
    ImageView daily_forecast;
    Button aries;
    Button taurus;
    Button gemini;
    Button cancer;
    Button leo;
    Button virgo;
    Button libra;
    Button scorpio;
    Button sagittarius;
    Button capricorn;
    Button aquarius;
    Button pisces;
    TextView tv_aries;
    TextView tv_taurus;
    TextView tv_gemini;
    TextView tv_cancer;
    TextView tv_leo;
    TextView tv_virgo;
    TextView tv_libra;
    TextView tv_scorpio;
    TextView tv_sagittarius;
    TextView tv_capricorn;
    TextView tv_aquarius;
    TextView tv_pisces;


    public HoroscopeViewHolder(View itemView) {
        super(itemView);
        daily_forecast = (ImageView) itemView.findViewById(R.id.iv_daily_horoscope);
        aries = (Button) itemView.findViewById(R.id.bt_aries);
        taurus = (Button) itemView.findViewById(R.id.bt_taurus);
        gemini = (Button) itemView.findViewById(R.id.bt_gemini);
        cancer = (Button) itemView.findViewById(R.id.bt_cancer);
        leo = (Button) itemView.findViewById(R.id.bt_leo);
        virgo = (Button) itemView.findViewById(R.id.bt_virgo);
        libra = (Button) itemView.findViewById(R.id.bt_libra);
        scorpio = (Button) itemView.findViewById(R.id.bt_scorpio);
        sagittarius = (Button) itemView.findViewById(R.id.bt_sagittarius);
        capricorn = (Button) itemView.findViewById(R.id.bt_capricorn);
        aquarius = (Button) itemView.findViewById(R.id.bt_aquarius);
        pisces = (Button) itemView.findViewById(R.id.bt_pisces);
        tv_aries = (TextView) itemView.findViewById(R.id.tv_aries);
        tv_taurus = (TextView) itemView.findViewById(R.id.tv_taurus);
        tv_gemini = (TextView) itemView.findViewById(R.id.tv_gemini);
        tv_cancer = (TextView) itemView.findViewById(R.id.tv_cancer);
        tv_leo = (TextView) itemView.findViewById(R.id.tv_leo);
        tv_virgo = (TextView) itemView.findViewById(R.id.tv_virgo);
        tv_libra = (TextView) itemView.findViewById(R.id.tv_libra);
        tv_scorpio = (TextView) itemView.findViewById(R.id.tv_scorpio);
        tv_sagittarius = (TextView) itemView.findViewById(R.id.tv_sagittarius);
        tv_capricorn = (TextView) itemView.findViewById(R.id.tv_capricorn);
        tv_aquarius = (TextView) itemView.findViewById(R.id.tv_aquarius);


    }

    @Override
    public void bindViewHolder(Object obj) {


    }

}
