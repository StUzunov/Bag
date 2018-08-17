package com.Bag.models.workout;

public enum ExerciseEnum {

    SWIMING("time"),
    PULL_UP("count");

    private final String type;
    ExerciseEnum(String type) { this.type = type; }

    public String getType() { return type; }
}
