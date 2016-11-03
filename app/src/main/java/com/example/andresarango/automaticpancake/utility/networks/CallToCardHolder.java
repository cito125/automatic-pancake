package com.example.andresarango.automaticpancake.utility.networks;


import com.example.andresarango.automaticpancake.utility.POJOParser;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by andresarango on 11/1/16.
 */

public class CallToCardHolder<T> {

    private POJOParser pojoParser;
    private POJOCallback giveMeThispojo;
    private Call<T> serviceCall;
    public CallToCardHolder(POJOParser pojoParser, Call<T> serviceCall, POJOCallback poReturn){
        this.pojoParser = pojoParser;
        this.serviceCall = serviceCall;
        giveMeThispojo = poReturn;
    }

    public void gsonToCardHolder(){
        runServeMesThreadForCardHolderPOJO(serviceCall,pojoParser);
    }


    private   <T> void runServeMesThreadForCardHolderPOJO( Call<T> call, final POJOParser parser){
        call.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                if(response.isSuccessful()) {
                    giveMeThispojo.callback(parser.parseServicePOJOs(response.body()));
                }else{
                }
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                // Something went completely wrong (like no internet connection)

            }
        });


    }
}
