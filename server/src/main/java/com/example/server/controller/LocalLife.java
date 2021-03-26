package com.example.server.controller;

import com.example.server.service.LocalLifeService;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * @author luxinfeng
 * @date 2021/3/26 19:16
 */


@RestController
public class LocalLife {

    @Resource
    LocalLifeService localLifeService;

    @ResponseBody
    @GetMapping("/api/getLocalLife")
    public JsonObject localLife(@RequestParam("location1") String location1,
                                @RequestParam("location2") String location2,
                                @RequestParam("keyWords") List<String> keyWords,
                                @RequestParam("pageSize") int pageSize,
                                @RequestParam("pageNum") int pageNum) {
        JsonObject jsonObject = new JsonObject();
        try {
            jsonObject = localLifeService.localLife(location1, location2, keyWords, pageSize, pageNum);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    @ResponseBody
    @GetMapping("api/getLocationParam")
    public JsonArray locationParam(@RequestParam("location") String location){
        JsonArray jsonObject = new JsonArray();
        try {
            jsonObject = localLifeService.locationParam(location);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}
