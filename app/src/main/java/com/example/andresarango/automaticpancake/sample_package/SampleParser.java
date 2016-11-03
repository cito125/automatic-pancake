package com.example.andresarango.automaticpancake.sample_package;

import com.example.andresarango.automaticpancake.utility.CardHolderPOJO;
import com.example.andresarango.automaticpancake.utility.POJOParser;

/**
 * Created by andresarango on 11/2/16.
 */

public class SampleParser implements POJOParser {
    @Override
    public <T> CardHolderPOJO parseServicePOJOs(T toParse) {
        SampleCardHolderPOJO testCard = new SampleCardHolderPOJO();
        return testCard;
    }
}
