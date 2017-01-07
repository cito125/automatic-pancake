package com.example.andresarango.automaticpancake.sample_package.model;

/**
 * Created by andresarango on 10/22/16.
 */





/*This POJO is an example of any type of POJO that must be created when dealing with an API.

* In this case SamplePOJO will be the object returned by response.body() in GoogleNowCardCall's
* runServiceThreadForCardHolderPOJO method. It will then be parsed by SampleParser for it's value
* field.
* */

public class SamplePOJO {

    String value;

    public String getValue() {
        return value;
    }
}
