package com.example.ansh.pogodyn;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface AccuService {
    @GET("locations/v1/cities/autocomplete")
    Call<String> loadCities(@Query("apikey") String apikey, @Query("q") String location);
}
