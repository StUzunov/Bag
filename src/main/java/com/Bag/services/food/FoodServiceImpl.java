package com.Bag.services.food;

import com.Bag.models.BagUser;
import com.Bag.models.BagUserRepository;
import com.Bag.models.food.Serving;
import com.Bag.request.OneDayRequest;
import com.Bag.request.RequestValidator;
import com.Bag.request.HeaderRequest;
import com.Bag.request.food.ServingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class FoodServiceImpl implements FoodService {

    @Autowired
    private BagUserRepository bagUserRepository;

    @Autowired
    private RequestValidator requestValidator;

    @Override
    public Object getAllFood(HeaderRequest request) throws Exception {
        requestValidator.validate(request);
        //get history of all food for one user
        return bagUserRepository.findByUsername(request.getUsername()).getFood();
    }

    @Override
    public Object getTodayFood(HeaderRequest request) throws Exception {
        requestValidator.validate(request);
        //get all Meal for user by id for one day
        return bagUserRepository.findByUsername(request.getUsername()).getFood().getMeal().getOrDefault(getDateAsString(), null);
    }

    @Override
    public Object getOneDayFood(HeaderRequest headerRequest, OneDayRequest request) {
        //TODO
        return null;
    }

    @Override
    public void updateServing(HeaderRequest headerRequest, ServingRequest servingRequest) throws Exception {
        //validate request
        this.requestValidator.validate(servingRequest);

        //Create serving from request
        Serving servingFromRequest = new Serving(servingRequest.getServingEnum(), servingRequest.getQuantity());

        String today = getDateAsString();
        //get the bag user to update the meal
        BagUser bagUser = bagUserRepository.findByUsername(headerRequest.getUsername());
        //get all servings for today, for easy manipulation
        List<Serving> servings = bagUser.getFood().getMeal().getOrDefault(today, null).getServings();
        boolean updated = false;
        for (Serving se : servings) {
            if(se.getServingEnum().equals(servingFromRequest.getServingEnum())){
                if(servingFromRequest.getQuantity() <= 0){
                    //remove serving if request quantity is <= 0
                    servings.remove(se);
                    updated = true;
                }else{
                    //update serving from request
                    servings.set(servings.indexOf(se), servingFromRequest);
                    updated = true;
                }
                break;
            }
        }

        //if no updated serving we add new serving
        if(!updated){
            bagUser.getFood().getMeal().getOrDefault(today, null).addServing(servingFromRequest);
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
