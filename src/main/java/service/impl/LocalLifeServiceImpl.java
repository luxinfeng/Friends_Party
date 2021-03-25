package service.impl;

import com.google.gson.JsonObject;
import retrofit2.Call;
import retrofit2.Retrofit;
import service.LocalLifeService;
import service.baseapi.AMap;

import java.util.List;

public class LocalLifeServiceImpl implements LocalLifeService {
    private static String key = "d6330718069a16b9d98bb39b93330a95";
    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://restapi.amap.com/v3/")
            .build();


    public JsonObject localLife(String location1, String location2, List<String> keyWords, int pageSize, int pageNum) {
        String locationParam1 = findLocationParam(location1);
        String locationParam2 = findLocationParam(location2);

        StringBuilder keyParams = new StringBuilder();
        for(String keyWord : keyWords){
            keyParams.append(keyWord);
            keyParams.append("|");
        }

        AMap service = retrofit.create(AMap.class);
        String midLocation = findMidLocation(locationParam1, locationParam2);
        Call<JsonObject> jsonObject = service.getInfoByLocation(key, midLocation, keyWords.toString());

    }

    private String findLocationParam(String location){

    }

    private String findMidLocation(String locationParam1, String locationParam2){
        String[] location1 = locationParam1.split(",");
        String[] location2 = locationParam2.split(",");

        float x = Float.valueOf(location1[0]) + (Float.valueOf(location2[0]) - Float.valueOf(location1[0]))/2;
        float y = Float.valueOf(location2[0]) + (Float.valueOf(location2[1]) - Float.valueOf(location1[1]))/2;

        StringBuilder res = new StringBuilder();
        res.append(x).append(",").append(y);
        return res.toString();
    }
}
