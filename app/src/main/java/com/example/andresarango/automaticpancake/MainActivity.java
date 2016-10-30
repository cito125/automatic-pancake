package com.example.andresarango.automaticpancake;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mCardRecycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCardRecycler = (RecyclerView) findViewById(R.id.card_recycler);
        mCardRecycler.setLayoutManager(new LinearLayoutManager(this));
        //Code to build list of pojos for card list
//        CardRecycleAdapter cardAdapter = new CardRecycleAdapter();
//        cardAdapter.setCardHolderList(); // argument is list of pojo objects
//        mCardRecycler.setAdapter(cardAdapter);
    }
}
