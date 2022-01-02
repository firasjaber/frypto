package com.example.frypto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.frypto.databinding.ActivityMainBinding;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ListView superListView;
    Button refreshButton;
    ActivityMainBinding binding;
    ArrayList<Coin> coinsList;
    TextView coinsInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSuperHeroes();
        superListView = findViewById(R.id.coinsList);
        refreshButton = findViewById(R.id.refresh);
        coinsInfo = findViewById(R.id.coinsInfo);

        refreshButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                getSuperHeroes();
            }
        });

        registerForContextMenu(superListView);

        superListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position,
                                    long arg3)
            {
                Intent i = new Intent(MainActivity.this,CoinActivity.class);
                String coinName = coinsList.get(position).getCoinName();
                i.putExtra("name",coinName);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.coin_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.resetCoins:
                //hiddenCoins.clear();
                getSuperHeroes();
                return true;
            case R.id.quit:
                this.finishAffinity();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        Coin c = coinsList.get(info.position);
        switch (item.getItemId()) {
            case R.id.visitWebsite:
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(c.getCoinWebsite()));
                startActivity(browserIntent);
                return true;
            case R.id.trade:
                String tradeUrl = "https://www.coinbase.com/price/" + c.getCoinName().toLowerCase();
                Intent browserIntent2 = new Intent(Intent.ACTION_VIEW, Uri.parse(tradeUrl));
                startActivity(browserIntent2);
                return true;
            case R.id.delete:
                coinsList.remove(info.position);
                superListView.invalidateViews();
                coinsInfo.setText("Your coins ( "+ coinsList.size()+" total )");
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    private void getSuperHeroes() {
        Call<Results> call = RetrofitClient.getInstance().getMyApi().getsuperHeroes();
        call.enqueue(new Callback<Results>() {
            @Override
            public void onResponse(Call<Results> call, Response<Results> response) {
                Results result = response.body();
                coinsList = result.getCoins();
                ListAdapter listAdapter = new ListAdapter(MainActivity.this,coinsList);
                superListView.setAdapter(listAdapter);
                coinsInfo.setText("Your coins ( "+ coinsList.size()+" total )");
            }

            @Override
            public void onFailure(Call<Results> call, Throwable t) {
                System.out.println(t.toString());
                Toast.makeText(getApplicationContext(), "An error has occured", Toast.LENGTH_LONG).show();
            }

        });
    }
}