package com.example.andresarango.automaticpancake.cat.view;

import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.andresarango.automaticpancake.R;

import com.example.andresarango.automaticpancake.cat.network.CatAPIParser;
import com.example.andresarango.automaticpancake.cat.model.CatMemePOJO;
import com.example.andresarango.automaticpancake.utility.CardViewHolder;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
    CatAPIParser mCatAPI;
    String catMemeUrl;
    TextView cat;

    private final String URL_PIC = "http://thecatapi.com/api/images/get?format=src&results_per_page=1";
    private final String CAP_API_BASE_URL = "\"http://thecatapi.com/";

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
        String meme = runCatAPI();
        System.out.println("MEME URL: " + meme);
        Picasso.with(itemView.getContext())
                .load(URL_PIC)
                .placeholder(R.drawable.cat_placeholder)
                .resize(1200, 1200)
                .centerInside()
                .into(catImage);
        System.out.println("URL PIC: " + URL_PIC);


        makeMeme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String memeUrl = memeURL();
                Picasso.with(itemView.getContext())
                        .load(memeUrl)
                        .placeholder(R.drawable.cat_placeholder)
                        .resize(1200, 1200)
                        .centerInside()
                        .into(catImage);
                System.out.println("MEME URL after OnClickListener Called: " + memeUrl);
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

    private String runCatAPI() {
        mCatAPI = CatAPIParser.getInstance();
        mCatAPI.getCats().enqueue(new Callback<CatMemePOJO>() {
            @Override
            public void onResponse(Call<CatMemePOJO> call, Response<CatMemePOJO> response) {
                if (response.isSuccessful()) {
                    cat.setText(response.body().getResponse().getData().getImages().getImage().getUrl());
                    catMemeUrl = response.body().getResponse().getData().getImages().getImage().getUrl();
                }
            }

            @Override
            public void onFailure(Call<CatMemePOJO> call, Throwable t) {

            }
        });
        return catMemeUrl;

    }
}

