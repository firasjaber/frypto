package com.example.frypto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.frypto.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ListView superListView;

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSuperHeroes();

        superListView = findViewById(R.id.coinsList);

    }

    private void getSuperHeroes() {
        Call<Results> call = RetrofitClient.getInstance().getMyApi().getsuperHeroes();
        call.enqueue(new Callback<Results>() {
            @Override
            public void onResponse(Call<Results> call, Response<Results> response) {
                Results result = response.body();
                ArrayList<Coin> coinsList = result.getCoins();
                ListAdapter listAdapter = new ListAdapter(MainActivity.this,coinsList);
                superListView.setAdapter(listAdapter);
            }

            @Override
            public void onFailure(Call<Results> call, Throwable t) {
                System.out.println(t.toString());
                Toast.makeText(getApplicationContext(), "An error has occured", Toast.LENGTH_LONG).show();
            }


        });
    }
}