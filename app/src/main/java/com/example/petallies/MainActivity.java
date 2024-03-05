package com.example.petallies;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Set up full-screen mode
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Set the layout for the main activity
        setContentView(R.layout.activity_main);

        ProgressBar loadingProgressBar = findViewById(R.id.loadingProgressBar);

        //To show the loading circle
        loadingProgressBar.setVisibility(View.VISIBLE);

        int SPLASH_SCREEN = 5000;

        // Use a Handler to delay the transition to the 'Dashboard' activity
        /*new Handler().postDelayed(() -> {
            Intent intent = new Intent(MainActivity.this, Dashboard.class);

            // Check if ActivityOptions is supported
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this);
            startActivity(intent, options.toBundle());

            // Finish the current activity to prevent going back to it from the Login activity
            finish();
        }, SPLASH_SCREEN);*/
    }
}