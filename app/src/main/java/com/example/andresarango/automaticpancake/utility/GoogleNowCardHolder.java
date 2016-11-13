package com.example.andresarango.automaticpancake.utility;

import android.view.ViewGroup;

/**
 * Created by andresarango on 10/30/16.
 * This interface is acting as a sort of label. CardRecycleAdapter only takes objects of this
 * type. As a result, if you are making a cardHolderPOJO holding data you want bound to each
 * CardViewHolder, it must extend GoogleNowCardHolder.
 * <p>
 * GoogleNowCardHolder holds the data you want bound to your CardViewHolder as well as the CardViewHolder
 * you want that data bound to.
 * <p>
 * This interface only requires the implementation of one method, POJOViewHolder.
 * POJOViewHolder returns a viewHolder of type CardViewHolder that will be used in
 * the onCreatViewHolder of the recyclerView. The layout to be inflated should be referenced, inflated
 * and returned in this method. The returned object must be of type CardViewHolder.
 * <p>
 * This method is necessary at the moment because CardRecyclerAdapter goes through a list of
 * GoogleNowCardHolder objects and is expecting to be able to call this method indiscriminately and
 * get a CardViewHolder object.
 * <p>
 * We should work to somehow decouple this in the future since it would be nice if GoogleNowCardHolder's
 * only held data and CardViewHolder held everything related to the view.
 * <p>
 * For now, we can think of the POJOViewHolder as a means of a GoogleNowCardHolder holding information
 * about it's corresponding CardViewHolder.
 */

public interface GoogleNowCardHolder {

    CardViewHolder POJOViewholder(ViewGroup parent);
}
