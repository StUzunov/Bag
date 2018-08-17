package com.Bag.models.workout;

public class Exercise {

    private ExerciseEnum exerciseEnum;
    private int trainingTimeRep;
    private String trainingType;

    public Exercise(ExerciseEnum exerciseEnum, int trainingTimeRep) {
        this.exerciseEnum = exerciseEnum;
        this.trainingTimeRep = trainingTimeRep;
        this.trainingType = exerciseEnum.getType();
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

    public String getTrainingType() {
        return trainingType;
    }

    public void setTrainingType(String trainingType) {
        this.trainingType = trainingType;
    }
}
