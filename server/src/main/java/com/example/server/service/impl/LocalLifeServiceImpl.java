package com.example.server.service.impl;

import com.example.server.model.GeoCoordinate;
import com.example.server.service.LocalLifeService;
import com.example.server.service.baseapi.AMap;
import com.example.server.service.baseapi.Locations;
import com.example.server.service.util.GetCenterPointFromListOfCoordinates;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Component;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author luxinfeng
 * @date 2021/3/26 19:38
 */

@Component
public class LocalLifeServiceImpl implements LocalLifeService {

    @Resource
    GetCenterPointFromListOfCoordinates getCenterPointFromListOfCoordinates;


    private static String key = "d6330718069a16b9d98bb39b93330a95";
    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://restapi.amap.com/v3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public JsonObject localLife(String location1, String location2, List<String> keyWords, int pageSize, int pageNum) throws IOException {

        StringBuilder keyParams = new StringBuilder();
        for(String keyWord : keyWords){
            keyParams.append(keyWord);
            keyParams.append("|");
        }

        AMap service = retrofit.create(AMap.class);
        List<GeoCoordinate> params = new ArrayList<>();
        GeoCoordinate geoCoordinate1 = new GeoCoordinate(location1);
        GeoCoordinate geoCoordinate2 = new GeoCoordinate(location2);
        params.add(geoCoordinate1);
        params.add(geoCoordinate2);
        GeoCoordinate midGeoCoordinate = GetCenterPointFromListOfCoordinates.getCenterPoint(params);
        StringBuilder midLocation = new StringBuilder();
        midLocation.append(String.format("%.6f",midGeoCoordinate.getLatitude()))
                .append(",")
                .append(String.format("%.6f",midGeoCoordinate.getLongitude()));
        Response<JsonObject> response = service.getInfoByLocation(key, midLocation.toString(), keyWords.toString()).execute();
         return response.body();
    }

    @Override
    public JsonArray locationParam(String location) throws IOException {
        Locations service = retrofit.create(Locations.class);
        Response<JsonObject> response = service.getinputtips(key, location).execute();
        JsonObject jsonObject = response.body();
        if(!jsonObject.get("status").equals("1")){
            return null;
        }
        JsonArray jsonArray = jsonObject.getAsJsonArray("tips");
        return jsonArray;
    }
}