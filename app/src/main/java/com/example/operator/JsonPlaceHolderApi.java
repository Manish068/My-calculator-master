package com.example.operator;

import com.example.operator.Curr;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JsonPlaceHolderApi {

    @GET("https://rate-exchange-1.appspot.com/currency")
    Call<Curr> getCurrency(
            @Query("from") String from,
            @Query("to") String to,
            @Query("q") Double q);
}
