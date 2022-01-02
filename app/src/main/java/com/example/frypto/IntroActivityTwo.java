package com.example.frypto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IntroActivityTwo extends AppCompatActivity {
    Button skipButton;
    Button nextButton;
    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_two);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        nextButton = findViewById(R.id.nextButton);

        nextButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(IntroActivityTwo.this, IntroActivityThree.class);
                startActivity(i);
            }
        });

        backButton = findViewById(R.id.backButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(IntroActivityTwo.this, IntroActivityOne.class);
                startActivity(i);
            }
        });

        skipButton = findViewById(R.id.skipButton);

        skipButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(IntroActivityTwo.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}