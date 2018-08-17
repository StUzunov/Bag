package com.Bag.engine.challenge;

import com.Bag.models.challenge.Challenge;
import com.Bag.models.workout.ExerciseEnum;

public class ChallengeGenerator implements Generator{

    public Challenge generateChallenge(){
        return new Challenge(ExerciseEnum.PULL_UP, 10);
    }

    @Override
    public Object generate(Object object) {
        return null;
    }
}
