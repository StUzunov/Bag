package com.Bag.services.user;

import com.Bag.models.BagUser;
import com.Bag.models.BagUserRepository;
import com.Bag.models.BagUserRoles;
import com.Bag.models.CustomRole;
import com.Bag.models.food.Food;
import com.Bag.models.water.Water;
import com.Bag.models.workout.Trainings;
import com.Bag.request.RequestValidator;
import com.Bag.request.user.CreateNewBagUserRequest;
import com.Bag.request.user.UpdateBagUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.*;

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

        BagUser bagUser = new BagUser();
                new BagUser(
                createNewBagUserRequest.getUsername(),
                createNewBagUserRequest.getPassword(),
                createNewBagUserRequest.getfName(), createNewBagUserRequest.getlName(),
                createNewBagUserRequest.getEmail(),
                new Trainings(new TreeMap<>()), new Food(new TreeMap<>()), new ArrayList<>(), new Water(new TreeMap<>()));

                Collection<CustomRole> roles = new ArrayList<CustomRole>();
                CustomRole customRole = new CustomRole();
                customRole.setAuthority(BagUserRoles.USER.toString());
                roles.add(customRole);

                bagUser.setAuthorities(roles);

        bagUserRepository.save(bagUser);
    }

    @Override
    public void updateBagUser(UpdateBagUserRequest updateBagUserRequest) throws Exception {
        this.requestValidator.validate(updateBagUserRequest);

        BagUser update = bagUserRepository.findByUsername(updateBagUserRequest.getUsername());
        update.setfName(updateBagUserRequest.getfName());
        update.setlName(updateBagUserRequest.getlName());
        update.setEmail(updateBagUserRequest.getEmail());

        bagUserRepository.save(update);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        BagUser user = bagUserRepository.findByUsername(s);

        if(user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return new BagUser(user);
    }
}
