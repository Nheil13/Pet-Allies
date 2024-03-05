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

public class DogsProduct extends AppCompatActivity {

    //UI Elements
    RecyclerView mainCategoryRecycler;
    ImageView ArrowBack;

    // Adapter for the RecyclerView
    MainRecyclerAdapter mainRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dogs_product);

        // Initialize UI elements
        ArrowBack = findViewById(R.id.arrowBack);
        ArrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DogsProduct.super.onBackPressed();
            }
        });

        // Create sample data for three categories ("Puppies", "Adults" and "Treats")
        List<CategoryItem> categoryItemList = new ArrayList<>();
        categoryItemList.add(new CategoryItem(1, "https://drive.google.com/uc?id=1hTNV8rZSjbYxc0a-bCgUeWSr00GDK5Mc", "Pedigree Chicken Flavour in\nGravy Puppy 130g", "₱ 45", "25"));
        categoryItemList.add(new CategoryItem(1, "https://drive.google.com/uc?id=1EHNzWg5l8gON1iGI7C9ltTZgRnUI0WcK", "Royal Canin Skin care Puppy 2kg", "₱ 1,700", "25"));
        categoryItemList.add(new CategoryItem(1, "https://drive.google.com/uc?id=1aycAu8Cy9ynrf4_u0P-kp7WxEGMu8GwX", "Vitality Value Meal Puppy", "₱ 190", "25"));

        List<CategoryItem> categoryItemList2 = new ArrayList<>();
        categoryItemList2.add(new CategoryItem(2, "https://drive.google.com/uc?id=16V_y_n5kOw8IaJvegMBy-eeub3TYqNLS", "Cesar Wet Dog Food Smoked\nBacon and Egg Flavor 100g", "₱ 75", "25"));
        categoryItemList2.add(new CategoryItem(2, "https://drive.google.com/uc?id=1rLMf0GebNIP-6XuFPbJ6CXvARHfnIvqg", "Cesar Wet Dog Food Turkey\nRecipe Flavor 100g", "₱ 75", "25"));
        categoryItemList2.add(new CategoryItem(2, "https://drive.google.com/uc?id=1dcDjV18qmUc0X5umlHv8A0R1dJCFkWLG", "Royal Canin Gastrointestinal\nAdult Can 410g", "₱ 260", "25"));
        categoryItemList2.add(new CategoryItem(2, "https://drive.google.com/uc?id=1RVlFFlTUx7LOCIC03JAdsqMz-CHWfbUu", "Royal Canin Hepatic\nAdult Can 410g", "₱ 260", "25"));
        categoryItemList2.add(new CategoryItem(2, "https://drive.google.com/uc?id=1MDoCwBCyw9odGP1_h32D2-XhWrr1L1Re", "Royal Canin Hypoallergenic\nAdult Can 410g", "₱ 260", "25"));
        categoryItemList2.add(new CategoryItem(2, "https://drive.google.com/uc?id=175adEJ6VHPuO7WK9D4ERVbQyFjVSEM1E", "Royal Canin Renal\nAdult Can 410g", "₱ 260", "25"));
        categoryItemList2.add(new CategoryItem(2, "https://drive.google.com/uc?id=1bfJV7H0hQNiAn12fPGmMl1nUx30CCval", "Royal Canin Urinary S/O\nAdult Can 410g", "₱ 260", "25"));
        categoryItemList2.add(new CategoryItem(2, "https://drive.google.com/uc?id=1SGXj_F4cxVaGk1doZTsh5fiLokDx5Eze", "Royal Canin Gastrointestinal\nAdult 2kg", "₱ 1,550", "25"));
        categoryItemList2.add(new CategoryItem(2, "https://drive.google.com/uc?id=1VEsJHFJHmrGCrtFd2WhRmjNavO_19vxL", "Royal Canin Hepatic Adult 2k", "₱ 1,450", "25"));
        categoryItemList2.add(new CategoryItem(2, "https://drive.google.com/uc?id=15l10PmvjUYzUvPI4tJmrEiNiLk_GENRi", "Royal Canin Renal Adult 2kg", "₱ 1,550", "25"));
        categoryItemList2.add(new CategoryItem(2, "https://drive.google.com/uc?id=15mURi_cs1V_PNWl534yb4RFZ5hDG5dqK", "Royal Canin Skin Support\nAdult 2kg", "₱ 1,550", "25"));
        categoryItemList2.add(new CategoryItem(2, "https://drive.google.com/uc?id=15mURi_cs1V_PNWl534yb4RFZ5hDG5dqK", "Royal Canin Skin Support\nAdult 2kg", "₱ 1,550", "25"));
        categoryItemList2.add(new CategoryItem(2, "https://drive.google.com/uc?id=1wmOtIS1gaJJ7VzGbS-MRUuz3C-BbBocS", "Royal Canin Urinary S/O\nAdult 2kg", "₱ 1,550", "25"));
        categoryItemList2.add(new CategoryItem(2, "https://drive.google.com/uc?id=1BUjiOHKlFBy1T9ZA1xRTSX0MzUu3xyBI", "Royal Canin Urinary S/O\nSmall Adult 2kg", "₱ 1,550", "25"));
        categoryItemList2.add(new CategoryItem(2, "https://drive.google.com/uc?id=15mURi_cs1V_PNWl534yb4RFZ5hDG5dqK", "Royal Canin Skin Support\nAdult 7kg", "₱ 5,800", "25"));
        categoryItemList2.add(new CategoryItem(2, "https://drive.google.com/uc?id=1wmOtIS1gaJJ7VzGbS-MRUuz3C-BbBocS", "Royal Canin Urinary S/O\nAdult 7.5kg", "₱ 4,500", "25"));
        categoryItemList2.add(new CategoryItem(2, "https://drive.google.com/uc?id=1Vh27R1gWw_OOJn4JD6RCz5W0TfmhF4Kg", "Vitality Classic Lamb and\nBeef 1kg", "₱ 200", "25"));
        categoryItemList2.add(new CategoryItem(2, "https://drive.google.com/uc?id=1Vh27R1gWw_OOJn4JD6RCz5W0TfmhF4Kg", "Vitality Classic Lamb and\nBeef 1kg", "₱ 200", "25"));
        categoryItemList2.add(new CategoryItem(2, "https://drive.google.com/uc?id=1HmtO5RGh7UsJTeR5Ptw2eMq9jXInJ0kV", "Vitality High Energy Lamb\nand Beef 1kg", "₱ 220", "25"));
        categoryItemList2.add(new CategoryItem(2, "https://drive.google.com/uc?id=1Xi_3vPkow-cpxxScm5AXIJcsqOIvJosS", "Vitality Value Meal\nAdult 1kg", "₱ 160", "25"));
        categoryItemList2.add(new CategoryItem(2, "https://drive.google.com/uc?id=1Vh27R1gWw_OOJn4JD6RCz5W0TfmhF4Kg", "Vitality Classic Lamb and\nBeef 3kg", "₱ 550", "25"));
        categoryItemList2.add(new CategoryItem(2, "https://drive.google.com/uc?id=1HmtO5RGh7UsJTeR5Ptw2eMq9jXInJ0kV", "Vitality High Energy Lamb\nand Beef 3kg", "₱ 580", "25"));

        List<CategoryItem> categoryItemList3 = new ArrayList<>();
        categoryItemList3.add(new CategoryItem(3, "https://drive.google.com/uc?id=1wbc95ubFjyd4a7GItbvQNdaoWj995WX3", "Pedigree Dentastix Medium Dog\n3 Sticks 77g", "₱ 90", "25"));
        categoryItemList3.add(new CategoryItem(3, "https://drive.google.com/uc?id=1q56ENcFGM3UEKaDxu0TKp0t74SWoX3jq", "Pedigree Dentastix Small Dog\n7 Sticks 110g", "₱ 130", "25"));
        categoryItemList3.add(new CategoryItem(3, "https://drive.google.com/uc?id=1f0mynhEq3hs1NK_DWN6a-_Oq5TxvBlkA", "Pedigree Dentastix Medium Dog\n7 Sticks 180g", "₱ 180", "25"));
        categoryItemList3.add(new CategoryItem(3, "https://drive.google.com/uc?id=1lihpA9OPOfYYd-cgB_TlK3z0PkNZstDZ", "Pedigree Dentastix Large Dog\n7 Sticks 270g", "₱ 200", "25"));
        categoryItemList3.add(new CategoryItem(3, "https://drive.google.com/uc?id=13LNQwC9PXUrOe1yrbW27ZTz8sAvzi3Gh", "Pet Plus Doggie Bites 80g", "₱ 100", "25"));
        categoryItemList3.add(new CategoryItem(3, "https://drive.google.com/uc?id=17SYGP84LJWld4NuoSWPFlwKogH8WYUn-", "Pet Plus Doggie Bites 250g", "₱ 150", "25"));
        categoryItemList3.add(new CategoryItem(3, "https://drive.google.com/uc?id=18ch102dHUYJc20YoyyJh68R-w-fwsLi5", "WujiBrand Jerky Stick Blueberry\nFlavor 70g", "N/A", "25")); // Need the price
        categoryItemList3.add(new CategoryItem(3, "https://drive.google.com/uc?id=181blQawgrK1eGBZ4Nxy7sy7XMqqbpKtR", "WujiBrand Jerky Stick Chicken\nFlavor 70g", "N/A", "25")); // Need the price
        categoryItemList3.add(new CategoryItem(3, "https://drive.google.com/uc?id=1BLYe6bC_Mi0PoPKwNxpVgEMEFJ9v32vY", "Yufeng Dog Biscuit Filled With\nBeef Flavor 220g", "₱ 150", "25"));
        categoryItemList3.add(new CategoryItem(3, "https://drive.google.com/uc?id=1Rr-ChFjNpXv-JYx2IPGK-qv_4HujuDCF", "Yufeng Dog Biscuit Filled With\nChicken Flavor 220g", "₱ 150", "25"));
        categoryItemList3.add(new CategoryItem(3, "https://drive.google.com/uc?id=19EgjU7OBtDSLkoRD1Epq6wwiTG1SK6PZ", "Yufeng Dog Biscuit\nMilk Flavor 220g", "₱ 150", "25"));
        categoryItemList3.add(new CategoryItem(3, "https://drive.google.com/uc?id=12FFtE5Ye1g-eKkEwDt4jsjHnjWaOjrUj", "Yufeng Dog Biscuit Melon\nFlavor 220g", "₱ 150", "25"));
        categoryItemList3.add(new CategoryItem(3, "https://drive.google.com/uc?id=1vZZ6fYtXBdkb7_Vuw4rM7rPnfsllqJsZ", "Yufeng Dog Biscuit Strawberry\nFlavor 220g", "₱ 150", "25"));


        // Create a list of AllCategory objects to represent each product category
        List<AllCategory> allCategoryList = new ArrayList<>();
        allCategoryList.add(new AllCategory("Puppies", categoryItemList));
        allCategoryList.add(new AllCategory("Adults", categoryItemList2));
        allCategoryList.add(new AllCategory("Treats", categoryItemList3));

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
        mainRecyclerAdapter = new MainRecyclerAdapter(this, allCategoryList);
        mainCategoryRecycler.setAdapter(mainRecyclerAdapter);

    }
}