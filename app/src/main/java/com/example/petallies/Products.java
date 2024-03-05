package com.example.petallies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Callback;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

public class Products extends AppCompatActivity {

    ImageView ArrowBack;
    ImageView imageCats, imageDogs, imageVitamins, imageEssentials;
    String urlCats, urlDogs, urlVitamins, urlEssentials;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.products);

        //Back Arrow
        ArrowBack = findViewById(R.id.arrowBack);
        ArrowBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Products.super.onBackPressed();
            }
        });

        //Handle Click Events
        imageCats = findViewById(R.id.catCategory);
        imageCats.setOnClickListener(v -> {
            Intent intent = new Intent(Products.this, com.example.petallies.CatProducts.class);
            startActivity(intent);
        });


        imageDogs = findViewById(R.id.dogCategory);
        imageDogs.setOnClickListener(v -> {
            Intent intent = new Intent(Products.this, com.example.petallies.DogsProduct.class);
            startActivity(intent);
        });


        imageVitamins = findViewById(R.id.vitaminSupplementCategory);
        imageVitamins.setOnClickListener(v -> {
            Intent intent = new Intent(Products.this, com.example.petallies.VitaminsSupplements.class);
            startActivity(intent);
        });


        imageEssentials = findViewById(R.id.otherEssentialsCategory);
        imageEssentials.setOnClickListener(v -> {
            Intent intent = new Intent(Products.this, com.example.petallies.OtherEssential.class);
            startActivity(intent);
        });

        //Initialize views
        imageCats = findViewById(R.id.catCategory);

        urlCats = "https://drive.google.com/uc?id=1aYV-JHUhFvu6Jcttcu5c0jpdYQ7oWA8Z";
        loadImage();

        urlDogs = "https://drive.google.com/uc?id=1NpmP3_uO2KRWD168Ngr3ErsZxL0CSEwz";
        loadImage();

        urlVitamins = "https://drive.google.com/uc?id=1Px6_OMe0631zHgspNgJChcpZMd5xY9lG";
        loadImage();

        urlEssentials = "https://drive.google.com/uc?id=1Mq-UkgwUZD821bzvfMyWM4Ni0j3D7H1L";
        loadImage();

        // Register a broadcast receiver to listen for network changes
        registerNetworkReceiver();
    }

    private void registerNetworkReceiver(){
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(new NetworkChangeReceiver(), intentFilter);
    }

    private class NetworkChangeReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent){
            if (isNetworkConnected()){
                //Internet connection is available, reload the image;
                loadImage();
            }
        }
    }

    private boolean isNetworkConnected(){
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }

    private void loadImage() {
        Picasso.get()
                .load(urlCats)
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .into(imageCats, new Callback() {
                    @Override
                    public void onSuccess() {
                        // Image loaded successfully, handle any success actions
                        imageCats.setBackground(null);
                    }

                    @Override
                    public void onError(Exception e) {
                        // Handle error if image loading fails
                        Toast.makeText(Products.this, "No Internet Connection, Please try again", Toast.LENGTH_SHORT).show();
                    }
                });

        Picasso.get()
                .load(urlDogs)
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .into(imageDogs, new Callback() {
                    @Override
                    public void onSuccess() {
                        // Image loaded successfully, handle any success actions
                        imageDogs.setBackground(null);
                    }

                    @Override
                    public void onError(Exception e) {
                        // Handle error if image loading fails
                        Toast.makeText(Products.this, "No Internet Connection, Please try again", Toast.LENGTH_SHORT).show();
                    }
                });

        Picasso.get()
                .load(urlVitamins)
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .into(imageVitamins, new Callback() {
                    @Override
                    public void onSuccess() {
                        // Image loaded successfully, handle any success actions
                        imageVitamins.setBackground(null);
                    }

                    @Override
                    public void onError(Exception e) {
                        // Handle error if image loading fails
                        Toast.makeText(Products.this, "No Internet Connection, Please try again", Toast.LENGTH_SHORT).show();
                    }
                });

        Picasso.get()
                .load(urlEssentials)
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .into(imageEssentials, new Callback() {
                    @Override
                    public void onSuccess() {
                        // Image loaded successfully, handle any success actions
                        imageEssentials.setBackground(null);
                    }

                    @Override
                    public void onError(Exception e) {
                        // Handle error if image loading fails
                        Toast.makeText(Products.this, "No Internet Connection, Please try again", Toast.LENGTH_SHORT).show();
                    }
                });

    }
}