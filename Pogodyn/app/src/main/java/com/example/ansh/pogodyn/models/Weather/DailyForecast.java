
package com.example.ansh.pogodyn.models.Weather;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DailyForecast {

    @SerializedName("Date")
    public String date;

    @SerializedName("EpochDate")
    public Integer epochDate;

    @SerializedName("Temperature")
    public Temperature temperature;

    @SerializedName("Day")
    public Day day;

    @SerializedName("Night")
    public Night night;

    @SerializedName("Sources")
    public List<String> sources;

    @SerializedName("MobileLink")
    public String mobileLink;

    @SerializedName("Link")
    public String link;

}
