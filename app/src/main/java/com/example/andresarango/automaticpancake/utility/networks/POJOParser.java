package com.example.andresarango.automaticpancake.utility.networks;

import com.example.andresarango.automaticpancake.utility.CardHolderPOJO;

/**
 * Created by andresarango on 11/1/16.
 *
 * POJO parser takes the response.body() of your call and parses it for whatever data you want
 * bound to your CardHolderPOJO*
 *
 * ex.
 * If your service interface returns Call<dog>, dog will be passed into parseServicePOJOs in
 * CallToCardholder. If one needs a DogCardHolder of the dog's bark and color. The POJOParser
 * should parse dog for it's bark and color, bind that data to a DogCardHolder object and then
 * return that DogCardHolder object.
 *
 */

public interface POJOParser {

    <T> CardHolderPOJO parseServicePOJOs(T toParse);
}
