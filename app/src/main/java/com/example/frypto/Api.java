package com.example.frypto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    String BASE_URL = "https://api.coinstats.app/public/v1/";
    @GET("coins?skip=0&limit=20")
    Call<Results> getsuperHeroes();

}
