
package com.example.ansh.pogodyn.models.Weather;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class WeatherModel {

    @SerializedName("Headline")
    public Headline headline;
    
    @SerializedName("DailyForecasts")
    public List<DailyForecast> dailyForecasts;

}
