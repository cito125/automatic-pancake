package com.example.andresarango.automaticpancake.cat;

import java.util.ArrayList;

/**
 * Created by catwong on 11/4/16.
 */

public class XMLParser {

    private String xmlCat;
    private ArrayList<CatMemePOJO> cats;

    public XMLParser(String catPhoto){
        this.xmlCat = xmlCat;
        cats = new ArrayList<>();
    }

    public String getXmlCat() {
        return xmlCat;
    }

    public ArrayList<CatMemePOJO> getCats() {
        return cats;
    }
}
