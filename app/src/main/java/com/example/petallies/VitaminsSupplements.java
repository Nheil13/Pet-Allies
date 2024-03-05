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

public class VitaminsSupplements extends AppCompatActivity {

    //UI Elements
    RecyclerView mainCategoryRecycler;
    ImageView ArrowBack;

    // Adapter for the RecyclerView
    MainRecyclerAdapter mainRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vitamins_supplements);

        //Back Arrow
        ArrowBack = findViewById(R.id.arrowBack);
        ArrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VitaminsSupplements.super.onBackPressed();
            }
        });

        // Create sample data for five categories ("Ear Drops", "Eye Drops", "Supplements", "Wounded Cream", and "Anti Ticks and Fleas")
        List<CategoryItem> categoryItemList = new ArrayList<>();
        categoryItemList.add(new CategoryItem(1, "https://drive.google.com/uc?id=1tZffPEVSN38IeGih3fYzIsEVgR_NIWpb", "Otiderm Ear Drops Antibacterial\nInsecticidal 15ml", "₱ 500", "25"));
        categoryItemList.add(new CategoryItem(1, "https://drive.google.com/uc?id=13_r8lIMm77nGP-vN5BSVRQvOfAK9kRkx", "Pa Well Earmite Buster 60ml", "₱ 350", "25"));
        categoryItemList.add(new CategoryItem(1, "https://drive.google.com/uc?id=1NG0-brb6KNcQMFD_P2oCpTNVHgaANIwo", "Virbac Easotic Corticosteroid\nAntifungal/Antibacterial 10ml", "₱ 900", "25"));

        List<CategoryItem> categoryItemList2 = new ArrayList<>();
        categoryItemList2.add(new CategoryItem(2, "https://drive.google.com/uc?id=1sq9F-COX8-X2UwLt810OLDYyDxPUkr6P", "Gentin Gentacimin Sulfate 7ml", "Need Information", "25")); // Need Information
        categoryItemList2.add(new CategoryItem(2, "https://drive.google.com/uc?id=1hByc-3L_OZJbn_dEGllYaEow5RDvTOZ-", "Isore Antibacterial\nCorticosteroid 5ml", "₱ 260", "25"));

        List<CategoryItem> categoryItemList3 = new ArrayList<>();
        categoryItemList3.add(new CategoryItem(3, "https://drive.google.com/uc?id=1ALXhhotTrxwH8QnkRVTG8eHJUp77As3q", "Papi ENER-G Probiotic\nSupplement 60ml", "₱ 350", "25"));
        categoryItemList3.add(new CategoryItem(3, "https://drive.google.com/uc?id=1eaOsDgn0KsTg17KS12iFpQb_HL2G2U2D", "Animal Science Anti-Coprophagic\nChewable Tablet Dog Supplement", "₱ 850", "25"));
        categoryItemList3.add(new CategoryItem(3, "https://drive.google.com/uc?id=1-F6EbqvN1-iG0Erh66IISVYdraTLn1Yj", "Nutri Pawz Livwell 60 Tablets", "₱ 850", "25"));
        categoryItemList3.add(new CategoryItem(3, "https://drive.google.com/uc?id=1Ut-nrXZp2-XlwZzxB9KFjlDlMfHFG6Z_", "Himalaya Nefrotec DS", "Need Information", "25")); // Need Information
        categoryItemList3.add(new CategoryItem(3, "https://drive.google.com/uc?id=12Vm05_IJdHHhHJ7fzeuctkKGKhtHIYd7", "Papi Bron Cure 60ml", "₱ 350", "25"));
        categoryItemList3.add(new CategoryItem(3, "https://drive.google.com/uc?id=1y9233UcyfOBl6ltR7yB5BE6wWELih7K_", "Mucotan Oral Suspension\nAntibiotic/Mucolytic 60ml", "₱ 350", "25"));
        categoryItemList3.add(new CategoryItem(3, "https://drive.google.com/uc?id=1RSvBqF8tWRVSjb_cZmngEJP_9kLdC799", "Minerals Iron-Aid 60ml", "₱ 385", "25"));
        categoryItemList3.add(new CategoryItem(3, "https://drive.google.com/uc?id=1lqoOJGPOjI--Rl-gJQYHqqliNjZss2N_", "Venworld Thromb Beat Syrup 100ml", "₱ 750", "25"));
        categoryItemList3.add(new CategoryItem(3, "https://drive.google.com/uc?id=1Ok04NhEivLg6SD1DrTXK1mZoVzFzfNDN", "Liver Gard Performance\nEnhancer 120ml", "₱ 350", "25"));
        categoryItemList3.add(new CategoryItem(3, "https://drive.google.com/uc?id=1yQ8Ghg5gtsEzbIxVWBswB3UIfge40NRa", "Papi Livwell Dietary\nSupplement 60ml", "₱ 300", "25"));
        categoryItemList3.add(new CategoryItem(3, "https://drive.google.com/uc?id=1l2EqfRZRdizEVW9wuHkxfI80KQ3bC-ql", "Renal Care Syrup 120ml", "₱ 400", "25"));
        categoryItemList3.add(new CategoryItem(3, "https://drive.google.com/uc?id=1pTmNYX2lKrVM9vPMKyGA7bzM6DtBdusT", "Pa Well Multivitamins + Minerals +\n Lysine with Electrolytes 120ml", "₱ 400", "25"));
        categoryItemList3.add(new CategoryItem(3, "https://drive.google.com/uc?id=1qGBzenGcYBnHyggppzzBTHyESZbq7dW-", "LC-VIT Syrup Vitamins/Amino\nAcid 120ml", "₱ 300", "25"));
        categoryItemList3.add(new CategoryItem(3, "https://drive.google.com/uc?id=1GmHXMBXbi6jujpF5dImoGHDyxtzu9r4P", "LC-VIT Plus Syrup 120ml", "₱ 300", "25"));
        categoryItemList3.add(new CategoryItem(3, "https://drive.google.com/uc?id=1t04i0n5nqFi3mFYlzZxOSD0yqLIKAOmS", "Papi Papi OB 5ml Syrup(Strawberry\nflavor) Vitamins/Minerals 120ml", "₱ 350", "25"));
        categoryItemList3.add(new CategoryItem(3, "https://drive.google.com/uc?id=1383FwrlCxhO9fvjKg3gdROeBxuX7a5N7", "Oasis milk aid for life 120ml", "₱ 350","25"));
        categoryItemList3.add(new CategoryItem(3, "https://drive.google.com/uc?id=1WUJ8CNvIw67a_fH5BNcsUlEUWrYEaOE3", "Coatshine Performance\nEnhancer 120ml", "₱ 380", "25"));
        categoryItemList3.add(new CategoryItem(3, "https://drive.google.com/uc?id=1obJjJgXs0HGzNH5K6dMWbQcPG-UWTqCM", "Naturvet Love Drops Skin and Coat\nSupplement 520g", "₱ 1,650", "25"));
        categoryItemList3.add(new CategoryItem(3, "https://drive.google.com/uc?id=10S1QjyvMYBdacHzp2Ge3CHvEvVOON_s2", "NaturVet Love Brewers Dried Yeast\nFormulated with Garlic Flavoring 500g", "₱ 350", "25"));

        List<CategoryItem> categoryItemList4 = new ArrayList<>();
        categoryItemList4.add(new CategoryItem(4, "https://drive.google.com/uc?id=1CdujvA43xIfIgqk30vPb_pRMOAJtaRFE", "Kiskin Skin Cream 20g", "₱ 350", "25"));
        categoryItemList4.add(new CategoryItem(4, "https://drive.google.com/uc?id=1dSxkyjT6v0P4sAuaLX4CnEIyN8n1Zgfb", "Papi Topi-Derm FS", "₱ 250", "25"));
        categoryItemList4.add(new CategoryItem(4, "https://drive.google.com/uc?id=1G3jBGNArQyPOuAaPiB1uz9jC7YoatvdQ", "Vetnoderm Anti-fungal\nAnti-bacterial Cream 10g", "₱ 220", "25"));

        List<CategoryItem> categoryItemList5 = new ArrayList<>();
        categoryItemList5.add(new CategoryItem(5, "https://drive.google.com/uc?id=1ntqITZF9caS2SSJm7oDD4vK2expiF-vX", "NexGard chewable tablets for\ndogs 25.1-50kg 3 chewable tablets", "₱ 1,740", "25"));
        categoryItemList5.add(new CategoryItem(5, "https://drive.google.com/uc?id=11oBf8V75JJEBKY0x1aeUqIUVOH0dBtVq", "NexGard chewable tablets for\ndogs 10-25kg 3 chewable tablets", "₱ 1,620", "25"));
        categoryItemList5.add(new CategoryItem(5, "https://drive.google.com/uc?id=1FdOrWcd5sdQ-icoTdP7Ce1fi9sPeHX5J", "NexGard chewable tablets for\ndogs 2-4kg 3 chewable tablets", "₱ 1,620", "25"));
        categoryItemList5.add(new CategoryItem(5, "https://drive.google.com/uc?id=1E3b_L5d2fIc6uhV7wYulsQ6hVzDeTTuH", "Nexgard Spectra Anti Tick and\nFlea for DOGS 3 Chewable Tablet\n7.5-19kg", "Need Information", "25")); //Need Information
        categoryItemList5.add(new CategoryItem(5, "https://drive.google.com/uc?id=19MDrRKN9zbWcdkdmp697mG7lyPOWOPjJ", "Nexgard Spectra Anti Tick and\nFlea for DOGS 3 Chewable Tablet\n3.5-7.5kg", "₱ 1,950", "25"));

        // Create a list of AllCategory objects to represent each product category
        List<AllCategory> allCategoryList = new ArrayList<>();
        allCategoryList.add(new AllCategory("Ear Drops", categoryItemList));
        allCategoryList.add(new AllCategory("Eye Drops", categoryItemList2));
        allCategoryList.add(new AllCategory("Supplements", categoryItemList3));
        allCategoryList.add(new AllCategory("Wounded Cream", categoryItemList4));
        allCategoryList.add(new AllCategory("Anti Ticks and Fleas", categoryItemList5));

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