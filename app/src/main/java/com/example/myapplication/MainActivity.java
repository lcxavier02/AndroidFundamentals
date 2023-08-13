package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<ListElement> elements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    public void init() {
        elements = new ArrayList<>();
        elements.add(new ListElement("#922B21", "John Doe", "USA", "Active"));
        elements.add(new ListElement("#8E44AD", "Aarika", "Afghanistan", "Inactive"));
        elements.add(new ListElement("#FCF3CF", "Briana", "Barbados", "Active"));
        elements.add(new ListElement("#E67E22", "Chrystel", "Germany", "Active"));
        elements.add(new ListElement("#48C9B0", "Cinderella", "India", "Dead"));
        elements.add(new ListElement("#5D6D7E", "Helga", "Honduras", "Cancelled"));
        elements.add(new ListElement("#0E6655", "Gust", "Morocco", "Active"));
        elements.add(new ListElement("#784212", "Jorge", "Mexico", "Active"));
        elements.add(new ListElement("#81D4FA", "Lemmy", "Zambia", "Inactive"));
        elements.add(new ListElement("#AED581", "Natanael", "Japan", "Active"));

        ListAdapter listAdapter = new ListAdapter(elements, this);
        RecyclerView recyclerView = findViewById(R.id.listRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
    }
}