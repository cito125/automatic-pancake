package com.example.andresarango.automaticpancake.reminder;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.andresarango.automaticpancake.R;
import com.example.andresarango.automaticpancake.utility.CardViewHolder;

import static com.example.andresarango.automaticpancake.R.id.clear_button;
import static com.example.andresarango.automaticpancake.R.id.retrieve_button;
import static com.example.andresarango.automaticpancake.R.id.save_button;

/**
 * Created by andresarango on 10/30/16.
 */

public class RemindMeCardViewHolder extends CardViewHolder {
    EditText editText;
    Button save;
    Button retrieve;
    Button clear;

    SharedPreferences sf;
    String store;
    EditText name;
    public static final String preference = "pref";
    public static final String saveIt = "saveKey";

    public RemindMeCardViewHolder(View itemView) {
        super(itemView);
        save = (Button) itemView.findViewById(R.id.save_button);
        retrieve = (Button) itemView.findViewById(retrieve_button);
        clear = (Button) itemView.findViewById(R.id.clear_button);
        editText = (EditText) itemView.findViewById(R.id.text_to_save);

        retrieve.setOnClickListener(onClick());
        clear.setOnClickListener(onClick());
        save.setOnClickListener(onClick());
    }

    private View.OnClickListener onClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case retrieve_button:
                        name = (EditText) itemView.findViewById(R.id.text_to_save);
                        sf = itemView.getContext().getSharedPreferences(preference, Context.MODE_PRIVATE);

                        if (sf.contains(saveIt)) {
                            name.setText(sf.getString(saveIt, ""));
                        }
                        break;
                    case clear_button:
                        name = (EditText) itemView.findViewById(R.id.text_to_save);
                        name.setText("");
                        break;
                    case save_button:
                        store = name.getText().toString();
                        SharedPreferences.Editor editor = sf.edit();
                        editor.putString(saveIt, store);
                        editor.apply();
                        break;
                }
            }
        };
    }

    @Override
    public void bindViewHolder(Object obj) {

    }


}
