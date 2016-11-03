package com.example.andresarango.automaticpancake.utility;

/**
 * Created by andresarango on 11/1/16.
 */

public interface POJOParser {
    <T> CardHolderPOJO parseServicePOJOs(T toParse);
}
