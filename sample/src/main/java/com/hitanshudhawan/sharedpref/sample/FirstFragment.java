package com.hitanshudhawan.sharedpref.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.hitanshudhawan.sharedpref.SharedPref;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by hitanshu on 16/3/18.
 */

public class FirstFragment extends Fragment {

    private SharedPref sharedPref;

    private EditText keyEditText;
    private EditText valueEditText;
    private Spinner dataTypeSpinner;
    private Button putButton;

    private Integer itemSelected;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        sharedPref = new SharedPref(getContext());

        keyEditText = view.findViewById(R.id.edit_text_key);
        valueEditText = view.findViewById(R.id.edit_text_value);
        dataTypeSpinner = view.findViewById(R.id.spinner_data_type);
        putButton = view.findViewById(R.id.button_put);

        itemSelected = 0;

        dataTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                itemSelected = pos;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        putButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String key = keyEditText.getText().toString();
                String value = valueEditText.getText().toString();
                switch (itemSelected) {
                    case 0:
                        // boolean
                        sharedPref.putBoolean(key, Boolean.parseBoolean(value));
                        showToast();
                        break;
                    case 1:
                        // float
                        sharedPref.putFloat(key, Float.parseFloat(value));
                        showToast();
                        break;
                    case 2:
                        // int
                        sharedPref.putInt(key, Integer.parseInt(value));
                        showToast();
                        break;
                    case 3:
                        // long
                        sharedPref.putLong(key, Long.parseLong(value));
                        showToast();
                        break;
                    case 4:
                        // string
                        sharedPref.putString(key, value);
                        showToast();
                        break;
                    case 5:
                        // string set
                        sharedPref.putStringSet(key, new HashSet<String>(Arrays.asList(value.split(","))));
                        showToast();
                        break;
                }
            }
        });

        return view;
    }

    private void showToast() {
        Toast.makeText(getContext(), "done", Toast.LENGTH_SHORT).show();
    }
}
