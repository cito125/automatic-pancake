package com.example.andresarango.automaticpancake.reminder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.andresarango.automaticpancake.R;
import com.example.andresarango.automaticpancake.utility.CardViewHolder;
import com.example.andresarango.automaticpancake.utility.GoogleNowCardHolder;

/**
 * Created by andresarango on 10/30/16.
 */

public class RemindMe implements GoogleNowCardHolder {

    Context context;

    public void RemindMe(Context context) {
        this.context = context;
    }

    android.content.SharedPreferences sf;
    EditText name;
    public static final String preference = "pref";
    public static final String saveIt = "saveKey";

    @Override
    public CardViewHolder POJOViewholder(ViewGroup parent) {
        return new RemindMeCardViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.reminder_card, parent, false));
    }


    public void save(View view) {
        String store = name.getText().toString();
        android.content.SharedPreferences.Editor editor = sf.edit();
        editor.putString(saveIt, store);
        editor.commit();
    }

    public void clear(View v) {
        name = (EditText) v.findViewById(R.id.text_to_save);
        name.setText("");
    }

    public void retrieve(View v) {
        name = (EditText) v.findViewById(R.id.text_to_save);
        sf = context.getSharedPreferences(preference, Context.MODE_PRIVATE);

        if (sf.contains(saveIt)) {
            name.setText(sf.getString(saveIt, ""));
        }
    }


}
