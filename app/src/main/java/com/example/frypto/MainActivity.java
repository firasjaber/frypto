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

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ListView superListView;

    Button call;
    TextView res;

    String r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        superListView = findViewById(R.id.superListView);
        call = findViewById(R.id.call);
        res = findViewById(R.id.res);
        call.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                getSuperHeroes();
                res.setText(r);
            }});
    }

    private void getSuperHeroes() {
        Call<Results> call = RetrofitClient.getInstance().getMyApi().getsuperHeroes();
        call.enqueue(new Callback<Results>() {
            @Override
            public void onResponse(Call<Results> call, Response<Results> response) {
                Results result = response.body();
                ArrayList<Coin> coinsList = result.getCoins();
                String[] oneHeroes = new String[coinsList.size()];

                for (int i = 0; i < coinsList.size(); i++) {
                    oneHeroes[i] = coinsList.get(i).getName();
                    System.out.println(oneHeroes[i]);
                }

                superListView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, oneHeroes));
            }

            @Override
            public void onFailure(Call<Results> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "An error has occured", Toast.LENGTH_LONG).show();
            }


        });
    }
}