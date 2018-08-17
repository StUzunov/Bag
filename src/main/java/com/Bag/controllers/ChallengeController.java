package com.Bag.controllers;

import com.Bag.request.HeaderRequest;
import com.Bag.request.OneDayRequest;
import com.Bag.request.challenge.UpdateDailyChallengeRequest;
import com.Bag.services.challenge.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/challenge")
public class ChallengeController extends Controller{


    @Autowired
    private ChallengeService challengeService;

    @RequestMapping(value = "/updateDailyChallenge", method = RequestMethod.POST)
    public void updateDailyChallenge(@RequestHeader HttpHeaders headers, @RequestBody UpdateDailyChallengeRequest updateDailyChallengeRequest) throws Exception {
        HeaderRequest headerRequest = new HeaderRequest(decodeBase64(headers.get("authorization"))[0], decodeBase64(headers.get("authorization"))[1]);
        challengeService.updateDailyChallenge(headerRequest, updateDailyChallengeRequest);
    }

    @RequestMapping(value = "/getOneDayChallenge", method = RequestMethod.POST)
    public Object getOneDayChallenge(@RequestHeader HttpHeaders headers, @RequestBody OneDayRequest oneDayChallengeRequest) throws Exception {
        HeaderRequest headerRequest = new HeaderRequest(decodeBase64(headers.get("authorization"))[0], decodeBase64(headers.get("authorization"))[1]);
        return challengeService.getOneDayChallenge(headerRequest, oneDayChallengeRequest);
    }

}
