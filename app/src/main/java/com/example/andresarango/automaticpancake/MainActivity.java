package com.example.andresarango.automaticpancake;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.andresarango.automaticpancake.sample_package.SampleCardHolderPOJO;
import com.example.andresarango.automaticpancake.sample_package.SamplePOJO;
import com.example.andresarango.automaticpancake.sample_package.SampleParser;
import com.example.andresarango.automaticpancake.sample_package.SampleService;
import com.example.andresarango.automaticpancake.utility.CardHolderPOJO;
import com.example.andresarango.automaticpancake.utility.networks.CardHolderCall;
import com.example.andresarango.automaticpancake.utility.networks.NetworkServices;
import com.example.andresarango.automaticpancake.utility.networks.POJOCallback;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements POJOCallback {
    private RecyclerView mCardRecycler;
    private CardRecycleAdapter mCardAdapter;
    private List<CardHolderCall> mNetworkList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCardRecycler = (RecyclerView) findViewById(R.id.card_recycler);
        mCardRecycler.setLayoutManager(new LinearLayoutManager(this));
        mCardAdapter = new CardRecycleAdapter();
        mCardRecycler.setAdapter(mCardAdapter);
        NetworkServices netServe = new NetworkServices();
        for (int i = 0; i < 10; i++) {
            mCardAdapter.addCardHolderToEnd(new SampleCardHolderPOJO());
        }

        for (int i = 0; i <10 ; i++) {
            mNetworkList.add(
                    new CardHolderCall<SamplePOJO>(
                            new SampleParser(),
                            netServe.getServiceObject(
                                    SamplePOJO.CHUCK_NORRIS_BASE_URL,
                                    SampleService.class).getRandomJoke(),
                            this));
        }

        for (int i = 0; i < mNetworkList.size(); i++) {
                mNetworkList.get(i).makeCall();
        }




    }

    @Override
    public void callback(CardHolderPOJO pojo) {
        if(pojo != null) {
            mCardAdapter.addCardHolderToEnd(pojo);
        }
    }
}
