package com.example.petallies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

public class TermsCondition extends AppCompatActivity {

    ImageView arrowBack;

    TextView termsText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_condition);

        // Initialize UI elements
        arrowBack = findViewById(R.id.arrow_back);
        arrowBack.setOnClickListener(view -> TermsCondition.super.onBackPressed());

        termsText = findViewById(R.id.termsText);

        // Assuming 'terms_and_conditions_text' is an HTML string
        String htmlString = getString(R.string.terms_and_conditions_text);
        termsText.setText(Html.fromHtml(htmlString));

        // Enable text selection
        termsText.setTextIsSelectable(true);

    }
}