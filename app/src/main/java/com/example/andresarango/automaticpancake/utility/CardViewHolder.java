package com.example.andresarango.automaticpancake.utility;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by andresarango on 10/30/16.
 */

public abstract class CardViewHolder extends RecyclerView.ViewHolder{
    /*
    * Each CardViewHolder must implement the CardViewHolder and is responsible for binding
    * data to each view within the class.
    *
    *
    * */

    public CardViewHolder(View itemView) {
        super(itemView);
    }
    public abstract void bindViewHolder(Object obj);
}
