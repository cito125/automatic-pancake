package com.example.andresarango.automaticpancake;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.andresarango.automaticpancake.utility.CardHolderPOJO;
import com.example.andresarango.automaticpancake.utility.CardViewHolder;
import com.example.andresarango.automaticpancake.utility.networks.POJOCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andresarango on 10/30/16.
 */

public class CardRecycleAdapter extends RecyclerView.Adapter<CardViewHolder> implements POJOCallback {
    private List<CardHolderPOJO> mCardHolderList = new ArrayList<>();


    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        for (int i = 0; i < mCardHolderList.size(); i++) {
            if(System.identityHashCode(mCardHolderList.get(i)) == viewType){
                return mCardHolderList.get(i).POJOViewholder(parent);
            }
        }
        return null;
    }

    public void setCardHolderList(List<CardHolderPOJO> updateList){
        mCardHolderList.clear();
        mCardHolderList.addAll(updateList);
        notifyDataSetChanged();
    }

    public void addCardHolder(CardHolderPOJO cardholderPOJO, int i){
        mCardHolderList.add(i,cardholderPOJO);
        notifyItemInserted(i);
    }

    public void addCardHolderToEnd(CardHolderPOJO cardholderPOJO){
        mCardHolderList.add(cardholderPOJO);
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
    public void callback(CardHolderPOJO pojo) {
        if (pojo != null) {
            addCardHolderToEnd(pojo);
        }
    }
}
