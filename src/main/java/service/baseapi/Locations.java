package service.baseapi;

import com.google.gson.JsonObject;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Locations {

    @GET("assistant/inputtips")
    Call<JsonObject> getinputtips(@Path("key") String key,
                                  @Path("keywords") String keyWords);

    @GET("geocode/geo")
    Call<JsonObject> getGeoCode(@Path("key") String key,
                                @Path("address") String address);
}
