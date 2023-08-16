package com.example.myapplication.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.example.myapplication.R;

public class ToggleFragment extends Fragment {
    Switch aSwitch;
    TextView textView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_toggle, container, false);

        aSwitch = view.findViewById(R.id.toggleSwitch);
        textView = view.findViewById(R.id.textView);

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    textView.setText("Now is activated");
                } else {
                    textView.setText("But now is not activated");
                }
            }
        });

        return view;
    }
}