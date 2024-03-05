package com.example.petallies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Settings extends AppCompatActivity {

    LinearLayout termsCondition;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        termsCondition = findViewById(R.id.termsCondition);
        termsCondition.setOnClickListener(v -> {
            Intent intent = new Intent(Settings.this, com.example.petallies.TermsCondition.class);
            startActivity(intent);
        });

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.bottom_settings);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.bottom_home){
                startActivity(new Intent(getApplicationContext(), Dashboard.class));
            } else if (item.getItemId() == R.id.bottom_message) {
                startActivity(new Intent(getApplicationContext(), Message.class));
            } else if (item.getItemId() == R.id.bottom_settings) {
                return true;
            }
            return false;
        });
    }
}