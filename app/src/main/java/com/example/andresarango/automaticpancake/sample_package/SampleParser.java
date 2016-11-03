package com.example.andresarango.automaticpancake.sample_package;

import com.example.andresarango.automaticpancake.utility.CardHolderPOJO;
import com.example.andresarango.automaticpancake.utility.POJOParser;

/**
 * Created by andresarango on 11/2/16.
 */



/*This class is an example of something that, when instantiated, will parse the response.body
*
* In this case I expect to get a SamplePOJO who's value I will use to set a field in my
* SampleCardHolderPOJO object.
* */
public class SampleParser implements POJOParser {
    @Override
    public <T> CardHolderPOJO parseServicePOJOs(T toParse) {
        SampleCardHolderPOJO cardHolder = new SampleCardHolderPOJO();
        cardHolder.setValue(((SamplePOJO) toParse).value);
        return cardHolder;
    }
}
