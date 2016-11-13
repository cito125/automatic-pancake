package com.example.andresarango.automaticpancake;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.andresarango.automaticpancake.utility.GoogleNowCardHolder;
import com.example.andresarango.automaticpancake.utility.CardViewHolder;
import com.example.andresarango.automaticpancake.utility.networks.GoogleNowCardCallback;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by andresarango on 10/30/16.
 */

public class CardRecycleAdapter extends RecyclerView.Adapter<CardViewHolder> implements GoogleNowCardCallback {
    private List<GoogleNowCardHolder> mCardHolderList = new ArrayList<>();


    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        for (int i = 0; i < mCardHolderList.size(); i++) {
            if(System.identityHashCode(mCardHolderList.get(i)) == viewType){
                return mCardHolderList.get(i).POJOViewholder(parent);
            }
        }
        return null;
    }

    public void setCardHolderList(List<GoogleNowCardHolder> updateList){
        mCardHolderList.clear();
        mCardHolderList.addAll(updateList);
        notifyDataSetChanged();
    }

    public void addCardHolder(GoogleNowCardHolder cardholderGoogleNow, int i){
        mCardHolderList.add(i, cardholderGoogleNow);
        notifyItemInserted(i);
    }

    public void addCardHolderToEnd(GoogleNowCardHolder cardholderGoogleNow){
        mCardHolderList.add(cardholderGoogleNow);
        notifyItemInserted(mCardHolderList.size() - 1);
    }

    @Override
    public int getItemViewType(int position) {
        return System.identityHashCode(mCardHolderList.get(position));
    }

    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {
        holder.bindViewHolder(mCardHolderList.get(position));
    }

    @Override
    public int getItemCount() {
        return mCardHolderList.size();
    }

    @Override
    public void callback(GoogleNowCardHolder pojo) {
        if (pojo != null) {
            addCardHolderToEnd(pojo);
        }
    }

    public boolean onItemMove(int fromPosition, int toPosition) {
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(mCardHolderList, i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(mCardHolderList, i, i - 1);
            }
        }
        notifyItemMoved(fromPosition, toPosition);
        return true;
    }

    public void onItemDismiss(int adapterPosition) {
        mCardHolderList.remove(adapterPosition);
        notifyItemRemoved(adapterPosition);
    }
}
