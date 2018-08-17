package com.Bag.request.friends;

import com.Bag.request.Validated;
import com.Bag.request.ValidationResponse;

public class AddFriendRequest implements Validated {

    private String friendId;

    public String getFriendId() {
        return friendId;
    }

    public void setFriendId(String friendId) {
        this.friendId = friendId;
    }

    @Override
    public ValidationResponse validate() {
        return ValidationResponse.OK;
    }
}
