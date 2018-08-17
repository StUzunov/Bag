package com.Bag.services.user;

import com.Bag.request.user.CreateNewBagUserRequest;
import com.Bag.request.user.UpdateBagUserRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface BagUserService extends UserDetailsService {

    Object getAll();

    void createNewBagUser(CreateNewBagUserRequest createNewBagUserRequest) throws Exception;

    void updateBagUser(UpdateBagUserRequest updateBagUserRequest) throws Exception;
}
