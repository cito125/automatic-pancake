package com.example.andresarango.automaticpancake.cat;

import android.os.AsyncTask;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.andresarango.automaticpancake.R;

import com.example.andresarango.automaticpancake.cat.CatAPINetwork.CatAPIService;
import com.example.andresarango.automaticpancake.utility.CardViewHolder;
import com.example.andresarango.automaticpancake.utility.networks.NetworkServices;
import com.squareup.picasso.Picasso;

/**
 * Created by andresarango on 10/30/16.
 */

public class CatCardViewHolder extends CardViewHolder {

    private static final String LOG = CatCardViewHolder.class.getSimpleName();
    CardView catCard;
    ImageView catImage;
    ImageView cat_Banner;
    Button makeMeme;
    EditText mTopCaption;
    EditText mBottomCaption;
    private CatAPIService apiService;

    private final String URL_PIC = "http://thecatapi.com/api/images/get?format=src&results_per_page=1";
    private final String CAP_API_BASE_URL = "\"http://thecatapi.com/";
    private final String URL_TEST = "http://25.media.tumblr.com/tumblr_m2avo9tQRy1qze0hyo1_500.jpg";

    public CatCardViewHolder(View itemView) {
        super(itemView);
        mTopCaption = (EditText) itemView.findViewById(R.id.et_top_caption);
        mBottomCaption = (EditText) itemView.findViewById(R.id.et_bottom_caption);
        catCard = (CardView) itemView.findViewById(R.id.cat_card);
        catImage = (ImageView) itemView.findViewById(R.id.iv_catimage);
        cat_Banner = (ImageView) itemView.findViewById(R.id.iv_cat_banner);
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
        System.out.println("URL PIC: " + URL_PIC);

        makeMeme.setOnClickListener(new View.OnClickListener() {
            String memeUrl = memeURL();
            @Override
            public void onClick(View view) {
                new AsyncTaskRunner().execute(memeUrl);
            }
        });

    }

    public String memeURL() {
        // "https://memegen.link/custom/my-other-background/is-the-grand-canyon.jpg?alt=http://thecatapi.com/api/images/get?api_key=MTMzNDM2&format=src&results_per_page=1" //

        final String MEME_BASE_URL = "https://memegen.link/custom/";

        String top = mTopCaption.getText().toString();
        final String MEME_TOP_CAPTION = top.replace(' ', '-');

        final String SEPARATE_CAPTION = "/";

        String bottom = mBottomCaption.getText().toString();
        final String MEME_BOTTOM_CAPTION = bottom.replace(' ', '-');

        final String MEME_ENDPOINT = ".jpg?alt=";

        System.out.println("MEME TOP CAPTION: " + MEME_TOP_CAPTION);
        System.out.println("MEME BOTTOM CAPTION: " + MEME_BOTTOM_CAPTION);
        System.out.println("MEME URL in memeURL(): " + MEME_BASE_URL + MEME_TOP_CAPTION + SEPARATE_CAPTION + MEME_BOTTOM_CAPTION + MEME_ENDPOINT + URL_PIC);
        String memeURLString = MEME_BASE_URL + MEME_TOP_CAPTION + SEPARATE_CAPTION + MEME_BOTTOM_CAPTION + MEME_ENDPOINT + URL_PIC;
        return memeURLString;
    }

    private class AsyncTaskRunner extends AsyncTask<String, String, String> {

        @Override
        protected void onPostExecute(final String result) {
            makeMeme.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Picasso.with(itemView.getContext())
                            .load(result)
                            .placeholder(R.drawable.cat_placeholder)
                            .resize(1200, 1200)
                            .centerInside()
                            .into(catImage);
                    System.out.println("MEME URL after OnClickListener Called: " + result);
                }
            });
        }

        @Override
        protected String doInBackground(String... strings) {
            String memeUrl = memeURL();
            return memeUrl;
        }
    }
}

