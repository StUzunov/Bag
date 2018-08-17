package com.Bag.models.workout;

import java.util.ArrayList;
import java.util.List;

public class Workout {

    List<Exercise> exercises;

    public Workout() {
        this.exercises = new ArrayList<>();
    }

    public Workout(List<Exercise> exercises){
        this.exercises = exercises;
    }

    public void addExercise(Exercise exercise){
        this.exercises.add(exercise);
    }

    public void removeExcersise(Exercise exercise){
        this.exercises.remove(exercise);
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }
}
