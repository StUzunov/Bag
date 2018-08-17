package com.Bag.services;

import com.Bag.models.BagUser;
import com.Bag.models.BagUserRepository;
import com.Bag.models.enums.BagUserRoles;
import com.Bag.models.workout.Trainings;
import com.Bag.request.RequestValidator;
import com.Bag.request.user.CreateNewBagUserRequest;
import com.Bag.request.user.UpdateBagUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.TreeMap;

@Component
public class BagUserServiceImpl implements BagUserService {

    @Autowired
    private BagUserRepository bagUserRepository;

    @Autowired
    private RequestValidator requestValidator;

    @Override
    public Object getAll() {
        return  bagUserRepository.findAll();
    }

    @Override
    public void createNewBagUser(CreateNewBagUserRequest createNewBagUserRequest) throws Exception {
        this.requestValidator.validate(createNewBagUserRequest);

        BagUser bagUser = new BagUser(createNewBagUserRequest.getfName(), createNewBagUserRequest.getlName(),
                createNewBagUserRequest.getEmail(), BagUserRoles.USER, new Trainings(new TreeMap<>()));

        bagUserRepository.save(bagUser);
    }

    @Override
    public void updateBagUser(UpdateBagUserRequest updateBagUserRequest) throws Exception {
        this.requestValidator.validate(updateBagUserRequest);

        BagUser update = bagUserRepository.findOne(updateBagUserRequest.getId());
        update.setfName(updateBagUserRequest.getfName());
        update.setlName(updateBagUserRequest.getlName());
        update.setEmail(updateBagUserRequest.getEmail());

        bagUserRepository.save(update);
    }
}
