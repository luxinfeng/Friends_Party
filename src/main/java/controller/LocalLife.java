package controller;


import com.google.gson.JsonObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import retrofit2.http.Part;
import service.LocalLifeService;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class LocalLife {

    @Resource
    LocalLifeService localLifeService;

    @GetMapping("/api/getLocalLife")
    public JsonObject localLife(String location1,
                          String location2,
                          List<String> keyWords,
                          int pageSize,
                          int pageNum){
        JsonObject jsonObject = new JsonObject();
        jsonObject = localLifeService.localLife(location1, location2, keyWords, pageSize, pageNum);
        return jsonObject;
    }
}
