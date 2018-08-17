package com.Bag.request.training;

import com.Bag.models.workout.ExerciseEnum;
import com.Bag.request.Validated;
import com.Bag.request.ValidationResponse;

public class ExerciseRequest implements Validated {

    private ExerciseEnum exerciseEnum;
    private int trainingTimeRep;

    @Override
    public ValidationResponse validate() {
        return ValidationResponse.OK;
    }

    public ExerciseEnum getExerciseEnum() {
        return exerciseEnum;
    }

    public void setExerciseEnum(ExerciseEnum exerciseEnum) {
        this.exerciseEnum = exerciseEnum;
    }

    public int getTrainingTimeRep() {
        return trainingTimeRep;
    }

    public void setTrainingTimeRep(int trainingTimeRep) {
        this.trainingTimeRep = trainingTimeRep;
    }
}
