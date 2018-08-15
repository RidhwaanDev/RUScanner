package com.ridhwaan.ruscanner.RUScanner;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.ridhwaan.ruscanner.R;

public class DialogActivitySelector extends DialogFragment{
    public static final String KEY_EVENTS= "EVENTS_KEY_0000";
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_activity_selector, null);
        Bundle b = getArguments();

        String eventsArray[] = b.getStringArray(KEY_EVENTS);

        ListView eventList = v.findViewById(R.id.lv_events_list);

        ArrayAdapter<String> mEventAdapter =  new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1, eventsArray);
        eventList.setAdapter(mEventAdapter);
        eventList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
              // get the item that was clicked and dimiss
                TextView clicked = (TextView) view;
                String returndata = clicked.getText().toString();
                dismiss();
            }
        });
       return new AlertDialog.Builder(getActivity())
                .setView(v)
                .create();


    }

    public static DialogActivitySelector newInstance(String array[]){


        Bundle bundle = new Bundle();
        bundle.putStringArray(KEY_EVENTS,array);

        DialogActivitySelector dialog = new DialogActivitySelector();
        dialog.setArguments(bundle);
        return dialog;
    }
}
