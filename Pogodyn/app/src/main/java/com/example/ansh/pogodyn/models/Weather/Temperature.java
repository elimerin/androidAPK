
package com.example.ansh.pogodyn.models.Weather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Temperature {

    @SerializedName("Minimum")
    public Minimum minimum;

    @SerializedName("Maximum")
    public Maximum maximum;


}
