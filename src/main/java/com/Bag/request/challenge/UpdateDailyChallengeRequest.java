package com.Bag.request.challenge;

import com.Bag.request.Validated;
import com.Bag.request.ValidationResponse;

public class UpdateDailyChallengeRequest implements Validated {

    private int repDone;

    public int getRepDone() {
        return repDone;
    }

    public void setRepDone(int repDone) {
        this.repDone = repDone;
    }

    @Override
    public ValidationResponse validate() {
        return ValidationResponse.OK;
    }
}
