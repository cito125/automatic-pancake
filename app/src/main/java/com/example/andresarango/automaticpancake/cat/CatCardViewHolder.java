package com.example.andresarango.automaticpancake.cat;

import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.example.andresarango.automaticpancake.R;
import com.example.andresarango.automaticpancake.utility.CardViewHolder;
import com.squareup.picasso.Picasso;

/**
 * Created by andresarango on 10/30/16.
 */

public class CatCardViewHolder extends CardViewHolder {

    private static final String LOG = CatCardViewHolder.class.getSimpleName() ;
    CardView catCard;
    ImageView catImage;
    private final String URL_PIC = "http://thecatapi.com/api/images/get?api_key=MTMzNDM2&format=xml&results_per_page=1";


    public CatCardViewHolder(View itemView) {
        super(itemView);
        catCard = (CardView) itemView.findViewById(R.id.cat_card);
        catImage = (ImageView) itemView.findViewById(R.id.iv_catimage);
    }

    @Override
    public void bindViewHolder(Object obj) {
        Picasso.with(itemView.getContext())
                .load(URL_PIC)
                .placeholder(R.drawable.cat_placeholder)
                .resize(1500, 1500)
                .centerInside()
                .into(catImage);

        catImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Picasso.with(itemView.getContext())
                        .load("https://i.ytimg.com/vi/tntOCGkgt98/maxresdefault.jpg")
                        .placeholder(R.drawable.cat_placeholder)
                        .resize(1500, 1500)
                        .centerInside()
                        .into(catImage);
                Log.d(LOG, "second cat photo");

            }
        });
    }

}

