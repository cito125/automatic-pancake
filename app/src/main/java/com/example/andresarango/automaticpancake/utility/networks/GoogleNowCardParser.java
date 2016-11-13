package com.example.andresarango.automaticpancake.utility.networks;

import com.example.andresarango.automaticpancake.utility.GoogleNowCardHolder;

/**
 * Created by andresarango on 11/1/16.
 * <p>
 * POJO parser takes the response.body() of your call and parses it for whatever data you want
 * bound to your GoogleNowCardHolder*
 * <p>
 * ex.
 * If your service interface returns Call<dog>, dog will be passed into parseService in
 * CallToCardholder. If one needs a DogCardHolder of the dog's bark and color. The GoogleNowCardParser
 * should parse dog for it's bark and color, bind that data to a DogCardHolder object and then
 * return that DogCardHolder object.
 */

public interface GoogleNowCardParser {

    <T> GoogleNowCardHolder parseService(T toParse);
}
