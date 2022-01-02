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
    @SerializedName("marketCap")
    private String coinMC;


    @SerializedName("priceChange1h")
    private String coinPriceChange;
    @SerializedName("websiteUrl")
    private String coinWebsite;

    public Coin(String coinName, String coinSymbol, String coinPrice, String coinIcon, String coinMC, String coinPriceChange,String coinWebsite) {
        this.coinName = coinName;
        this.coinSymbol = coinSymbol;
        this.coinPrice = coinPrice;
        this.coinIcon = coinIcon;
        this.coinMC = coinMC;
        this.coinPriceChange = coinPriceChange;
        this.coinWebsite = coinWebsite;
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

    public String getCoinMC() {
        return coinMC;
    }

    public void setCoinMC(String coinMC) {
        this.coinMC = coinMC;
    }

    public String getCoinPriceChange() {
        return coinPriceChange;
    }

    public void setCoinPriceChange(String coinPriceChange) {
        this.coinPriceChange = coinPriceChange;
    }

    public String getCoinWebsite() {
        return coinWebsite;
    }

    public void setCoinWebsite(String coinWebsite) {
        this.coinWebsite = coinWebsite;
    }
}
