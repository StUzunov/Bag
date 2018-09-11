package com.Bag.controllers;

import com.Bag.request.HeaderRequest;
import com.Bag.request.OneDayRequest;
import com.Bag.services.food.FoodService;
import com.Bag.services.water.WaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/main")
public class MainController extends Controller {

    @Autowired
    private FoodService foodService;

    @Autowired
    private WaterService waterService;


    @RequestMapping(value = "/getHome", method = RequestMethod.POST)
    public Object getHome(@RequestHeader HttpHeaders headers, @RequestBody OneDayRequest oneDayRequest) throws Exception {
        HeaderRequest headerRequest = new HeaderRequest(decodeBase64(headers.get("authorization"))[0], decodeBase64(headers.get("authorization"))[1]);
        Object calories = foodService.getOneDayEatenCalories(headerRequest, oneDayRequest);
        Object water = waterService.getOneDayWater(headerRequest, oneDayRequest);


        Map<String,Object> all = new HashMap<>();
        all.put("calories", calories);
        all.put("water", water);
//        List<Object> all = Arrays.asList(calories,water);
        System.out.println(all);
        return all;
    }

}
