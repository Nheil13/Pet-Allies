package com.example.petallies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.petallies.services.SDataClass;
import com.example.petallies.services.ServicesAdapter;

import java.util.ArrayList;
import java.util.List;

public class Services extends AppCompatActivity {

    //UI Elements
    ImageView ArrowBack;
    RecyclerView recyclerView;

    //Data
    List<SDataClass> dataList;
    ServicesAdapter adapter;
    SDataClass androidData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.services);

        //Back Arrow
        ArrowBack = findViewById(R.id.arrowBack);
        ArrowBack.setOnClickListener(view -> Services.super.onBackPressed());

        recyclerView = findViewById(R.id.sRecyclerView);

        // Set up RecyclerView with a grid layout
        GridLayoutManager gridLayoutManager = new GridLayoutManager(Services.this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);

        // Initialize data list and populate it with AboutUsCategory objects
        dataList = new ArrayList<>();

        adapter = new ServicesAdapter(Services.this, dataList);
        recyclerView.setAdapter(adapter);

        androidData = new SDataClass("Consultation", R.string.consultation, "Click Here", "https://drive.google.com/uc?id=1pdw2OT9oIZNBpbMC9sgYHXkGVXzQX9af");
        dataList.add(androidData);

        androidData = new SDataClass("Pet Wellness", R.string.pet_wellness, "Click Here", "https://drive.google.com/uc?id=1j8FTvaqZg2ZXA7PBNuKqEpn3CC5_uG7f");
        dataList.add(androidData);

        androidData = new SDataClass("Surgery", R.string.surgery, "Click Here", "https://drive.google.com/uc?id=17iYWeMo4lbjV7KUVgkLuG_cSFd8VchGI");
        dataList.add(androidData);

        androidData = new SDataClass("Laboratory Services", R.string.lab_services, "Click Here", "https://drive.google.com/uc?id=1poGwd1oIAHWfqPDPv7p_o4ut4S3N1Nkt");
        dataList.add(androidData);

        androidData = new SDataClass("Dental Services", R.string.dental_services, "Click Here", "https://drive.google.com/uc?id=1qALUM27r6lAG5LlhVaP76cLodHI_JT3s");
        dataList.add(androidData);

        androidData = new SDataClass("Grooming", R.string.dental_services, "Click Here", "https://drive.google.com/uc?id=1plbsfYlDnaoFv6ozxbq4AfqyDLHRLv-F");
        dataList.add(androidData);




    }
}