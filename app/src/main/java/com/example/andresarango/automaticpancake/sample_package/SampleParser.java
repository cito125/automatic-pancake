package com.example.andresarango.automaticpancake.sample_package;

import com.example.andresarango.automaticpancake.utility.GoogleNowCardHolder;
import com.example.andresarango.automaticpancake.utility.networks.GoogleNowCardParser;

/**
 * Created by andresarango on 11/2/16.
 */



/*This class is an example of something that, when instantiated, will parse the response.body
*
* In this case I expect to get a SamplePOJO who's value I will use to set a field in my
* SampleGoogleNowCardHolder object.
* */
public class SampleParser implements GoogleNowCardParser {
    @Override
    public <T> GoogleNowCardHolder parseService(T toParse) {
        SampleGoogleNowCardHolder cardHolder = new SampleGoogleNowCardHolder();
        cardHolder.setValue(((SamplePOJO) toParse).value);
        return cardHolder;
    }
}
