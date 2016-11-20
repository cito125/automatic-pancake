package com.example.andresarango.automaticpancake.cat.CatAPIPOJO;

import org.simpleframework.xml.Root;

/**
 * Created by catwong on 11/4/16.
 */

@Root(name = "Data")
public class Data {

    private Images images;

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [images = "+images+"]";
    }
}
