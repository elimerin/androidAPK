
package com.example.ansh.pogodyn.models.Weather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Headline {

    @SerializedName("EffectiveDate")
    public String effectiveDate;

    @SerializedName("EffectiveEpochDate")
    public Integer effectiveEpochDate;

    @SerializedName("Severity")
    public Integer severity;

    @SerializedName("Text")
    public String text;

    @SerializedName("Category")
    public String category;

    @SerializedName("EndDate")
    public String endDate;

    @SerializedName("EndEpochDate")
    public Integer endEpochDate;

    @SerializedName("MobileLink")
    public String mobileLink;

    @SerializedName("Link")
    public String link;

}
