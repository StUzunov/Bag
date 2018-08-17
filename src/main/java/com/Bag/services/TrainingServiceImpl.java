package com.Bag.services;

import com.Bag.models.BagUser;
import com.Bag.models.BagUserRepository;
import com.Bag.models.workout.Exercise;
import com.Bag.request.RequestValidator;
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
    public Object getAllTrainings(String id) {
        //get history of all trainings for one user
        return bagUserRepository.findOne(id).getTrainings();
    }

    @Override
    public Object getTodayTrainings(String id) {
        //get all workouts for user by id for one day
        return bagUserRepository.findOne(id).getTrainings().getWorkouts().getOrDefault(getDateAsString(), null);
    }

    @Override
    public void updateExercise(ExerciseRequest exerciseRequest) throws Exception {
        //validate request
        this.requestValidator.validate(exerciseRequest);

        //Create exercise from request
        Exercise exerciseFromRequest = new Exercise(exerciseRequest.getExerciseEnum(), exerciseRequest.getTrainingTimeRep());

        String today = getDateAsString();
        //get the bag user to update the workouts
        BagUser bagUser = bagUserRepository.findOne(exerciseRequest.getBagUserId());
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


    String getDateAsString(){
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
