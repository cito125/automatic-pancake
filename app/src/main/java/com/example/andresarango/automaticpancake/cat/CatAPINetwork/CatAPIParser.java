package com.example.andresarango.automaticpancake.cat.CatAPINetwork;


import com.example.andresarango.automaticpancake.cat.CatAPIPOJO.CatMemePOJO;
import com.example.andresarango.automaticpancake.utility.GoogleNowCardHolder;
import com.example.andresarango.automaticpancake.utility.networks.GoogleNowCardParser;

/**
 * Created by catwong on 11/9/16.
 */

public class CatAPIParser implements GoogleNowCardParser {

    @Override
    public <T> GoogleNowCardHolder parseService(T toParse) {
        CatMemePOJO cardHolder = new CatMemePOJO();
        cardHolder.setResponse(((CatMemePOJO) toParse).getResponse());
        return cardHolder;
    }
}
