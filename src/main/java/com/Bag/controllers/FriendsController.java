package com.Bag.controllers;

import com.Bag.request.HeaderRequest;
import com.Bag.request.friends.AddFriendRequest;
import com.Bag.services.friends.FriendsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/friends")
public class FriendsController extends Controller {

    @Autowired
    FriendsService friendsService;

    public FriendsController() {
    }

    @RequestMapping(value = "/getAllFriends", method = RequestMethod.POST)
    public Object getAllFriends(@RequestHeader HttpHeaders headers) throws Exception {
        HeaderRequest headerRequest = new HeaderRequest(decodeBase64(headers.get("authorization"))[0], decodeBase64(headers.get("authorization"))[1]);
        return friendsService.getAllFriendsInfo(headerRequest);
    }

    @RequestMapping(value = "/addFriend", method = RequestMethod.POST)
    public void addFriend(@RequestHeader HttpHeaders headers, @RequestBody AddFriendRequest addFriendRequest) throws Exception {
        HeaderRequest headerRequest = new HeaderRequest(decodeBase64(headers.get("authorization"))[0], decodeBase64(headers.get("authorization"))[1]);
        friendsService.addFriend(headerRequest, addFriendRequest);
    }
}
