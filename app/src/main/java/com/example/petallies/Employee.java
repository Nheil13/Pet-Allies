package com.example.petallies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.petallies.employees.EDataClass;
import com.example.petallies.employees.EmployeeAdapter;

import java.util.ArrayList;
import java.util.List;

public class Employee extends AppCompatActivity {

    //UI Elements
    RecyclerView recyclerView;

    ImageView ArrowBack;

    //Data
    List<EDataClass> dataList;
    EmployeeAdapter adapter;
    EDataClass androidData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee);

        // Initialize UI elements
        ArrowBack = findViewById(R.id.arrowBack);
        ArrowBack.setOnClickListener(view -> Employee.super.onBackPressed());

        /**
         * Setting up an ImageSlider using a library that utilizes SlideModel for image slides.
         * Three image URLs are defined to be displayed in the slider.
         * Each image URL is associated with a SlideModel, specifying CENTER_CROP scaling.
         * These SlideModels are added to an ArrayList, which is then used to populate the ImageSlider.
         *
         */
        ImageSlider imageSlider = findViewById(R.id.imageSlider);
        ArrayList<SlideModel> slideModels = new ArrayList<>();

        String imageURL1 = "https://drive.google.com/uc?id=1pdw2OT9oIZNBpbMC9sgYHXkGVXzQX9af";
        String imageURL2 = "https://drive.google.com/uc?id=1Tsx83BIRoW5-NspkOkGlE-835q760Ets";
        String imageURL3 = "https://drive.google.com/uc?id=1Y8i0aGFKIOWw-oGUpR2mt12RD6UpeL58";


        slideModels.add(new SlideModel(imageURL1, ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel(imageURL2, ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel(imageURL3, ScaleTypes.CENTER_CROP));

        // Set the slides in the ImageSlider
        imageSlider.setImageList(slideModels, ScaleTypes.CENTER_CROP);
        imageSlider.setImageList(slideModels, ScaleTypes.CENTER_CROP);
        imageSlider.setImageList(slideModels, ScaleTypes.CENTER_CROP);


        recyclerView = findViewById(R.id.recyclerView);

        // Set up RecyclerView with a grid layout
        GridLayoutManager gridLayoutManager = new GridLayoutManager(Employee.this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);

        // Initialize data list and populate it with AboutUsCategory objects
        dataList = new ArrayList<>();

        androidData = new EDataClass("Keysha Traya", "https://drive.google.com/uc?id=1pdw2OT9oIZNBpbMC9sgYHXkGVXzQX9af", "Receptionist", Boolean.TRUE);
        dataList.add(androidData);

        androidData = new EDataClass("Mark Henry San Luis", "https://drive.google.com/uc?id=1pdw2OT9oIZNBpbMC9sgYHXkGVXzQX9af", "Doctor", Boolean.TRUE);
        dataList.add(androidData);

        androidData = new EDataClass("Nheil Andreu Orongan", "https://drive.google.com/uc?id=1pdw2OT9oIZNBpbMC9sgYHXkGVXzQX9af", "Tambay", Boolean.TRUE);
        dataList.add(androidData);

        androidData = new EDataClass("Eloisa", "https://drive.google.com/uc?id=1pdw2OT9oIZNBpbMC9sgYHXkGVXzQX9af", "Inang", Boolean.TRUE);
        dataList.add(androidData);

        // Initialize and set up the adapter for the RecyclerView
        adapter = new EmployeeAdapter(Employee.this, dataList);
        recyclerView.setAdapter(adapter);

    }
}