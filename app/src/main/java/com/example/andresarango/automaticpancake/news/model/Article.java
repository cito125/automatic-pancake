
package com.example.andresarango.automaticpancake.news.model;

import java.util.ArrayList;
import java.util.List;


public class Article {

    private List<Result> results = new ArrayList<Result>();

    /**
     * @return The results
     */
    public List<Result> getResults() {
        return results;
    }

    /**
     * @param results The results
     */
    public void setResults(List<Result> results) {
        this.results = results;
    }

}
