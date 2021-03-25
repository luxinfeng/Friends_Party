package controller;


import com.google.gson.JsonObject;
import org.springframework.stereotype.Controller;
import retrofit2.http.Part;
import service.LocalLifeService;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class LocalLife {

    @Resource
    LocalLifeService localLifeService;


    public JsonObject localLife(String location1,
                          String location2,
                          List<String> keyWords,
                          int pageSize,
                          int pageNum){
        JsonObject jsonObject = new JsonObject();
        jsonObject = localLifeService.localLife(location1, location2, keyWords, pageSize, pageNum);

    }
}
