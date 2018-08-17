package com.Bag.controllers;

import com.Bag.request.HeaderRequest;
import com.Bag.request.food.ServingRequest;
import com.Bag.services.food.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/food")
public class FoodController extends Controller {

    @Autowired
    private FoodService foodService;

    public FoodController() {}

    @RequestMapping(value = "/getAllFood", method = RequestMethod.POST)
    public Object getAllFood(@RequestHeader HttpHeaders headers) throws Exception {
        HeaderRequest headerRequest = new HeaderRequest(decodeBase64(headers.get("authorization"))[0], decodeBase64(headers.get("authorization"))[1]);
        return foodService.getAllFood(headerRequest);
    }

    @RequestMapping(value = "/getTodayFood", method = RequestMethod.POST)
    public Object getTodayFood(@RequestHeader HttpHeaders headers) throws Exception {
        HeaderRequest headerRequest = new HeaderRequest(decodeBase64(headers.get("authorization"))[0], decodeBase64(headers.get("authorization"))[1]);
        return foodService.getTodayFood(headerRequest);

    }

    @RequestMapping(value = "/updateServing", method = RequestMethod.POST)
    public void updateServing(@RequestHeader HttpHeaders headers, @RequestBody ServingRequest updateServingRequest) throws Exception {
        HeaderRequest headerRequest = new HeaderRequest(decodeBase64(headers.get("authorization"))[0], decodeBase64(headers.get("authorization"))[1]);
        foodService.updateServing(headerRequest, updateServingRequest);
    }

}
