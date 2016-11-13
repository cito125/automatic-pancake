package com.example.andresarango.automaticpancake.utility.networks;

import com.example.andresarango.automaticpancake.utility.GoogleNowCardHolder;

/**
 * Created by andresarango on 11/2/16.
 * <p>
 * Should be implemented by a listener waiting for a GoogleNowCardCallback.
 */

public interface GoogleNowCardCallback {


    void callback(GoogleNowCardHolder pojo);
}
