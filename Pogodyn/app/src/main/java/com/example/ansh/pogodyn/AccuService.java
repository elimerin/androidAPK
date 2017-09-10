package com.example.ansh.pogodyn;

import com.example.ansh.pogodyn.models.AutoCompleteSearch.AutoCompleteSearchModel;
import com.example.ansh.pogodyn.models.Weather.WeatherModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface AccuService {
    @GET("locations/v1/cities/autocomplete")
    Call<List<AutoCompleteSearchModel>> loadCities(@Query("apikey") String apikey, @Query("q") String location);

    @GET("forecasts/v1/daily/1day/{locationKey}")
    Call<WeatherModel> getWeather(@Path("locationKey") String locationKey, @Query("apikey") String apikey, @Query("language") String language, @Query("details") String details, @Query("metric") String metric);
}
