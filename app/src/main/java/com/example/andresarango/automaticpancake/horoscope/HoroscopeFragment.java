package com.example.andresarango.automaticpancake.horoscope;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.andresarango.automaticpancake.R;
import com.example.andresarango.automaticpancake.horoscope.HoroscopePOJO.DisplayHoroscope;


/**
 * Created by catwong on 11/19/16.
 */

public class HoroscopeFragment extends Fragment {

    private static final String DISPLAY_HOROSCOPE_KEY = "Horoscope";
    ImageView image_sign;
    TextView date;
    TextView sunsign;
    TextView horoscope;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.horoscope_view, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        image_sign = (ImageView) view.findViewById(R.id.iv_sign_image);
        date = (TextView) view.findViewById(R.id.tv_date);
        sunsign = (TextView) view.findViewById(R.id.tv_sunsign);
        horoscope = (TextView) view.findViewById(R.id.tv_horoscope);

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            DisplayHoroscope displayHoroscope = (DisplayHoroscope) bundle.getSerializable(DISPLAY_HOROSCOPE_KEY);
            bindViewHolder(displayHoroscope);
        }
    }

    public static HoroscopeFragment attainDisplayHoroscope(DisplayHoroscope displayHoroscope) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(DISPLAY_HOROSCOPE_KEY, displayHoroscope);
        HoroscopeFragment horoscopeFragment = new HoroscopeFragment();
        horoscopeFragment.setArguments(bundle);
        return horoscopeFragment;
    }


    private void bindViewHolder(DisplayHoroscope displayHoroscope) {
        DisplayHoroscope horoscopePOJO = displayHoroscope;
        date.setText(horoscopePOJO.getDate());
        sunsign.setText(horoscopePOJO.getSunsign());
        horoscope.setText(horoscopePOJO.getHoroscope());
    }

}
