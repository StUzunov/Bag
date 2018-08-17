package com.Bag.services.challenge;

import com.Bag.engine.challenge.ChallengeGenerator;
import com.Bag.models.BagUser;
import com.Bag.models.BagUserRepository;
import com.Bag.request.OneDayRequest;
import com.Bag.request.RequestValidator;
import com.Bag.request.HeaderRequest;
import com.Bag.request.challenge.UpdateDailyChallengeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
@Component
public class ChallengeServiceImpl implements ChallengeService {

    @Autowired
    private BagUserRepository bagUserRepository;

    @Autowired
    private RequestValidator requestValidator;

    @Override
    public Object getAll() {
        return  bagUserRepository.findAll();
    }

    //this method is used only from the daily service never from controllers
    @Override
    public void newChallenge(HeaderRequest request) throws Exception {
        requestValidator.validate(request);

        BagUser bagUser = bagUserRepository.findByUsername(request.getUsername());

        bagUser.getChallengeMenu().addChallenge(getDateAsString(), new ChallengeGenerator().generateChallenge());

        bagUserRepository.save(bagUser);
    }

    @Override
    public void updateDailyChallenge(HeaderRequest headerRequest, UpdateDailyChallengeRequest updateDailyChallengeRequest) throws Exception {
        this.requestValidator.validate(headerRequest);
        this.requestValidator.validate(updateDailyChallengeRequest);


        BagUser bagUser = bagUserRepository.findByUsername(headerRequest.getUsername());
        bagUser.getChallengeMenu().getChallenge().get(getDateAsString()).setRepDone(updateDailyChallengeRequest.getRepDone());
        if(bagUser.getChallengeMenu().getChallenge().get(getDateAsString()).getRepDone()>=bagUser.getChallengeMenu().getChallenge().get(getDateAsString()).getChallengeRep()){
            bagUser.getChallengeMenu().getChallenge().get(getDateAsString()).setFinished(true);
        }else {
            bagUser.getChallengeMenu().getChallenge().get(getDateAsString()).setFinished(false);
        }

        bagUserRepository.save(bagUser);
    }

    @Override
    public Object getOneDayChallenge(HeaderRequest headerRequest, OneDayRequest oneDayRequest) throws Exception {
        requestValidator.validate(headerRequest);
        requestValidator.validate(oneDayRequest);


        //get today challenge if the date is empty string
        oneDayRequest.setDate((oneDayRequest.getDate().equals("")) ? getDateAsString() : oneDayRequest.getDate());
        return bagUserRepository.findByUsername(headerRequest.getUsername()).getChallengeMenu().getChallenge().get(oneDayRequest.getDate());
    }

    String getDateAsString(){
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
