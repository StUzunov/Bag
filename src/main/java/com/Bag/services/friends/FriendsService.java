package com.Bag.services.friends;

import com.Bag.request.OneDayRequest;
import com.Bag.request.HeaderRequest;
import com.Bag.request.friends.AddFriendRequest;

public interface FriendsService {

    //Object getAllFriendsIds(String bagUserId);

    Object getAllFriendsInfo(HeaderRequest headerRequest) throws Exception;

    Object get(OneDayRequest oneDayRequest);

    void addFriend(HeaderRequest headerRequest, AddFriendRequest addFriendRequest) throws Exception;

    Object removeFriend(String friendUsername);
}
