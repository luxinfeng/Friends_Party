package com.example.server.service.baseapi;

import com.google.gson.JsonObject;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author luxinfeng
 * @date 2021/3/26 19:36
 */


public interface Locations {

    @GET("assistant/inputtips")
    Call<JsonObject> getinputtips(@Query("key") String key,
                                  @Query("keywords") String keyWords);

    @GET("geocode/geo")
    Call<JsonObject> getGeoCode(@Query("key") String key,
                                @Query("address") String address);
}