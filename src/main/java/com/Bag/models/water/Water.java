package com.Bag.models.water;

import java.util.Map;

public class Water {

    private Map<String, DayWater> dayWaterMap;

    public Water(Map<String, DayWater> dayWaterMap) {
        this.dayWaterMap = dayWaterMap;
    }

    public Map<String, DayWater> getDayWaterMap() {
        return dayWaterMap;
    }

    public void setDayWaterMap(Map<String, DayWater> dayWaterMap) {
        this.dayWaterMap = dayWaterMap;
    }
}
