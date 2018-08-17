package com.Bag.services.food;

import com.Bag.request.OneDayRequest;
import com.Bag.request.HeaderRequest;
import com.Bag.request.food.ServingRequest;

public interface FoodService {

    Object getAllFood(HeaderRequest headerRequest) throws Exception;

    Object getTodayFood(HeaderRequest headerRequest) throws Exception;

    Object getOneDayFood(HeaderRequest headerRequest, OneDayRequest oneDayRequest);

    void updateServing(HeaderRequest headerRequest, ServingRequest exerciseRequest) throws Exception;
}
