package com.example.andresarango.automaticpancake.utility.networks;

import com.example.andresarango.automaticpancake.utility.CardHolderPOJO;

/**
 * Created by andresarango on 11/2/16.
 */

public interface POJOCallback {
    /*
    *
    *Should be implemented by a listener waiting for a POJOCallback.
    *
    * */

    void callback(CardHolderPOJO pojo);
}
