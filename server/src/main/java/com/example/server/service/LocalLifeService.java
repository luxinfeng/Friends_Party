package com.example.server.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

/**
 * @author luxinfeng
 * @date 2021/3/26 19:36
 */

@Component
public interface LocalLifeService {
    public JsonObject localLife(String location1,
                                String location2,
                                List<String> keyWords,
                                int pageSize,
                                int pageNum) throws IOException;

    public JsonArray locationParam(String location) throws IOException;
}