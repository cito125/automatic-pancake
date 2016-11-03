package com.example.andresarango.automaticpancake.sample_package;

import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

import com.example.andresarango.automaticpancake.R;
import com.example.andresarango.automaticpancake.utility.CardViewHolder;

/**
 * Created by andresarango on 10/31/16.
 */

public class SampleViewHolder extends CardViewHolder {
    CardView testCard;
    TextView testText;

    public SampleViewHolder(View itemView) {
        super(itemView);
        testCard = (CardView) itemView.findViewById(R.id.card_recycler);
        testText = (TextView) itemView.findViewById(R.id.yo);
    }

    @Override
    public void bindViewHolder(Object chuckPOJO) {
        testText.setText(((SampleCardHolderPOJO) chuckPOJO).value);
    }
}
