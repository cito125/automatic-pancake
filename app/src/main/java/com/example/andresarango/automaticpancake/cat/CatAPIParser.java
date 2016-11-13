package com.example.andresarango.automaticpancake.cat;

import com.example.andresarango.automaticpancake.utility.CardHolderPOJO;
import com.example.andresarango.automaticpancake.utility.POJOParser;

/**
 * Created by catwong on 11/9/16.
 */

public class CatAPIParser implements POJOParser {
    @Override
    public <T> CardHolderPOJO parseServicePOJOs(T toParse) {
        CatMemePOJO cardHolder = new CatMemePOJO();
        cardHolder.setResponse(((CatMemePOJO) toParse).getResponse());
        return cardHolder;
    }
}
