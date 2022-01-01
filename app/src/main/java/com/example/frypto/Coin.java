package com.example.frypto;

import com.google.gson.annotations.SerializedName;

public class Coin {
    @SerializedName("name")
    private String coinName;
    @SerializedName("symbol")
    private String coinSymbol;
    @SerializedName("price")
    private String coinPrice;
    @SerializedName("icon")
    private String coinIcon;

    public Coin(String coinName, String coinSymbol, String coinPrice, String coinIcon) {
        this.coinName = coinName;
        this.coinSymbol = coinSymbol;
        this.coinPrice = coinPrice;
        this.coinIcon = coinIcon;
    }

    public String getCoinName() {
        return coinName;
    }

    public void setCoinName(String coinName) {
        this.coinName = coinName;
    }

    public String getCoinSymbol() {
        return coinSymbol;
    }

    public void setCoinSymbol(String coinSymbol) {
        this.coinSymbol = coinSymbol;
    }

    public String getCoinPrice() {
        return coinPrice;
    }

    public void setCoinPrice(String coinPrice) {
        this.coinPrice = coinPrice;
    }

    public String getCoinIcon() {
        return coinIcon;
    }

    public void setCoinIcon(String coinIcon) {
        this.coinIcon = coinIcon;
    }
}
