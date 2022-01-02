package com.example.frypto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IntroActivityOne extends AppCompatActivity {

    Button skipButton;
    Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_one);

        //disable action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        //background animation
        ConstraintLayout cl = findViewById(R.id.mainLayout);
        AnimationDrawable ad = (AnimationDrawable) cl.getBackground();
        ad.setEnterFadeDuration(1500);
        ad.setExitFadeDuration(3000);
        ad.start();

        nextButton = findViewById(R.id.nextButton);

        nextButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(IntroActivityOne.this, IntroActivityTwo.class);
                startActivity(i);
            }
        });

        skipButton = findViewById(R.id.skipButton);

        skipButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(IntroActivityOne.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}