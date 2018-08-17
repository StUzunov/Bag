package com.Bag.controllers;

import com.Bag.request.user.CreateNewBagUserRequest;
import com.Bag.request.user.UpdateBagUserRequest;
import com.Bag.services.user.BagUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class BagUserController extends Controller{

    @Autowired
    BagUserService bagUserService;

    public BagUserController() {}

    @RequestMapping(value = {"/all"}, method = RequestMethod.GET)
    public Object getAll(){
        return bagUserService.getAll();
    }

    @RequestMapping(value = {"/createNewBagUser"}, method = RequestMethod.POST)
    public void createNewBagUser(@RequestBody CreateNewBagUserRequest createNewBagUserRequest) throws Exception {
        bagUserService.createNewBagUser(createNewBagUserRequest);
    }


    @RequestMapping(value = "/updateBagUser", method = RequestMethod.POST)
    public void updateBagUser(@RequestBody UpdateBagUserRequest updateBagUserRequest) throws Exception {
        bagUserService.updateBagUser(updateBagUserRequest);
    }

//    @RequestMapping(value = "/getByUsername", method = RequestMethod.GET)
//    public UserDetails getByUsername(@AuthenticationPrincipal String s) throws Exception {
//        return bagUserService.loadUserByUsername(s);
//    }
}
