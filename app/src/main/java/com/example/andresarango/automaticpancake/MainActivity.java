package com.example.andresarango.automaticpancake;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.andresarango.automaticpancake.cat.CatAPIParser;
import com.example.andresarango.automaticpancake.cat.CatAPIService;
import com.example.andresarango.automaticpancake.cat.CatCardViewHolder;
import com.example.andresarango.automaticpancake.cat.CatMemePOJO;
import com.example.andresarango.automaticpancake.cat.Image;
import com.example.andresarango.automaticpancake.horoscope.DisplayHoroscope;
import com.example.andresarango.automaticpancake.horoscope.HoroscopePOJO;
import com.example.andresarango.automaticpancake.horoscope.HoroscopeService;
import com.example.andresarango.automaticpancake.sample_package.SampleCardHolderPOJO;
import com.example.andresarango.automaticpancake.sample_package.SamplePOJO;
import com.example.andresarango.automaticpancake.sample_package.SampleParser;
import com.example.andresarango.automaticpancake.sample_package.SampleService;
import com.example.andresarango.automaticpancake.utility.CardHolderPOJO;
import com.example.andresarango.automaticpancake.utility.POJOParser;
import com.example.andresarango.automaticpancake.utility.networks.CardHolderCall;
import com.example.andresarango.automaticpancake.utility.networks.NetworkServices;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mCardRecycler;
    private CardRecycleAdapter mCardAdapter;
    private List<CardHolderCall> mNetworkList = new ArrayList<>();
    private RelativeLayout buttonsLayout;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCardRecycler = (RecyclerView) findViewById(R.id.card_recycler);
        mCardRecycler.setLayoutManager(new LinearLayoutManager(this));
        mCardAdapter = new CardRecycleAdapter();
        mCardRecycler.setAdapter(mCardAdapter);
        buttonsLayout = (RelativeLayout) findViewById(R.id.horoscope_buttons_layout);
        NetworkServices netServe = new NetworkServices();
//        for (int i = 0; i < 3; i++) {
//            mCardAdapter.addCardHolderToEnd(new SampleCardHolderPOJO());
//        }

        mCardAdapter.addCardHolderToEnd(new HoroscopePOJO());

//        for (int i = 0; i < 10; i++) {
//            mNetworkList.add(
//                    new CardHolderCall<>(
//                            new SampleParser(),
//                            netServe.getJSONService(
//                                    SamplePOJO.CHUCK_NORRIS_BASE_URL,
//                                    SampleService.class).getRandomJoke(),
//                            mCardAdapter));
//        }

        mCardAdapter.addCardHolder(new CatMemePOJO(), 0);
        makeNetworkListCall();

    }


    public void makeNetworkListCall() {
        for (int i = 0; i < mNetworkList.size(); i++) {
            mNetworkList.get(i).makeCall();
        }

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
                DisplayHoroscope horoscopePOJO = response.body();
                mCardAdapter.addCardHolder(horoscopePOJO, 2);
            }

            @Override
            public void onFailure(Call<DisplayHoroscope> call, Throwable t) {

            }
        });

    }
}

