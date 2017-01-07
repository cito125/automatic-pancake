package com.example.andresarango.automaticpancake.cat.model;

import org.simpleframework.xml.Root;

/**
 * Created by catwong on 11/4/16.
 */

@Root(name = "Images")
public class Images {

    private Image image;

    public Image getImage() {
        return image;
    }


    @Override
    public String toString() {
        return "ClassPojo [image = " + image + "]";
    }
}
