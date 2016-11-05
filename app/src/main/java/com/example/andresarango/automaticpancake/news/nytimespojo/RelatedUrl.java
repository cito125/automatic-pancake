
package com.example.andresarango.automaticpancake.news.nytimespojo;


public class RelatedUrl {

    private String suggestedLinkText;
    private String url;

    /**
     * 
     * @return
     *     The suggestedLinkText
     */
    public String getSuggestedLinkText() {
        return suggestedLinkText;
    }

    /**
     * 
     * @param suggestedLinkText
     *     The suggested_link_text
     */
    public void setSuggestedLinkText(String suggestedLinkText) {
        this.suggestedLinkText = suggestedLinkText;
    }

    /**
     * 
     * @return
     *     The url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 
     * @param url
     *     The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

}
