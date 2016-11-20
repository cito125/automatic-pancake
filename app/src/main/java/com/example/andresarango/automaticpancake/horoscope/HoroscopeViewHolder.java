package com.example.andresarango.automaticpancake.horoscope;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.andresarango.automaticpancake.R;
import com.example.andresarango.automaticpancake.cat.CatCardViewHolder;
import com.example.andresarango.automaticpancake.horoscope.HoroscopeNetwork.HoroscopeService;
import com.example.andresarango.automaticpancake.horoscope.HoroscopePOJO.DisplayHoroscope;
import com.example.andresarango.automaticpancake.horoscope.HoroscopePOJO.HoroscopePOJO;
import com.example.andresarango.automaticpancake.utility.CardViewHolder;
import com.example.andresarango.automaticpancake.utility.networks.NetworkServices;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by catwong on 11/12/16.
 */

public class HoroscopeViewHolder extends CardViewHolder {

    private static final String LOG = CatCardViewHolder.class.getSimpleName();
    private final Context mContext;

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

    public HoroscopeViewHolder(View itemView) {
        super(itemView);

        mContext = itemView.getContext();

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

        aries.setOnClickListener(onClickHoroscope());
        taurus.setOnClickListener(onClickHoroscope());
        gemini.setOnClickListener(onClickHoroscope());
        cancer.setOnClickListener(onClickHoroscope());
        leo.setOnClickListener(onClickHoroscope());
        virgo.setOnClickListener(onClickHoroscope());
        libra.setOnClickListener(onClickHoroscope());
        scorpio.setOnClickListener(onClickHoroscope());
        sagittarius.setOnClickListener(onClickHoroscope());
        capricorn.setOnClickListener(onClickHoroscope());
        aquarius.setOnClickListener(onClickHoroscope());
        pisces.setOnClickListener(onClickHoroscope());
    }

    private View.OnClickListener onClickHoroscope() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToHoroscopePage(view);
            }
        };
    }

    public void goToHoroscopePage(View view) {
        if (view.getId() == R.id.bt_aries)
            getHoroscopeInfo("Aries");
        if (view.getId() == R.id.bt_taurus)
            getHoroscopeInfo("Taurus");
        if (view.getId() == R.id.bt_gemini)
            getHoroscopeInfo("Gemini");
        if (view.getId() == R.id.bt_cancer)
            getHoroscopeInfo("Cancer");
        if (view.getId() == R.id.bt_leo)
            getHoroscopeInfo("Leo");
        if (view.getId() == R.id.bt_virgo)
            getHoroscopeInfo("Virgo");
        if (view.getId() == R.id.bt_libra)
            getHoroscopeInfo("Libra");
        if (view.getId() == R.id.bt_scorpio)
            getHoroscopeInfo("Scorpio");
        if (view.getId() == R.id.bt_sagittarius)
            getHoroscopeInfo("Sagittarius");
        if (view.getId() == R.id.bt_capricorn)
            getHoroscopeInfo("Capricorn");
        if (view.getId() == R.id.bt_aquarius)
            getHoroscopeInfo("Aquarius");
        if (view.getId() == R.id.bt_pisces) {
            getHoroscopeInfo("Pisces");

        }
    }

    public void getHoroscopeInfo(String sign) {
        NetworkServices networkServices = new NetworkServices();
        HoroscopeService service = networkServices.getJSONService(HoroscopePOJO.HOROSCOPE_BASE_URL, HoroscopeService.class);
        Call<DisplayHoroscope> call = service.getTodayHoroscope(sign);
        call.enqueue(new Callback<DisplayHoroscope>() {
            @Override
            public void onResponse(Call<DisplayHoroscope> call, Response<DisplayHoroscope> response) {
                DisplayHoroscope displayHoroscope = response.body();
                HoroscopeFragment horoscopeFragment = HoroscopeFragment.attainDisplayHoroscope(displayHoroscope);

                ((Activity) mContext)
                        .getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.tv_horoscope_frag, horoscopeFragment)
                        .commit();
            }

            @Override
            public void onFailure(Call<DisplayHoroscope> call, Throwable t) {

            }
        });

    }

    @Override
    public void bindViewHolder(Object obj) {

    }


}
