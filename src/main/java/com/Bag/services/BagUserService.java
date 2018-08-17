package com.Bag.services;

import com.Bag.request.user.CreateNewBagUserRequest;
import com.Bag.request.user.UpdateBagUserRequest;

public interface BagUserService {

    Object getAll();

    void createNewBagUser(CreateNewBagUserRequest createNewBagUserRequest) throws Exception;

    void updateBagUser(UpdateBagUserRequest updateBagUserRequest) throws Exception;
}
