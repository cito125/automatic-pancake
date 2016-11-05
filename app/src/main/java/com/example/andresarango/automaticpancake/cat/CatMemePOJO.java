package com.example.andresarango.automaticpancake.cat;

/**
 {
 "response": {
 "data": {
 "images": {
 "image": {
 "url": "http://25.media.tumblr.com/tumblr_ln2jy1bVqF1qbt33io1_500.jpg",
 "id": "5rt",
 "source_url": "http://thecatapi.com/?id=5rt"
 }
 }
 }
 }
 }
 */


public class CatMemePOJO {

    private Response response;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
