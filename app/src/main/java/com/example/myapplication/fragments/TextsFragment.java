package com.example.myapplication.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class TextsFragment extends Fragment {

    TextInputLayout textInputLayout;
    TextInputEditText textInputEditText;
    TextView textView;
    Button button;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_texts, container, false);

        textInputLayout = view.findViewById(R.id.textInputLayout);
        textInputEditText = view.findViewById(R.id.textInputEditText);
        textView = view.findViewById(R.id.textView);
        button = view.findViewById(R.id.buttonEditText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateText();
            }
        });

        return view;
    }

    public void updateText() {
        textView.setText("You wrote: " + textInputEditText.getText());
    }
}