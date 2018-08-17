package com.Bag.services;

import com.Bag.request.training.ExerciseRequest;

public interface TrainingService {

    Object getAllTrainings(String id);

    Object getTodayTrainings(String id);

    void updateExercise(ExerciseRequest exerciseRequest) throws Exception;
}
