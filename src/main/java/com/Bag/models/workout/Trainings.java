package com.Bag.models.workout;

import java.util.Map;

public class Trainings {

    private Map<String, Workout> workouts;

    public Trainings(Map<String, Workout> workouts) {
        this.workouts = workouts;
    }

    public Map<String, Workout> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(Map<String, Workout> workouts) {
        this.workouts = workouts;
    }
}
