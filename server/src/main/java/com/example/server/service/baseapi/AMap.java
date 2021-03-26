package com.example.server.service.baseapi;

import com.google.gson.JsonObject;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author luxinfeng
 * @date 2021/3/26 19:34
 */


public interface AMap {
    @GET("place/text")
    Call<JsonObject> getInfoByText(@Query("key") String key, @Query("keywords") String keyWords, @Query("types") String types);

    @GET("place/around")
    Call<JsonObject> getInfoByLocation(@Query("key") String key, @Query("location") String location, @Query("keywords") String keyWords);
}
