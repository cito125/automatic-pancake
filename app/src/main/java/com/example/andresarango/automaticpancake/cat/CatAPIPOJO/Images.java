package com.example.andresarango.automaticpancake.cat.CatAPIPOJO;

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

    public void setImage(Image image) {
        this.image = image;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [image = "+image+"]";
    }
}
