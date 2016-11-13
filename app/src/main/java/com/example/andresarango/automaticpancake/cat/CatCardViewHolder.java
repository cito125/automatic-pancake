package com.example.andresarango.automaticpancake.cat;

import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.andresarango.automaticpancake.R;

import com.example.andresarango.automaticpancake.utility.CardViewHolder;
import com.squareup.picasso.Picasso;

import java.security.PublicKey;

/**
 * Created by andresarango on 10/30/16.
 */

public class CatCardViewHolder extends CardViewHolder {

    private static final String LOG = CatCardViewHolder.class.getSimpleName();
    CardView catCard;
    ImageView catImage;
    ImageView pizzaCat;
    TextView catOfTheDay;
    Button makeMeme;
    private final String URL_PIC = "http://thecatapi.com/api/images/get?api_key=MTMzNDM2&format=src&results_per_page=1";
    private final String PIZZA_CAT = "https://media0.giphy.com/media/3osxYpRxjzvPOtwfF6/200_s.gif";

    public CatCardViewHolder(View itemView) {
        super(itemView);
        catCard = (CardView) itemView.findViewById(R.id.cat_card);
        catImage = (ImageView) itemView.findViewById(R.id.iv_catimage);
        pizzaCat = (ImageView) itemView.findViewById(R.id.iv_pizza_cat);
        catOfTheDay = (TextView) itemView.findViewById(R.id.tv_catoftheday);
        makeMeme = (Button) itemView.findViewById(R.id.bt_makememe);
    }

    @Override
    public void bindViewHolder(Object obj) {
        Picasso.with(itemView.getContext())
                .load(URL_PIC)
                .placeholder(R.drawable.cat_placeholder)
                .resize(1200, 1200)
                .centerInside()
                .into(catImage);

        Picasso.with(itemView.getContext())
                .load(PIZZA_CAT)
                .placeholder(R.drawable.cat_placeholder)
                .resize(200, 200)
                .centerInside()
                .into(pizzaCat);

        makeMeme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Picasso.with(itemView.getContext())
                        .load(URL_PIC)
                        .placeholder(R.drawable.cat_placeholder)
                        .resize(1200, 1200)
                        .centerInside()
                        .into(catImage);
            }
        });
    }

    public void anotherCat() {
        makeMeme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Picasso.with(view.getContext())
                        .load(URL_PIC)
                        .placeholder(R.drawable.cat_placeholder)
                        .resize(1201, 1201)
                        .centerInside()
                        .into(catImage);
                Log.d(LOG, "second cat photo");
            }
        });
    }

    public void memeURL(String url) {
        // "https://memegen.link/custom/my-other-background/is-the-grand-canyon.jpg?alt=http://thecatapi.com/api/images/get?api_key=MTMzNDM2&format=src&results_per_page=1" //
        final String MEME_URL_BASE = "https://memegen.link/custom/";
        String MEME_TOP_CAPTION = "";
        String MEME_BOTTOM_CAPTION = "";
        final String MEME_ENDPOINT = ".jpg?alt=";


    }

}

