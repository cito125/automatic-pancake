package com.example.andresarango.automaticpancake.utility;

import android.view.ViewGroup;

/**
 * Created by andresarango on 10/30/16.
 */

public interface CardHolderPOJO {
    /*
    * This interface is acting as a sort of label. CardRecycleAdapter only takes objects of this
    *  type. As a result, if you are making a cardHolderPOJO holding data you want bound to each Card
    * ViewHolder, it must extend CardHolderPOJO.
    *
    * This interface only requires the implementation of one method, POJOViewHolder.
    * POJOViewHolder returns a viewHolder of type CardViewHolder that will be used in
    * the onCreatViewHolder of the recyclerView. The layout to be inflated should be specified in
    * this method and passed into the POJO's corresponding ViewHolder.
     */
    CardViewHolder POJOViewholder(ViewGroup parent);
}
