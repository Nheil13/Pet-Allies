package com.example.petallies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.squareup.picasso.Callback;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

public class Message extends AppCompatActivity {

    CardView Location, Contact, Facebook;
    ImageView imageAnnouncement, imageLocation, imageContact, imageEmail, imageFacebook;
    String urlAnnouncement, urlLocation, urlContact, urlEmail, urlFacebook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message);

        // Set up CardViews with click listener
        Location = findViewById(R.id.location);
        Location.setOnClickListener(view -> gotoUrl("https://goo.gl/maps/SrfBkWspSTnrJk6p8"));

        Contact = findViewById(R.id.contactNumber);
        Contact.setOnClickListener(view ->{
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:09257255437"));
            startActivity(intent);
        });

        Facebook = findViewById(R.id.facebook);
        Facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFacebookPage();
            }

            private void openFacebookPage() {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/" + "436277049887658"));
                    startActivity(intent);
                } catch (Exception e){
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/pages/Pet-Allies-Animal-Clinic/" + "436277049887658"));
                    startActivity(intent);
                }
            }
        });

        imageAnnouncement = findViewById(R.id.announcementBanner);
        imageLocation = findViewById(R.id.imageLocation);
        imageContact = findViewById(R.id.imageContacts);
        imageEmail = findViewById(R.id.imageEmail);
        imageFacebook = findViewById(R.id.imageFacebook);

        urlAnnouncement = "https://drive.google.com/uc?id=1XwOXpSfpUMMjdP-jITNv_NQTuFCP0q5a";
        //loadImage();

        urlLocation = "https://drive.google.com/uc?id=14GsK4RmZ4IlshwJPrTlm6vjdnRIPpxmu";
        //loadImage();

        urlContact = "https://drive.google.com/uc?id=14dcnft2n4-1J6U_db0YWiDabEsM8FVbt";
        //loadImage();

        urlEmail = "https://drive.google.com/uc?id=1fZ7xzCTceMPmTSCh5iutKn5cyYCMxuQK";
        //loadImage();

        urlFacebook = "https://drive.google.com/uc?id=1NwEvqt08cvgKhPxhyQP9LvIy3qABRqjA";
        //loadImage();

        // Register a broadcast receiver to listen for network changes
        registerNetworkReceiver();

        //Bottom Navigation
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.bottom_message);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.bottom_home){
                startActivity(new Intent(getApplicationContext(), Dashboard.class));
            } else if (item.getItemId() == R.id.bottom_message) {
                return true;
            } else if (item.getItemId() == R.id.bottom_settings) {
                startActivity(new Intent(getApplicationContext(), Settings.class));
            }
            return false;
        });
    }

    // Open URL in browser
    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

    // Handle back button press
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(), Dashboard.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // Clears the activity stack
        startActivity(intent);
        finish(); // Closes this activity and removes it from the activity stack
    }

    private void registerNetworkReceiver () {
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(new NetworkChangeReceiver(), intentFilter);
    }

    private class NetworkChangeReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent){
            if (isNetworkConnected()) {
                loadImage();
            }
        }
    }

    private boolean isNetworkConnected(){
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }

    private void loadImage(){
        Picasso.get()
                .load(urlAnnouncement)
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .into(imageAnnouncement, new Callback() {
                    @Override
                    public void onSuccess() {
                        // Image loaded successfully, handle any success actions
                        imageAnnouncement.setBackground(null);
                    }

                    @Override
                    public void onError(Exception e) {
                        // Handle error if image loading fails
                        Toast.makeText(Message.this, "No Internet Connection, Please try again", Toast.LENGTH_SHORT).show();
                    }
                });


        Picasso.get()
                .load(urlLocation)
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .into(imageLocation, new Callback() {
                    @Override
                    public void onSuccess() {
                        // Image loaded successfully, handle any success actions
                        imageLocation.setBackground(null);
                    }

                    @Override
                    public void onError(Exception e) {
                        // Handle error if image loading fails
                    }
                });

        Picasso.get()
                .load(urlContact)
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .into(imageContact, new Callback() {
                    @Override
                    public void onSuccess() {
                        // Image loaded successfully, handle any success actions
                        imageContact.setBackground(null);
                    }

                    @Override
                    public void onError(Exception e) {
                        // Handle error if image loading fails
                    }
                });

        Picasso.get()
                .load(urlEmail)
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .into(imageEmail, new Callback() {
                    @Override
                    public void onSuccess() {
                        // Image loaded successfully, handle any success actions
                        imageEmail.setBackground(null);
                    }

                    @Override
                    public void onError(Exception e) {
                        // Handle error if image loading fails
                    }
                });

        Picasso.get()
                .load(urlFacebook)
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .into(imageFacebook, new Callback() {
                    @Override
                    public void onSuccess() {
                        // Image loaded successfully, handle any success actions
                        imageFacebook.setBackground(null);
                    }

                    @Override
                    public void onError(Exception e) {
                        // Handle error if image loading fails
                    }
                });
    }

}