package com.example.petallies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.petallies.adapter.MainRecyclerAdapter;
import com.example.petallies.model.AllCategory;
import com.example.petallies.model.CategoryItem;

import java.util.ArrayList;
import java.util.List;

public class CatProducts extends AppCompatActivity {

    RecyclerView mainCategoryRecycler;
    ImageView ArrowBack;

    // Adapter for the RecyclerView
    MainRecyclerAdapter mainRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cat_products);

        // Initialize UI elements
        ArrowBack = findViewById(R.id.arrowBack);
        ArrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CatProducts.super.onBackPressed();
            }
        });

        // Create sample data for two categories ("Adults" and "Treats")
        List<CategoryItem> categoryItemList = new ArrayList<>();
        categoryItemList.add(new CategoryItem(1, "https://drive.google.com/uc?id=1p7qwomqcOwsxyqtGXfcddCYS8H04d7KG", "Royal Canin Gastrointestinal 2kg", "₱ 1,650", "25"));
        categoryItemList.add(new CategoryItem(1, "https://drive.google.com/uc?id=15vuT1OzOz_DpDIGN5lwxlGpYlzZmYYJI", "Royal Canin Renal 2kg", "₱ 1,700", "25"));
        categoryItemList.add(new CategoryItem(1, "https://drive.google.com/uc?id=1zrfpCPEvK_QAp_BCfXifKwAozANORdst", "Royal Canin Urinary S/O 2kg", "₱ 1,450", "25"));

        List<CategoryItem> categoryItemList2 = new ArrayList<>();
        categoryItemList2.add(new CategoryItem(2, "https://drive.google.com/uc?id=1Jxnm--I6OQWv_clR7L0kfqJPcMkv_G5J", "Brit Care Shiny Hair Snacks for Cat", "₱ 95", "25"));
        categoryItemList2.add(new CategoryItem(2, "https://drive.google.com/uc?id=1GC9OA1HXvmTXuadD3qU8dtNmSzFUQ0Xv", "Temptations Savoury Salmon Flavour", "₱ 120", "25"));
        categoryItemList2.add(new CategoryItem(2, "https://drive.google.com/uc?id=1M1t1KDOiKvJiTrSTN8B12QurByrZWJhE", "Whiskas 2-12 Months Tuna Flavour 80g", "₱ 35", "25"));

        // Create a list of AllCategory objects to represent each product category
        List<AllCategory> allCategoryList = new ArrayList<>();
        allCategoryList.add(new AllCategory("Adults", categoryItemList));
        allCategoryList.add(new AllCategory("Treats", categoryItemList2));

        // Set up the mainCategoryRecycler with the provided data
        setMainCategoryRecycler(allCategoryList);
    }

    /**
     * Sets up the RecyclerView (mainCategoryRecycler) with the provided list of product categories.
     *
     * @param allCategoryList List of AllCategory objects representing product categories.
     */
    private void setMainCategoryRecycler(List<AllCategory> allCategoryList){
        mainCategoryRecycler = findViewById(R.id.main_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mainCategoryRecycler.setLayoutManager(layoutManager);

        // Initialize and set up the adapter for the RecyclerView
        mainRecyclerAdapter = new MainRecyclerAdapter(this, allCategoryList);
        mainCategoryRecycler.setAdapter(mainRecyclerAdapter);
    }
}