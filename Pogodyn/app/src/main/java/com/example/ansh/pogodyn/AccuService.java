package com.example.ansh.pogodyn;

import com.example.ansh.pogodyn.models.AutoCompleteSearchModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface AccuService {
    @GET("locations/v1/cities/autocomplete")
    Call<List<AutoCompleteSearchModel>> loadCities(@Query("apikey") String apikey, @Query("q") String location);
}
