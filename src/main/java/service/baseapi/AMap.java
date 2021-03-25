package service.baseapi;

import com.google.gson.JsonObject;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface AMap {
    @GET("place/text")
    Call<JsonObject> getInfoByText(@Path("key") String key, @Path("keywords")String keyWords, @Path("types")String types);

    @GET("place/around")
    Call<JsonObject> getInfoByLocation(@Path("key") String key, @Path("location")String location, @Path("keywords")String keyWords);
}
