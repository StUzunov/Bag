package com.Bag.controllers;

import com.Bag.request.HeaderRequest;
import com.Bag.request.water.UpdateDailyWaterRequest;
import com.Bag.services.water.WaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/water")
public class WaterController extends Controller{

    @Autowired
    private WaterService waterService;

    public WaterController() {}

    @RequestMapping(value = "/updateDailyWater", method = RequestMethod.POST)
    public void updateDailyWater(@RequestHeader HttpHeaders headers, @RequestBody UpdateDailyWaterRequest updateDailyWaterRequest) throws Exception {
        HeaderRequest headerRequest = new HeaderRequest(decodeBase64(headers.get("authorization"))[0], decodeBase64(headers.get("authorization"))[1]);
        waterService.updateDailyWater(headerRequest, updateDailyWaterRequest);
    }
}
