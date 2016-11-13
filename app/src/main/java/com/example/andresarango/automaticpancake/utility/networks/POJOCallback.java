package com.example.andresarango.automaticpancake.utility.networks;

import com.example.andresarango.automaticpancake.utility.CardHolderPOJO;

/**
 * Created by andresarango on 11/2/16.
 * <p>
 * Should be implemented by a listener waiting for a POJOCallback.
 */

public interface POJOCallback {


    void callback(CardHolderPOJO pojo);
}
