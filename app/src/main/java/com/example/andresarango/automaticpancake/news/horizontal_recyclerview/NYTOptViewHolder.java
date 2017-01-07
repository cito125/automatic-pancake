package com.example.andresarango.automaticpancake.news.horizontal_recyclerview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.andresarango.automaticpancake.R;
import com.example.andresarango.automaticpancake.news.network.NYTAPI;
import com.example.andresarango.automaticpancake.news.model.Article;
import com.example.andresarango.automaticpancake.news.model.Multimedium;
import com.example.andresarango.automaticpancake.news.model.Result;
import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by andresarango on 11/5/16.
 */

public class NYTOptViewHolder extends RecyclerView.ViewHolder {
    TextView mNYTOptTV;
    TextView mTitleTV;
    TextView mAbstractTV;
    ImageView mArticlePic;
    @Inject
    NYTAPI mNYTimmesAPI;
    String mURLOfArticle;
    Context mContext;

    public NYTOptViewHolder(View itemView) {
        super(itemView);
        mContext = itemView.getContext();
        mNYTOptTV = (TextView) itemView.findViewById(R.id.nyt_news_op_tv);
        mTitleTV = (TextView) itemView.findViewById(R.id.article_title);
        mAbstractTV = (TextView) itemView.findViewById(R.id.nyt_abstract);
        mArticlePic = (ImageView) itemView.findViewById(R.id.article_pic);
        mTitleTV.setOnClickListener(onClick());
        mArticlePic.setOnClickListener(onClick());
    }

    private View.OnClickListener onClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mURLOfArticle != null) {
                    Uri uri = Uri.parse(mURLOfArticle); // missing 'http://' will cause crashed
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    mContext.startActivity(intent);
                }
            }
        };

    }

    private void runNYTimesAPI(String section) {
        mNYTimmesAPI = NYTAPI.getInstance();
        if (section == null) {
            return;
        }
        mNYTimmesAPI.getSection(section).enqueue(new Callback<Article>() {
            @Override
            public void onResponse(Call<Article> call, Response<Article> response) {
                if (response.isSuccessful()) {
                    Result firstResult = response.body().getResults().get(0);
                    setTitle(firstResult.getTitle());
                    setAbstract(firstResult.getAbstract());
                    List<Multimedium> multiMediaList = firstResult.getMultimedia();
                    if (multiMediaList.size() > 0) {
                        setPicture(firstResult.getMultimedia().get(0).getUrl());
                    }
                    mURLOfArticle = firstResult.getUrl();
                }
            }

            @Override
            public void onFailure(Call<Article> call, Throwable t) {

            }
        });

    }

    private void setAbstract(String anAbstract) {
        if (mAbstractTV != null && anAbstract != null) {
            mAbstractTV.setText(anAbstract);
        }
    }


    protected void onBind(String newsOption) {
        mNYTOptTV.setText(newsOption.toUpperCase());
        runNYTimesAPI(newsOption);
    }

    private void setTitle(String title) {
        mTitleTV.setText(title);
    }

    private void setPicture(String url) {
        Picasso.with(itemView.getContext())
                .load(url)
                .placeholder(R.drawable.nytimes_logo)
                .resizeDimen(R.dimen.nyt_pic_width, R.dimen.nyt_pic_height)
                .centerInside()
                .into(mArticlePic);


    }


}
