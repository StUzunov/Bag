package com.Bag.services.water;

import com.Bag.engine.challenge.DailyWaterGenerator;
import com.Bag.models.BagUser;
import com.Bag.models.BagUserRepository;
import com.Bag.models.water.DayWater;
import com.Bag.request.HeaderRequest;
import com.Bag.request.RequestValidator;
import com.Bag.request.water.UpdateDailyWaterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class WaterServiceImpl implements WaterService{

    @Autowired
    private BagUserRepository bagUserRepository;

    @Autowired
    private RequestValidator requestValidator;

    //this method is used only from the daily service never from controllers
    @Override
    public void todayWaterGoal(String bagUserId) {
        //get the bag user
        BagUser bagUser = bagUserRepository.findOne(bagUserId);
        //create new day water with quantity for drinked water 0
        DayWater dayWater = new DayWater(0);
        //generate new daily water from the generator
        dayWater.setQuantityGoal((Integer) new DailyWaterGenerator().generate(new Integer(100)));
        //add new day water to map
        bagUser.getWater().getDayWaterMap().put(getDateAsString(), dayWater);
        //save the user
        bagUserRepository.save(bagUser);
    }

    @Override
    public void updateDailyWater(HeaderRequest headerRequest, UpdateDailyWaterRequest updateDailyWaterRequest) throws Exception {
        requestValidator.validate(headerRequest);
        requestValidator.validate(updateDailyWaterRequest);

        //get the bag user
        BagUser bagUser = bagUserRepository.findByUsername(headerRequest.getUsername());
        bagUser.getWater().getDayWaterMap().get(getDateAsString()).setQuantity(updateDailyWaterRequest.getQuantity());

        bagUserRepository.save(bagUser);
    }

    String getDateAsString(){
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
