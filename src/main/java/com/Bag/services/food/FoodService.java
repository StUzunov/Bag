package com.Bag.services.food;

import com.Bag.request.OneDayRequest;
import com.Bag.request.HeaderRequest;
import com.Bag.request.food.ServingRequest;

import java.math.BigDecimal;

public interface FoodService {

    Object getAllFood(HeaderRequest headerRequest) throws Exception;

    Object getTodayFood(HeaderRequest headerRequest) throws Exception;

    Object getOneDayFood(HeaderRequest headerRequest, OneDayRequest oneDayRequest);

    void updateServing(HeaderRequest headerRequest, ServingRequest exerciseRequest) throws Exception;

    Object getOneDayEatenCalories(HeaderRequest headerRequest, OneDayRequest oneDayRequest) throws Exception;

    void setCaloriesGoal(HeaderRequest headerRequest) throws Exception;
}
