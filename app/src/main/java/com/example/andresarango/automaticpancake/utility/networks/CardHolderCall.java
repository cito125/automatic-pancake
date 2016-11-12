package com.example.andresarango.automaticpancake.utility.networks;


import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by andresarango on 11/1/16.
 * <p>
 * * CardHolderCall takes in an object to parsePOJO's, a call, and a callback object in it's
 * constructor.
 * <p>
 * * POJOparser takes the response.body() of your call and parses it for whatever data you want
 * bound to your CardHolderPOJO
 * <p>
 * <p>
 * POJOCallback is the listener the POJOParser will return the CardHolder object to. It should
 * probably be the main activity.
 * <p>
 * Call<T> is the call to be made.
 */

public class CardHolderCall<T> {


    private POJOParser mPOJOParser;
    private POJOCallback mListener;
    private Call<T> mServiceCall;


    public CardHolderCall(POJOParser parser, Call<T> call, POJOCallback listener) {
        mPOJOParser = parser;
        mServiceCall = call;
        mListener = listener;
    }

    public void makeCall() {
        runServiceThreadForCardHolderPOJO(mServiceCall, mPOJOParser);
    }


    /*starts an async task off the main activity that will add a CardHolderPOJO to the CardRecycleAdapter
    * of the main activity once the task is finished.*/
    private void runServiceThreadForCardHolderPOJO(Call<T> call, final POJOParser parser) {
        call.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                if (response.isSuccessful()) {
                    mListener.callback(parser.parseServicePOJOs(response.body()));
                } else {
                    Log.d("TEAM_6---------", "response unsuccessful, keep trying");
                }
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                // Something went completely wrong (like no internet connection)
                Log.d("TEAM_6-----------", "something is really off");
            }
        });


    }
}
