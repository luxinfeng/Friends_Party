package service;

import com.google.gson.JsonObject;

import java.util.List;

public interface LocalLifeService {
    public JsonObject localLife(String location1,
                                String location2,
                                List<String> keyWords,
                                int pageSize,
                                int pageNum);
}
