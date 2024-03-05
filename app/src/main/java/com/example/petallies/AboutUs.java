package com.example.petallies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.petallies.aboutus.AboutUsAdapter;
import com.example.petallies.aboutus.AboutUsCategory;

import java.util.ArrayList;
import java.util.List;

public class AboutUs extends AppCompatActivity {

    // UI elements
    RecyclerView recyclerView;
    ImageView ArrowBack;

    // Data
    List<AboutUsCategory> dataList;
    AboutUsAdapter adapter;
    AboutUsCategory aboutCategory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_us);

        // Initialize UI elements
        ArrowBack = findViewById(R.id.arrowBack);
        ArrowBack.setOnClickListener(view -> AboutUs.super.onBackPressed());

        recyclerView = findViewById(R.id.recyclerView);

        // Set up RecyclerView with a grid layout
        GridLayoutManager gridLayoutManager = new GridLayoutManager(AboutUs.this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);

        // Initialize data list and populate it with AboutUsCategory objects
        dataList = new ArrayList<>();

        aboutCategory = new AboutUsCategory("Our History", R.string.our_history, "Click Here", "https://drive.google.com/uc?id=1GJWImxh1mIwwoxeCrOYez-lIHn1U9fPg");
        dataList.add(aboutCategory);

        aboutCategory = new AboutUsCategory("Why Choose Us?", R.string.why_choose_us, "Click Here", "https://drive.google.com/uc?id=1j8FTvaqZg2ZXA7PBNuKqEpn3CC5_uG7f");
        dataList.add(aboutCategory);

        aboutCategory = new AboutUsCategory("Our Staff and Doctors", R.string.staff, "Click Here", "https://drive.google.com/uc?id=1CMuRQoPjCVOKZhD_sY8aJyCeIu6phXI-");
        dataList.add(aboutCategory);

        aboutCategory = new AboutUsCategory("Loyal Customers", R.string.customers, "Click Here", "https://drive.google.com/uc?id=1GJIftMsqbOFGZqpIHr9BX5wTiA2oq-9E");
        dataList.add(aboutCategory);

        // Initialize and set up the adapter for the RecyclerView
        adapter = new AboutUsAdapter(AboutUs.this, dataList);
        recyclerView.setAdapter(adapter);
    }
}