package service.impl;

import com.google.gson.JsonObject;
import service.LocalLifeService;

import java.util.List;

public class LocalLifeServiceImpl implements LocalLifeService {
    public JsonObject localLife(String location1, String location2, List<String> keyWords, int pageSize, int pageNum) {
        String locationParam1 = findLocationParam(location1);
        String locationParam2 = findLocationParam(location2);

        StringBuilder keyParams = new StringBuilder();
        for(String keyWord : keyWords){
            keyParams.append(keyWord);
            keyParams.append("|");
        }

    }

    private String findLocationParam(String location){

    }
}
