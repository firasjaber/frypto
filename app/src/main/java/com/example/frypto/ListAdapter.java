package com.example.frypto;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<Coin> {

    public ListAdapter (Context context, ArrayList<Coin> coinsArrayList) {
        super(context,R.layout.list_item,R.id.coin,coinsArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Coin  coin = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        ImageView imageView = convertView.findViewById(R.id.coinIcon);
        TextView coinName = convertView.findViewById(R.id.coinId);
        TextView coinSymbol = convertView.findViewById(R.id.coinSymbol);
        TextView coinPrice = convertView.findViewById(R.id.coinPrice);

        TextView c = convertView.findViewById(R.id.coin);
        c.setVisibility(convertView.INVISIBLE);

        int price = (int) Float.parseFloat(coin.getCoinPrice());

        Picasso.get().load(coin.getCoinIcon()).into(imageView);
        coinName.setText(coin.getCoinName());
        coinSymbol.setText(coin.getCoinSymbol());
        coinPrice.setText(Integer.toString(price)+ "$");

        return super.getView(position, convertView, parent);
    }
}
