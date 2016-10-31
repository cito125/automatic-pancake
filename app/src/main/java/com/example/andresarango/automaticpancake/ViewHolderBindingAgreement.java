package com.example.andresarango.automaticpancake;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by andresarango on 10/30/16.
 */

public abstract class ViewHolderBindingAgreement extends RecyclerView.ViewHolder{
    /*
    * Each CardViewHolder must implement the ViewHolderBindingAgreement and is responsible for binding
    * data to each view within the class.*/

    public ViewHolderBindingAgreement(View itemView) {
        super(itemView);
    }
    public abstract void bindViewHolder(Object obj);
}
