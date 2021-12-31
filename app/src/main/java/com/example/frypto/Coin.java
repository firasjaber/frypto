package com.example.frypto;

import com.google.gson.annotations.SerializedName;

public class Coin {
    @SerializedName("name")
    private String coinName;


    public Coin(String name) {
        this.coinName = name;
    }

    public String getName() {
        return coinName;
    }
}
