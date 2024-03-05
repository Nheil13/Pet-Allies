package com.example.petallies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class AboutUsDA extends AppCompatActivity {

    // UI elements
    TextView detailDesc, detailTitle;
    ImageView detailImage;
    ImageView ArrowBack;
    AppCompatButton contactButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_us_da);

        // Initialize UI elements
        ArrowBack = findViewById(R.id.arrowBack);
        ArrowBack.setOnClickListener(view -> AboutUsDA.super.onBackPressed());

        detailDesc = findViewById(R.id.detailDesc);
        detailTitle = findViewById(R.id.detailTitle);
        detailImage = findViewById(R.id.detailImage);

        // Retrieve data from the intent's bundle
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            detailDesc.setText(bundle.getInt("Desc"));
            Picasso.get().load(bundle.getString("Image")).into(detailImage);
            detailTitle.setText(bundle.getString("Title"));
        }

        // Set up a click listener for the contact button
        contactButton = findViewById(R.id.contactButton);
        contactButton.setOnClickListener(v ->{
            Intent intent = new Intent(AboutUsDA.this, com.example.petallies.Message.class);
            startActivity(intent);
        });
    }
}