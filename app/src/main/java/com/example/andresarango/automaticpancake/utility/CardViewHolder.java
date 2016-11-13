package com.example.andresarango.automaticpancake.utility;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by andresarango on 10/30/16.
 */

public abstract class CardViewHolder extends RecyclerView.ViewHolder {
    /*
    * Each CardViewHolder is responsible for binding or not binding data to it's view.
    *
    * This data should come from it's corresponding CardHolderPOJO.
    * */

    public CardViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bindViewHolder(Object obj);

}
