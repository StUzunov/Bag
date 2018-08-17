package com.Bag.models.challenge;

import com.Bag.models.workout.ExerciseEnum;

public class Challenge {

    private ExerciseEnum exerciseChallenge;
    private int challengeRep;
    private int repDone;
    private boolean isFinished;
    private String exerciseType;

    public Challenge(ExerciseEnum exerciseChallenge, int challengeRep) {
        this.exerciseChallenge = exerciseChallenge;
        this.challengeRep = challengeRep;
        this.isFinished = false;
        this.exerciseType = exerciseChallenge.getType();
    }

    public String getExerciseType() {
        return exerciseType;
    }

    public ExerciseEnum getExerciseChallenge() {
        return exerciseChallenge;
    }

    public void setExerciseChallenge(ExerciseEnum exerciseChallenge) {
        this.exerciseChallenge = exerciseChallenge;
    }

    public int getChallengeRep() {
        return challengeRep;
    }

    public void setChallengeRep(int challengeRep) {
        this.challengeRep = challengeRep;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public int getRepDone() {
        return repDone;
    }

    public void setRepDone(int repDone) {
        this.repDone = repDone;
    }
}
