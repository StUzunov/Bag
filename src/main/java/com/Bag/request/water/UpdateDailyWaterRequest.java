package com.Bag.request.water;

import com.Bag.request.Validated;
import com.Bag.request.ValidationResponse;

public class UpdateDailyWaterRequest implements Validated {

    private int quantity;

    @Override
    public ValidationResponse validate() {
        return ValidationResponse.OK;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
