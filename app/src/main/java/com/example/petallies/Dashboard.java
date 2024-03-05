package com.example.petallies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.squareup.picasso.Callback;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Dashboard extends AppCompatActivity {

    CardView Products, Services, Employees, AboutUs;
    ImageView imageProduct, imageServices, imageEmployees, imageAboutUs;
    String urlProduct, urlServices, urlEmployees, urlAboutUs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        // Announcement Banner Image
        /**
         * Setting up an ImageSlider using a library that utilizes SlideModel for image slides.
         * Three image URLs are defined to be displayed in the slider.
         * Each image URL is associated with a SlideModel, specifying CENTER_CROP scaling.
         * These SlideModels are added to an ArrayList, which is then used to populate the ImageSlider.
         *
         */

        ImageSlider imageSlider = findViewById(R.id.imageSlider);
        ArrayList<SlideModel> slideModels = new ArrayList<>();

        String imageURL1 = "https://drive.google.com/uc?id=1vwEds8yHlGdqKs_VSW3sXyu-RTeJyX-Z";
        String imageURL2 = "https://drive.google.com/uc?id=1GJWImxh1mIwwoxeCrOYez-lIHn1U9fPg";
        String imageURL3 = "https://drive.google.com/uc?id=1CA28j8mV8pMCFUke99LeRGUTWP7Dv-y8";
        String imageURL4 = "https://drive.google.com/uc?id=1CVNtYzjo-bxfENcoU-YaXFuaEVwqC0p4";
        String imageURL5 = "https://drive.google.com/uc?id=1CMuRQoPjCVOKZhD_sY8aJyCeIu6phXI-";

        slideModels.add(new SlideModel(imageURL1, ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel(imageURL2, ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel(imageURL3, ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel(imageURL4, ScaleTypes.CENTER_CROP));
        slideModels.add(new SlideModel(imageURL5, ScaleTypes.CENTER_CROP));

        // Set the slides in the ImageSlider
        imageSlider.setImageList(slideModels, ScaleTypes.CENTER_CROP);
        imageSlider.setImageList(slideModels, ScaleTypes.CENTER_CROP);
        imageSlider.setImageList(slideModels, ScaleTypes.CENTER_CROP);
        imageSlider.setImageList(slideModels, ScaleTypes.CENTER_CROP);
        imageSlider.setImageList(slideModels, ScaleTypes.CENTER_CROP);

        // Set the slides in the ImageSlider
        imageSlider.setImageList(slideModels, ScaleTypes.CENTER_CROP);

        //Handle Click Events
        Products = findViewById(R.id.products);
        Products.setOnClickListener(v -> {
            Intent intent = new Intent(Dashboard.this, com.example.petallies.Products.class);
            startActivity(intent);
        });

        Services = findViewById(R.id.services);
        Services.setOnClickListener(v -> {
            Intent intent = new Intent(Dashboard.this, com.example.petallies.Services.class);
            startActivity(intent);
        });



        Employees = findViewById(R.id.employees);
        Employees.setOnClickListener(v -> {
            Intent intent = new Intent(Dashboard.this, com.example.petallies.Employee.class);
            startActivity(intent);
        });



        /*
        AboutUs = findViewById(R.id.aboutUs);
        AboutUs.setOnClickListener(v -> {
            Intent intent = new Intent(Dashboard.this, com.example.petallies.AboutUs.class);
            startActivity(intent);
        });

         */


        // Initialize views
        imageProduct = findViewById(R.id.imageProduct);
        imageServices = findViewById(R.id.imageServices);
        imageEmployees = findViewById(R.id.imageEmployees);
        //imageAboutUs = findViewById(R.id.imageAboutUs);


        // Set the initial image URL
        urlProduct = "https://drive.google.com/uc?id=1PYgSHRstKm2LHHse_4tPaguZTXV-IbCG";
        loadImage();


        urlServices = "https://drive.google.com/uc?id=1sFkQeXgDDIpWViygCjvMEntu6US-vfaN";
        loadImage();



        urlEmployees = "https://drive.google.com/uc?id=1Sx1F2fXUaJsEfb70nX4r2c93-GkKEXns";
        loadImage();


        /*
        urlAboutUs = "https://drive.google.com/uc?id=1t_rQ1fevQ4Aqj_9UvkVagwxTe7PvGjEE";
        loadImage();
         */

        // Register a broadcast receiver to listen for network changes
        registerNetworkReceiver();

        /*
        //Bottom Navigation
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.bottom_home);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.bottom_home){
                return true;
            } else if (item.getItemId() == R.id.bottom_message) {
                startActivity(new Intent(getApplicationContext(), Message.class));
            } else if (item.getItemId() == R.id.bottom_settings) {
                startActivity(new Intent(getApplicationContext(), Settings.class));
            }
            return false;
        });
         */

    }

    /**
     * Registers a broadcast receiver to listen for changes in network connectivity.
     * When the network state changes, the `NetworkChangeReceiver` will be triggered.
     */
    private void registerNetworkReceiver() {
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(new NetworkChangeReceiver(), intentFilter);
    }

    /**
     * A BroadcastReceiver to handle changes in network connectivity.
     * When the network state changes and becomes available, it triggers the reloading of an image.
     */
    private class NetworkChangeReceiver extends BroadcastReceiver {
        /**
         * Called when the network connectivity changes.
         *
         * @param context The context in which the receiver is running.
         * @param intent  The intent containing information about the change.
         */
        @Override
        public void onReceive(Context context, Intent intent) {
            // Check if the network is connected
            if (isNetworkConnected()) {
                // Internet connection is available, reload the image
                loadImage();
            }
        }
    }

    /**
     * Checks if the device is currently connected to a network with internet access.
     *
     * @return True if the device is connected to the internet, false otherwise.
     */
    private boolean isNetworkConnected() {
        // Get the ConnectivityManager from the system service
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        // Check if there is an active network info and if it is connected
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }


    /**
     * Loads images using Picasso library for various image views.
     * Handles success and error cases for each image loading operation.
     */
    private void loadImage() {
        // Load image for 'urlProduct' into 'imageProduct'
        Picasso.get()
                .load(urlProduct)
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .into(imageProduct, new Callback() {
                    @Override
                    public void onSuccess() {
                        // Image loaded successfully, handle any success actions
                        imageProduct.setBackground(null);
                    }

                    @Override
                    public void onError(Exception e) {
                        // Handle error if image loading fails
                        Toast.makeText(Dashboard.this, "No Internet Connection, Please try again", Toast.LENGTH_SHORT).show();
                    }
                });


        // Load image for 'urlServices' into 'imageServices'
        Picasso.get()
                .load(urlServices)
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .into(imageServices, new Callback() {
                    @Override
                    public void onSuccess() {
                        // Image loaded successfully, handle any success actions
                        imageServices.setBackground(null);
                    }

                    @Override
                    public void onError(Exception e) {
                        // Handle error if image loading fails
                    }
                });



        // Load image for 'urlEmployees' into 'imageEmployees'
        Picasso.get()
                .load(urlEmployees)
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .into(imageEmployees, new Callback() {
                    @Override
                    public void onSuccess() {
                        // Image loaded successfully, handle any success actions
                        imageEmployees.setBackground(null);
                    }

                    @Override
                    public void onError(Exception e) {
                        // Handle error if image loading fails
                    }
                });


        /*
        // Load image for 'urlAboutUs' into 'imageAboutUs'
        Picasso.get()
                .load(urlAboutUs)
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .into(imageAboutUs, new Callback() {
                    @Override
                    public void onSuccess() {
                        // Image loaded successfully, handle any success actions
                        imageAboutUs.setBackground(null);
                    }

                    @Override
                    public void onError(Exception e) {
                        // Handle error if image loading fails
                    }
                });
         */
    }

}