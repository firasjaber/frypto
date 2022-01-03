package com.example.frypto;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Results {

    @SerializedName("coins")
    private ArrayList<Coin> coins;

    public Results(ArrayList<Coin> coins) {
        this.coins = coins;
    }

    public ArrayList<Coin> getCoins() {
        return coins;
    }

}
