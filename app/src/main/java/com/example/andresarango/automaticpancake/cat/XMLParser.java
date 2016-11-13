package com.example.andresarango.automaticpancake.cat;

import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;
import java.util.ArrayList;

/**
 * Created by catwong on 11/4/16.
 */

public class XMLParser {

    private String xmlCat;
    private ArrayList<Image> catURL;

    public XMLParser(String xmlCat) {
        this.xmlCat = xmlCat;
        catURL = new ArrayList<>();
    }

    public String getXmlCat() {
        return xmlCat;
    }

    public ArrayList<Image> getCatURL() {
        return catURL;
    }

    public boolean proccess() {
        boolean status = true;
        Image currentRecord = null;
        boolean inEntry = false;
        String textValue = "";

        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser pullParser = factory.newPullParser();
            pullParser.setInput(new StringReader(xmlCat));
            int eventType = pullParser.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT) {
                String tagName = pullParser.getName();
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        if (tagName.equalsIgnoreCase("url")) {
                            inEntry = true;
                            currentRecord = new Image();
                        }
                        break;
                    case XmlPullParser.TEXT:
                        textValue = pullParser.getText();
                        break;
                    case XmlPullParser.END_TAG:
                        if (inEntry) {
                            if (tagName.equalsIgnoreCase("url")) {
                                catURL.add(currentRecord);
                                inEntry = false;
                            }
                        }
                        break;
                    default:
                        // nothing else to do
                }
                eventType = pullParser.next();
            }

        } catch (Exception e) {
            status = false;
            e.printStackTrace();
        }

        for (Image cat : catURL) {
            Log.d("RSSParser", "******************************************");
            Log.d("RSSParser", "URL: " + cat.getUrl());
            Log.d("RSSParser", "Source URL: " + cat.getSource_url());
            Log.d("RSSParser", "Source URL: " + cat.getId());
        }
        return true;
    }
}
