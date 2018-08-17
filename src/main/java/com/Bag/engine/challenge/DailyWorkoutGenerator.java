package com.Bag.engine.challenge;

import com.Bag.models.workout.Exercise;
import com.Bag.models.workout.ExerciseEnum;
import com.Bag.models.workout.Workout;

import java.util.Arrays;

public class DailyWorkoutGenerator implements Generator{

    public Workout generateWorkout(){
        return new Workout(Arrays.asList(new Exercise(ExerciseEnum.PULL_UP, 10), new Exercise(ExerciseEnum.SWIMING, 60)));
    }

    @Override
    public Object generate(Object object) {
        return null;
    }
}
