package com.Bag.services.water;

import com.Bag.request.HeaderRequest;
import com.Bag.request.water.UpdateDailyWaterRequest;

public interface WaterService {

    void todayWaterGoal(String bagUserId);

    void updateDailyWater(HeaderRequest headerRequest, UpdateDailyWaterRequest updateDailyWaterRequest) throws Exception;
}
