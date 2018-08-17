package com.Bag.services.challenge;


import com.Bag.request.OneDayRequest;
import com.Bag.request.HeaderRequest;
import com.Bag.request.challenge.UpdateDailyChallengeRequest;

public interface ChallengeService {

    Object getAll();

    void newChallenge(HeaderRequest headerRequest) throws Exception;

    void updateDailyChallenge(HeaderRequest headerRequest, UpdateDailyChallengeRequest updateDailyChallengeRequest) throws Exception;

    Object getOneDayChallenge(HeaderRequest headerRequest, OneDayRequest oneDayRequest) throws Exception;
}
