package com.example.andresarango.automaticpancake.cat.CatAPIPOJO;

import org.simpleframework.xml.Root;

/**
 * Created by catwong on 11/4/16.
 */

@Root(name = "Response")
public class Response {

    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [data = "+data+"]";
    }
}
