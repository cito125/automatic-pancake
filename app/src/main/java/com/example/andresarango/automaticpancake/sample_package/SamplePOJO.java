package com.example.andresarango.automaticpancake.sample_package;

/**
 * Created by andresarango on 10/22/16.
 */





/*This POJO is an example of any type of POJO that must be created when dealing with an API.

* In this case SamplePOJO will be the object returned by response.body() in GoogleNowCardCall's
* runServiceThreadForCardHolderPOJO method. It will then be parsed by SampleParser for it's value
* field.
* */

public class SamplePOJO {


    String icon_url;
    String id;
    String url;
    String value;

    public String getIcon_url() {
        return icon_url;
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getValue() {
        return value;
    }
}
