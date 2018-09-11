package com.Bag.services.water;

import com.Bag.request.HeaderRequest;
import com.Bag.request.OneDayRequest;
import com.Bag.request.water.UpdateDailyWaterRequest;

import java.math.BigDecimal;

public interface WaterService {

    void todayWaterGoal(String bagUserId);

    void updateDailyWater(HeaderRequest headerRequest, UpdateDailyWaterRequest updateDailyWaterRequest) throws Exception;

    Object getOneDayWater(HeaderRequest headerRequest, OneDayRequest oneDayRequest) throws Exception;
}
