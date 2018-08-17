package com.Bag.controllers;

import com.Bag.request.OneDayRequest;
import com.Bag.request.HeaderRequest;
import com.Bag.request.training.ExerciseRequest;
import com.Bag.services.training.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import static java.lang.Class.forName;

@RestController
@RequestMapping("/trainings")
public class TrainingsController extends Controller {

    @Autowired
    private TrainingService trainingService;

    public TrainingsController() {}

    @RequestMapping(value = {"/getAllTrainings"}, method = RequestMethod.POST)
    public Object getAllTrainings(@RequestHeader HttpHeaders headers) throws Exception {
        HeaderRequest request = new HeaderRequest(decodeBase64(headers.get("authorization"))[0], decodeBase64(headers.get("authorization"))[1]);
        //get all trainings by username
        return trainingService.getAllTrainings(request);
    }

    @RequestMapping(value = "/getTodayTrainings", method = RequestMethod.POST)
    public Object getTodayTrainings(@RequestHeader HttpHeaders headers) throws Exception {
        HeaderRequest headerRequest = new HeaderRequest(decodeBase64(headers.get("authorization"))[0], decodeBase64(headers.get("authorization"))[1]);
        return trainingService.getTodayTrainings(headerRequest);

    }

    @RequestMapping(value = "/updateExercise", method = RequestMethod.POST)
    public void updateExercise(@RequestHeader HttpHeaders headers, @RequestBody ExerciseRequest updateExerciseRequest) throws Exception {
        HeaderRequest headerRequest = new HeaderRequest(decodeBase64(headers.get("authorization"))[0], decodeBase64(headers.get("authorization"))[1]);
        trainingService.updateExercise(headerRequest, updateExerciseRequest);
    }

    @RequestMapping(value = "/getOneDayDailyGeneratedTrainings", method = RequestMethod.POST)
    public void getOneDayDailyGeneratedTrainings(@RequestHeader HttpHeaders headers, @RequestBody OneDayRequest oneDayRequest) throws Exception {
        HeaderRequest simpleRequest = new HeaderRequest(decodeBase64(headers.get("authorization"))[0], decodeBase64(headers.get("authorization"))[1]);
        trainingService.getOneDayDailyGeneratedTrainings(simpleRequest, oneDayRequest);
    }
    
}
