package com.example.ansh.pogodyn;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ansh on 03.09.2017.
 */

public interface AccuService {
    @GET("locations/v1/cities/search?apikey=jPRAPCFDpaLuWPCyCVdNH0ayBXziM7QS&q={location}")
    Call<locationKey>//za chuj nie wiem co tutaj ma byc
}
