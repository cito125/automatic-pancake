package com.example.andresarango.automaticpancake.cat.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by catwong on 11/4/16.
 */

@Root(name = "image")
public class Image {

    @ElementList(inline = true)
    List<Image> imageList;

    @Element(name = "url")
    private String url;

    @Element(name = "id")
    private String id;

    @Element(name = "source_url")
    private String source_url;


    public String getUrl() {
        return url;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "ClassPojo [id = " + id + ", source_url = " + source_url + ", url = " + url + "]";
    }
}
