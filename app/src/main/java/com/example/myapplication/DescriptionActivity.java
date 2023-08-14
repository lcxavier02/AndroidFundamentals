package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import io.github.muddz.styleabletoast.StyleableToast;

public class DescriptionActivity extends AppCompatActivity {

    TextView titleDescriptionTextView;
    TextView cityDescriptionTextView;
    TextView statusDescriptionTextView;

    Button buttonToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        ListElement element = (ListElement) getIntent().getSerializableExtra("ListElement");
        titleDescriptionTextView = findViewById(R.id.titleDescriptionTextView);
        cityDescriptionTextView = findViewById(R.id.cityDescriptionTextView);
        statusDescriptionTextView = findViewById(R.id.statusDescriptionTextView);
        buttonToast = findViewById(R.id.btnShowToast);

        titleDescriptionTextView.setText(element.getName());
        titleDescriptionTextView.setTextColor(Color.parseColor(element.getColor()));

        cityDescriptionTextView.setText(element.getCity());

        statusDescriptionTextView.setText(element.getStatus());
        statusDescriptionTextView.setTextColor(Color.BLUE);

        buttonToast.setBackgroundColor(Color.parseColor(element.getColor()));

        buttonToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StyleableToast.makeText(DescriptionActivity.this, element.getName()+" Toast!", R.style.exampleToast).show();
            }
        });
    }
}