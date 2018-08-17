package com.Bag.services.friends;

import com.Bag.models.BagUser;
import com.Bag.models.BagUserRepository;
import com.Bag.models.BagUserShort;
import com.Bag.request.OneDayRequest;
import com.Bag.request.RequestValidator;
import com.Bag.request.HeaderRequest;
import com.Bag.request.friends.AddFriendRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FriendsServiceImpl implements FriendsService {

    @Autowired
    private BagUserRepository bagUserRepository;

    @Autowired
    private RequestValidator requestValidator;

//    @Override
//    public Object getAllFriendsIds(String bagUserId) {
//        return bagUserRepository.findOne(bagUserId).getFriendsIds();
//    }

    @Override
    public Object getAllFriendsInfo(HeaderRequest headerRequest) throws Exception {
        requestValidator.validate(headerRequest);

        List<String> friendsIds = bagUserRepository.findByUsername(headerRequest.getUsername()).getFriendsIds();
        List<BagUserShort> shortList = new ArrayList<>();
        for (String id: friendsIds) {
            shortList.add(bagUserRepository.findOne(id).getShortInfo());
        }
        return shortList;
    }

    @Override
    public Object get(OneDayRequest oneDayRequest) {
        return null;
    }

    @Override
    public void addFriend(HeaderRequest headerRequest, AddFriendRequest addFriendRequest) throws Exception {
        this.requestValidator.validate(headerRequest);
        this.requestValidator.validate(addFriendRequest);

        BagUser bagUser = bagUserRepository.findByUsername(headerRequest.getUsername());
        bagUser.addFriend(addFriendRequest.getFriendId());

        bagUserRepository.save(bagUser);
    }

    @Override
    public Object removeFriend(String friendUsername) {
        return null;
    }
}
