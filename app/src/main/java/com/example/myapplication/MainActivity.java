package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<ListElement> elements;
    DrawerLayout drawerLayout;
    ImageView menu;
    LinearLayout main, other;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawerLayout);
        menu = findViewById(R.id.menu);
        main = findViewById(R.id.main);
        other = findViewById(R.id.other);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDrawer(drawerLayout);
            }
        });

        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recreate();
            }
        });

        other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                redirectActivity(MainActivity.this, OtherFundamentalsActivity.class);
            }
        });

        init();
    }

    public static void openDrawer(DrawerLayout drawerLayout) {
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public static void closeDrawer(DrawerLayout drawerLayout) {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public static void redirectActivity(Activity activity, Class secondActivity) {
        Intent intent = new Intent(activity, secondActivity);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
        activity.finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        closeDrawer(drawerLayout);
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

        ListAdapter listAdapter = new ListAdapter(elements, this, new ListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ListElement item) {
                moveToDescription(item);
            }
        });
        RecyclerView recyclerView = findViewById(R.id.listRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        super.onContextItemSelected(item);
        switch (item.getItemId()) {
            case 101:
                final AlertDialog.Builder dialog = new AlertDialog.Builder(this);
                dialog.setMessage("Simple Dialog")
                        .setTitle("Show dialog!")
                        .setCancelable(false)
                        .setNeutralButton("Accept",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });
                AlertDialog alert = dialog.create();
                alert.show();
                return true;
            case 102:
                final AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Exit?");
                builder.setCancelable(false);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplication(), "Yes", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                        Toast.makeText(getApplication(), "No", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
                return true;
        }
        return false;
    }

    public void moveToDescription(ListElement item) {
        Intent intent = new Intent(this, DescriptionActivity.class);
        intent.putExtra("ListElement", item);
        startActivity(intent);
    }

}