package com.Bag.models.challenge;

import java.util.Map;
import java.util.TreeMap;

public class ChallengeMenu {

    private Map<String, Challenge> challenge;

    public ChallengeMenu() {
        this.challenge = new TreeMap<>();
    }

    public void addChallenge(String date, Challenge challengeToday){
        challenge.put(date, challengeToday);
    }

    public Map<String, Challenge> getChallenge() {
        return challenge;
    }

    public void setChallenge(Map<String, Challenge> challenge) {
        this.challenge = challenge;
    }
}
