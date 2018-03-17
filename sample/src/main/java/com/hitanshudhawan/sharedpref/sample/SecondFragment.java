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
import android.widget.TextView;
import android.widget.Toast;

import com.hitanshudhawan.sharedpref.SharedPref;

/**
 * Created by hitanshu on 16/3/18.
 */

public class SecondFragment extends Fragment {

    private SharedPref sharedPref;

    private EditText keyEditText;
    private TextView valueTextView;
    private Spinner dataTypeSpinner;
    private Button putButton;

    private Integer itemSelected;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        sharedPref = new SharedPref(getContext());

        keyEditText = view.findViewById(R.id.edit_text_key);
        valueTextView = view.findViewById(R.id.text_view_value);
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
                switch (itemSelected) {
                    case 0:
                        // boolean
                        valueTextView.setText(String.valueOf(sharedPref.getBoolean(key, false)));
                        showToast();
                        break;
                    case 1:
                        // float
                        valueTextView.setText(String.valueOf(sharedPref.getFloat(key, 0)));
                        showToast();
                        break;
                    case 2:
                        // int
                        valueTextView.setText(String.valueOf(sharedPref.getInt(key, 0)));
                        showToast();
                        break;
                    case 3:
                        // long
                        valueTextView.setText(String.valueOf(sharedPref.getLong(key, 0)));
                        showToast();
                        break;
                    case 4:
                        // string
                        valueTextView.setText(String.valueOf(sharedPref.getString(key, "")));
                        showToast();
                        break;
                    case 5:
                        // string set
                        valueTextView.setText(String.valueOf(sharedPref.getStringSet(key, null)));
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
