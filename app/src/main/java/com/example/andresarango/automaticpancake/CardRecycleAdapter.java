package com.example.andresarango.automaticpancake;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.andresarango.automaticpancake.cat.CatMeme;
import com.example.andresarango.automaticpancake.cat.CatViewHolder;
import com.example.andresarango.automaticpancake.news.NewsCards;
import com.example.andresarango.automaticpancake.news.NewsViewHolder;
import com.example.andresarango.automaticpancake.reminder.RemindMe;
import com.example.andresarango.automaticpancake.reminder.RemindMeViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andresarango on 10/30/16.
 */

public class CardRecycleAdapter extends RecyclerView.Adapter<ViewHolderBindingAgreement> {
    private final int CATMEME = 0, NEWSCARD = 1, REMINDME = 2;
    private List<CardHolderPOJO> mCardHolderList = new ArrayList<>();

    @Override
    public ViewHolderBindingAgreement onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (viewType){
            case CATMEME:
                View v1 = inflater.inflate(R.layout.cat_card,parent,false);
                return new CatViewHolder(v1);
            case NEWSCARD:
                View v2 = inflater.inflate(R.layout.news_card,parent,false);
                return new NewsViewHolder(v2);
            case REMINDME:
                View v3 = inflater.inflate(R.layout.reminder_card,parent,false);
                return new RemindMeViewHolder(v3);
        }
        return null;
    }

    public void setCardHolderList(List<CardHolderPOJO> updateList){
        mCardHolderList.clear();
        mCardHolderList.addAll(updateList);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if(mCardHolderList.get(position) instanceof CatMeme){
            return CATMEME;
        }else if(mCardHolderList.get(position) instanceof NewsCards){
            return NEWSCARD;
        }else if (mCardHolderList.get(position) instanceof RemindMe){
            return REMINDME;
        }
        return -1;
    }

    @Override
    public void onBindViewHolder(ViewHolderBindingAgreement holder, int position) {
        holder.bindViewHolder(mCardHolderList.get(position));
    }

    @Override
    public int getItemCount() {
        return mCardHolderList.size();
    }
}
