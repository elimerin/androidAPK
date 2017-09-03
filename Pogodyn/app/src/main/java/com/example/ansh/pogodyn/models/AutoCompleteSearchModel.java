package com.example.ansh.pogodyn.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ariankozbial on 03.09.2017.
 */

public class AutoCompleteSearchModel {
    @SerializedName("Version")
    public Integer version;

    @SerializedName("Key")
    public String key;

    @SerializedName("Type")
    public String type;

    @SerializedName("Rank")
    public Integer rank;

    @SerializedName("LocalizedName")
    public String localizedName;

    @SerializedName("Country")
    public Country country;

    @SerializedName("AdministrativeArea")
    public AdministrativeArea administrativeArea;
}

