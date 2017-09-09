
package com.example.ansh.pogodyn.models.Weather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Minimum {

    @SerializedName("Value")
    public Integer value;

    @SerializedName("Unit")
    public String unit;

    @SerializedName("UnitType")
    public Integer unitType;

}
