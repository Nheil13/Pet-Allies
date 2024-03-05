package com.example.petallies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ServicesAD extends AppCompatActivity {

    //UI Elements
    TextView sDetailDesc, sDetailTitle;
    ImageView sDetailImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.services_ad);

        // Initializing views
        sDetailDesc = findViewById(R.id.sDetailDesc);
        sDetailTitle = findViewById(R.id.sDetailTitle);
        sDetailImage = findViewById(R.id.sDetailImage);

        // Retrieving data from the intent's extras (Bundle)
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            // Setting description text
            sDetailDesc.setText(bundle.getInt("Desc"));

            // Loading and displaying image using Picasso
            Picasso.get().load(bundle.getString("Image")).into(sDetailImage);

            // Setting title text
            sDetailTitle.setText(bundle.getString("Title"));
        }
    }
}