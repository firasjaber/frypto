package com.example.frypto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class CoinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coin);


        WebView engine = (WebView) findViewById(R.id.webView);
        String coinName = getIntent().getStringExtra("name");
        engine.getSettings().setJavaScriptEnabled(true);
        engine.getSettings().setAppCacheEnabled(false);
        engine.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        String url = "https://coinmarketcap.com/currencies/" + coinName + "/";
        engine.loadUrl(url);
    }
}