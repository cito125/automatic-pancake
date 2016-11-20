package com.example.andresarango.automaticpancake;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import com.example.andresarango.automaticpancake.cat.CatAPINetwork.CatAPIService;
import com.example.andresarango.automaticpancake.cat.CatAPIPOJO.CatMemePOJO;
import com.example.andresarango.automaticpancake.horoscope.HoroscopeFragment;
import com.example.andresarango.automaticpancake.horoscope.HoroscopePOJO.DisplayHoroscope;
import com.example.andresarango.automaticpancake.horoscope.HoroscopePOJO.HoroscopePOJO;
import com.example.andresarango.automaticpancake.horoscope.HoroscopeNetwork.HoroscopeService;
import com.example.andresarango.automaticpancake.news.NYTimesGoogleNowCardHolder;
import com.example.andresarango.automaticpancake.reminder.RemindMe;
import com.example.andresarango.automaticpancake.utility.networks.GoogleNowCardCall;
import com.example.andresarango.automaticpancake.utility.networks.NetworkServices;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mCardRecycler;
    private CardRecycleAdapter mCardAdapter;
    private List<GoogleNowCardCall> mNetworkList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCardRecycler = (RecyclerView) findViewById(R.id.card_recycler);
        mCardRecycler.setLayoutManager(new LinearLayoutManager(this));
        mCardAdapter = new CardRecycleAdapter();
        mCardRecycler.setAdapter(mCardAdapter);
        ItemTouchHelper touchMeInDifferentWays = new ItemTouchHelper(new TouchMe(mCardAdapter));
        touchMeInDifferentWays.attachToRecyclerView(mCardRecycler);
        mCardAdapter.addCardHolderToEnd(new RemindMe());
        mCardAdapter.addCardHolderToEnd(new NYTimesGoogleNowCardHolder());
        mCardAdapter.addCardHolderToEnd(new CatMemePOJO());
        mCardAdapter.addCardHolderToEnd(new HoroscopePOJO());

        makeNetworkListCall();

    }

    public void makeNetworkListCall() {
        for (int i = 0; i < mNetworkList.size(); i++) {
            mNetworkList.get(i).makeCall();
        }

    }
}
