package com.example.andresarango.automaticpancake.horoscope.views;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.andresarango.automaticpancake.R;
import com.example.andresarango.automaticpancake.horoscope.models.DisplayHoroscopeCardHolder;
import com.example.andresarango.automaticpancake.utility.CardViewHolder;

/**
 * Created by catwong on 11/12/16.
 */

public class DisplayHoroscopeViewHolder extends CardViewHolder {

    ImageView image_sign;
    TextView date;
    TextView sunsign;
    TextView horoscope;

    public DisplayHoroscopeViewHolder(View itemView) {
        super(itemView);
        image_sign = (ImageView) itemView.findViewById(R.id.iv_sign_image);
        date = (TextView) itemView.findViewById(R.id.tv_date);
        sunsign = (TextView) itemView.findViewById(R.id.tv_sunsign);
        horoscope = (TextView) itemView.findViewById(R.id.tv_horoscope);
    }

    @Override
    public void bindViewHolder(Object obj) {
        DisplayHoroscopeCardHolder horoscopePOJO = (DisplayHoroscopeCardHolder) obj;
        date.setText(horoscopePOJO.getDate());
        sunsign.setText(horoscopePOJO.getSunsign());
        horoscope.setText(horoscopePOJO.getHoroscope());
    }

}
