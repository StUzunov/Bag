package com.Bag.services.training;

import com.Bag.request.OneDayRequest;
import com.Bag.request.HeaderRequest;
import com.Bag.request.training.ExerciseRequest;

public interface TrainingService {

    Object getAllTrainings(HeaderRequest request) throws Exception;

    Object getTodayTrainings(HeaderRequest request) throws Exception;

    Object getOneDayTrainings(HeaderRequest request, OneDayRequest oneDayRequest);

    void updateExercise(HeaderRequest request, ExerciseRequest exerciseRequest) throws Exception;

    Object getOneDayDailyGeneratedTrainings(HeaderRequest simpleRequest, OneDayRequest oneDayRequest);

    void newGeneratedTrainings(String bagUserId);

}
