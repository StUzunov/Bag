package com.Bag.services.training;

import com.Bag.engine.challenge.DailyWorkoutGenerator;
import com.Bag.models.BagUser;
import com.Bag.models.BagUserRepository;
import com.Bag.models.workout.Exercise;
import com.Bag.request.OneDayRequest;
import com.Bag.request.RequestValidator;
import com.Bag.request.HeaderRequest;
import com.Bag.request.training.ExerciseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class TrainingServiceImpl implements TrainingService {

    @Autowired
    private BagUserRepository bagUserRepository;

    @Autowired
    private RequestValidator requestValidator;

    @Override
    public Object getAllTrainings(HeaderRequest request) throws Exception {
        requestValidator.validate(request);
        //get history of all trainings for one user
        return bagUserRepository.findByUsername(request.getUsername()).getTrainings();
    }

    @Override
    public Object getTodayTrainings(HeaderRequest request) throws Exception {
        requestValidator.validate(request);
        //get all workouts for user by id for one day
        return bagUserRepository.findByUsername(request.getUsername()).getTrainings().getWorkouts().getOrDefault(getDateAsString(), null);
    }

    @Override
    public Object getOneDayTrainings(HeaderRequest header, OneDayRequest oneDayRequest) {
        return null;
    }


    @Override
    public void updateExercise(HeaderRequest header, ExerciseRequest exerciseRequest) throws Exception {
        //validate request
        this.requestValidator.validate(exerciseRequest);

        //Create exercise from request
        Exercise exerciseFromRequest = new Exercise(exerciseRequest.getExerciseEnum(), exerciseRequest.getTrainingTimeRep());

        String today = getDateAsString();
        //get the bag user to update the workouts
        BagUser bagUser = bagUserRepository.findByUsername(header.getUsername());
        //get all exercises for today, for easy manipulation
        List<Exercise> exercises = bagUser.getTrainings().getWorkouts().getOrDefault(today, null).getExercises();
        boolean updated = false;
        for (Exercise ex : exercises) {
            if(ex.getExerciseEnum().equals(exerciseFromRequest.getExerciseEnum())){
                if(exerciseFromRequest.getTrainingTimeRep() <= 0){
                    //remove exercise if request time/rep is <= 0
                    exercises.remove(ex);
                    updated = true;
                }else{
                    //update exercise from request
                    exercises.set(exercises.indexOf(ex), exerciseFromRequest);
                    updated = true;
                }
                break;
            }
        }

        //if no updated exercise we add new exercise
        if(!updated){
            bagUser.getTrainings().getWorkouts().getOrDefault(today, null).addExercise(exerciseFromRequest);
        }

        //save the user
        bagUserRepository.save(bagUser);
    }

    @Override
    public Object getOneDayDailyGeneratedTrainings(HeaderRequest simpleRequest, OneDayRequest oneDayRequest) {
        //get daily generated trainings  if the date is empty string
        oneDayRequest.setDate((oneDayRequest.getDate().equals("")) ? getDateAsString() : oneDayRequest.getDate());
        return bagUserRepository.findByUsername(simpleRequest.getUsername()).getDailyGeneratedTrainings().getWorkouts().get(oneDayRequest.getDate());
    }

    @Override
    public void newGeneratedTrainings(String bagUserId) {
        BagUser bagUser = bagUserRepository.findOne(bagUserId);
        bagUser.getDailyGeneratedTrainings().getWorkouts().put(getDateAsString(), new DailyWorkoutGenerator().generateWorkout());

        //save the user
        bagUserRepository.save(bagUser);
    }


    String getDateAsString(){
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
