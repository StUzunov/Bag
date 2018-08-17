package com.Bag.request.food;

import com.Bag.models.food.ServingEnum;
import com.Bag.request.Validated;
import com.Bag.request.ValidationResponse;

public class ServingRequest implements Validated {

    private ServingEnum servingEnum;
    private int quantity;

    @Override
    public ValidationResponse validate() {
        return ValidationResponse.OK;
    }

    public ServingEnum getServingEnum() {
        return servingEnum;
    }

    public void setServingEnum(ServingEnum servingEnum) {
        this.servingEnum = servingEnum;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
