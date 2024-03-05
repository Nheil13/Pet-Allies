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

public class OtherEssential extends AppCompatActivity {

    //UI Elements
    RecyclerView mainCategoryRecycler;
    ImageView ArrowBack;

    // Adapter for the RecyclerView
    MainRecyclerAdapter mainRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other_essential);

        //Back Arrow
        ArrowBack = findViewById(R.id.arrowBack);
        ArrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OtherEssential.super.onBackPressed();
            }
        });

        // Create sample data for six categories ("Colognes", "Diapers", "Shampoos", "Soap", "Toothpaste", and "Pet Wipes")
        List<CategoryItem> categoryItemList = new ArrayList<>();
        categoryItemList.add(new CategoryItem(1, "https://drive.google.com/uc?id=12jKkbsDuKUwnplTCPxwVVv9X6jE0Z4Cd", "Bayli 3 Action Formula Pet Cologne\nFor Cats and Dogs Aqua Blue\nScent 100ML", "₱ 250", "25"));
        categoryItemList.add(new CategoryItem(1, "https://drive.google.com/uc?id=14kW09lhFo_436GawJJ_PObL2myS8QE9t", "Bayli 3 Action Formula Pet Cologne\nFor Cats and Dogs Blossom\nScent 100ML", "₱ 250", "25"));
        categoryItemList.add(new CategoryItem(1, "https://drive.google.com/uc?id=1fcTR-a1N87Rale2KYGBLpfabhmJVvaum", "Bayli 3 Action Formula Pet Cologne\nFor Cats and Dogs Sweet Baby\nScent 100ML", "₱ 250", "25"));

        List<CategoryItem> categoryItemList2 = new ArrayList<>();
        categoryItemList2.add(new CategoryItem(2, "https://drive.google.com/uc?id=1KOyB6otIk942O7N6euN6INCIAAZrVzyx", "Hushpet Male Wraps\n12 pieces Large", "Need Information", "25")); //Need Information

        List<CategoryItem> categoryItemList3 = new ArrayList<>();
        categoryItemList3.add(new CategoryItem(3, "https://drive.google.com/uc?id=1Hd6rSAfJhOGxgJOWnMR6zwcAKs_AiYlR", "Bearing Tick and Fleas Dog\nShampoo for all dogs 300ml", "₱ 200", "25"));
        categoryItemList3.add(new CategoryItem(3, "https://drive.google.com/uc?id=1eWV8QSeA4IAHA3noMPaJEsqXr1PtxkMw", "Bearing Tick and Fleas Dog\nShampoo long hair 300ml", "₱ 200", "25"));
        categoryItemList3.add(new CategoryItem(3, "https://drive.google.com/uc?id=1WeH8gRIJN6s7oiT9pztxVHut6aNXkbgj", "Bearing Tick and Fleas Dog\nShampoo small breeds 300ml", "₱ 200", "25"));
        categoryItemList3.add(new CategoryItem(3, "https://drive.google.com/uc?id=1s4qp1cuHKoS0pZQJ3m0tMQAcNqFiFK7b", "Bearing Tick and Fleas Dog\nShampoo smelly hair 300ml", "₱ 200", "25"));
        categoryItemList3.add(new CategoryItem(3, "https://drive.google.com/uc?id=1H4--ENO5PZ37Ievmjom5R3lyKmoXN4Xb", "Bearing Tick and Fleas Dog\nShampoo short hair 300ml", "₱ 200", "25"));

        List<CategoryItem> categoryItemList4 = new ArrayList<>();
        categoryItemList4.add(new CategoryItem(4, "https://drive.google.com/uc?id=1bZrdWU04kbcUMaz4TvQZ6tY0yNBCoy1C", "Bayli 3 Action Pet Soap 120g", "₱ 200", "25"));
        categoryItemList4.add(new CategoryItem(4, "https://drive.google.com/uc?id=1keG-vzeMLsN7GptY91x1pqqDwM9PudH-", "Fipronil Furfect Soap 150g", "₱ 200", "25"));
        categoryItemList4.add(new CategoryItem(4, "https://drive.google.com/uc?id=1PaHq7Ecvyr1NnvAKb-1vlklUcMxQk1P4", "Vetnoderm Medicated\nHerbal Soap 145g", "₱ 150", "25"));

        List<CategoryItem> categoryItemList5 = new ArrayList<>();
        categoryItemList5.add(new CategoryItem(5, "https://drive.google.com/uc?id=1vm8zDh_YbWaitee15raM2e1Or6GwPm1M", "Dental Care Beef Flavor 95g", "₱ 215", "25"));

        List<CategoryItem> categoryItemList6 = new ArrayList<>();
        categoryItemList6.add(new CategoryItem(6, "https://drive.google.com/uc?id=1YQTuBmxqutzJsFFia_ue_aTkFTYdlBEt", "Dono Pet Wipes 80pcs", "₱ 200", "25"));

        // Create a list of AllCategory objects to represent each product category
        List<AllCategory> allCategoryList = new ArrayList<>();
        allCategoryList.add(new AllCategory("Colognes", categoryItemList));
        allCategoryList.add(new AllCategory("Diapers", categoryItemList2));
        allCategoryList.add(new AllCategory("Shampoos", categoryItemList3));
        allCategoryList.add(new AllCategory("Soap", categoryItemList4));
        allCategoryList.add(new AllCategory("Toothpaste", categoryItemList5));
        allCategoryList.add(new AllCategory("Pet Wipes", categoryItemList6));

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